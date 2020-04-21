//package cn.caijiajia.gatewayserver.test.sendMes;
//
//import cn.caijiajia.fundgwcommon.base.GateWayMessageRequest;
//import cn.caijiajia.fundgwserver.dto.MessageCommonContext;
//import cn.caijiajia.fundgwserver.handler.AbstractSendRequestHandler;
//import cn.caijiajia.fundgwserver.util.Encodes;
//import cn.caijiajia.fundgwserver.util.KeyUtil;
//import cn.caijiajia.fundgwserver.util.MD5Util;
//import cn.caijiajia.fundgwserver.util.SimpleCryptUtil;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.parser.Feature;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.nio.charset.Charset;
//import java.security.Key;
//import java.util.HashMap;
//import java.util.Map;
//
//class BaixinRequestHandler extends AbstractSendRequestHandler{
//    private static final String qianzhiCharset = "utf-8";
//    private static final String APPID = "HXH_001";
//    private static final String TOKENKEY = "bxToken";
//
//
//    @Autowired
//    private cn.caijiajia.fundgwserver.service.MessageTransmissionService transmissionService;
//
//
//    @Override
//    public String buildRequest(GateWayMessageRequest req, MessageCommonContext context) throws Exception {
//        String urlstr = context.getMessageProtocolDto().getCommunication().getUri();
//        String bodyStr = req.getMessageBody();
//        JSONObject jSONObject =JSON.parseObject(bodyStr);
//        context.getMessageProtocolDto().getCommunication().setUri(urlstr+"/" +jSONObject.getString("toSystemId") +"/" +jSONObject.getString("txCd") );
//        Map<String, Object> requestMap = new HashMap<String, Object>();
//        Map<String, String> headRequestMap = new HashMap<String, String>();
//        headRequestMap.put("Tx_CD", jSONObject.getString("txCd"));
//        headRequestMap.put("TxnSrlNo", System.currentTimeMillis() + "");
//        headRequestMap.put("App_Id", APPID);
//        headRequestMap.put("Format", "json");
//        headRequestMap.put("To_SysTem_ID", jSONObject.getString("toSystemId") );
//        headRequestMap.put("App_Auth_Token", getToken(false , APPID ,urlstr , context ));
//        headRequestMap.put("msg_type", "01");// 01正常交易
//        requestMap.put("head", headRequestMap);
//        jSONObject.remove("toSystemId");jSONObject.remove("txCd");
//        requestMap.put("body", jSONObject);
//        String json = JSONObject.toJSONString(requestMap);
//        System.out.println("加密前：" + json);
//        byte[] allmsg = json.getBytes("UTF-8");
//        Map obj = (Map) JSONObject.parseObject(allmsg, HashMap.class, new Feature[0]);
//        Map bodyMap = (Map) obj.get("body");
//        Map headMap = (Map) obj.get("head");
//        byte[] msg_content = JSONObject.toJSONBytes(bodyMap, new SerializerFeature[0]);
//        String md5 = MD5Util.encrypt(msg_content);
//        String sign = encryptionService.sign(context, md5.getBytes(Charset.forName(qianzhiCharset)));
//        String msg_contentStr = encryptionService.encryption(context, msg_content);
//        bodyMap = new HashMap();
//        headMap.put("Sign", sign);
//        bodyMap.put("msg_content", msg_contentStr);
//        obj.put("body", bodyMap);
//        String encryJson = new String(JSONObject.toJSONBytes(obj, new SerializerFeature[0]), Charset.forName(qianzhiCharset));
//        return encryJson;
//    }
//
//
//    private String getToken(boolean update,String appId,String url , MessageCommonContext context) throws Exception{
//        String token = redisClient.get(TOKENKEY);
////如果有token且token不强制更新，则返回旧token
//        if(!StringUtils.isBlank(token)&&!update){
//            return token;
//        }
//        Map<String,Object> loginMap = new HashMap<String,Object>();
//        Map<String,String> loginHead = new HashMap<String,String>();
//        Map<String,String> loginBody = new HashMap<String,String>();
//        loginHead.put("App_Id", appId);
//        loginHead.put("Format", "json");
//        loginHead.put("App_Auth_Token", "token");
//        loginHead.put("Charset", qianzhiCharset);
//        loginHead.put("msg_type", "02");
//        loginMap.put("head",loginHead);
//        loginMap.put("body",loginBody);
//        loginBody.put("name", appId);
//        String loginPd = "";
//        Key key = KeyUtil.getSecretKeyByBase64String(Encodes.decodeBase64("hl5Dtvsf1gjq8hCwE+lUFqjl7yYcQNPy"));
//        try {
//            loginPd = SimpleCryptUtil.encrypt("123456",qianzhiCharset,key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        loginBody.put("password", loginPd);
//        String encryStr = new String( encrypt(context , JSONObject.toJSONString(loginMap).getBytes(qianzhiCharset)), Charset.forName("UTF-8"));
//        String loginResult = transmissionService.sendMessage(context , encryStr,url, new HashMap<>());
//        Map<String,Object> resultMap = JSONObject.parseObject(loginResult, Map.class);
//        Map<String,String> headMap = (Map<String,String>)resultMap.get("head");
//        token =headMap.get("App_Auth_Token");
//        redisClient.set(TOKENKEY,token);
//        return token;
//    }
//
//    private byte[] encrypt( MessageCommonContext context , byte[] allmsg) throws Exception {
//        if (allmsg != null && allmsg.length > 0) {
//            Map obj = (Map)JSONObject.parseObject(allmsg, HashMap.class, new Feature[0]);
//            Map body = (Map)obj.get("body");
//            Map head = (Map)obj.get("head");
//            byte[] msg_content = JSONObject.toJSONBytes(body, new SerializerFeature[0]);
//            String md5 = MD5Util.encrypt(msg_content);
//            String sign = "";
//            sign = encryptionService.sign(context ,md5.getBytes(Charset.forName(qianzhiCharset)) );
//            String msg_contentStr = encryptionService.encryption(context, msg_content);
//            body = new HashMap();
//            head.put("Sign", sign);
//            body.put("msg_content", msg_contentStr);
//            obj.put("body", body);
//            return JSONObject.toJSONBytes(obj, new SerializerFeature[0]);
//        } else {
//            return allmsg;
//        }
//    }
//}