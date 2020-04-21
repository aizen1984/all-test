//package cn.caijiajia.gatewayserver.test.sendMes;
//
//import cn.caijiajia.fundgwserver.dto.MessageCommonContext;
//import cn.caijiajia.fundgwserver.handler.AbstractSendResponseHandler;
//import cn.caijiajia.fundgwserver.util.MD5Util;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.parser.Feature;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//
//import javax.xml.bind.DatatypeConverter;
//import java.nio.charset.Charset;
//import java.util.HashMap;
//import java.util.Map;
//
//class BaixinResponseHandler extends AbstractSendResponseHandler{
//
//    private static final String qianzhiCharset = "utf-8";
//
//
//    @Override
//    public String buildResponse(String result, MessageCommonContext context) throws Exception {
//// TODO Auto-generated method stub
//        byte[] allMsg = result.getBytes("UTF-8");
//        Map objresult = (Map) JSONObject.parseObject(allMsg, HashMap.class, new Feature[0]);
//        Map bodyresult = (Map) objresult.get("body");
//        Map headresult = (Map) objresult.get("head");
//        byte[] msg_content_byte = cn.caijiajia.fundgwserver.util.Encodes.decodeBase64(bodyresult.get("msg_content").toString());
//        String signresult = headresult.get("Sign").toString();
//        String msg_content_Str = encryptionService.decryption(context, msg_content_byte);
//        String md5result = MD5Util.encrypt(msg_content_Str.getBytes());
//        boolean ok = encryptionService.verify(context, md5result.getBytes(qianzhiCharset),
//                DatatypeConverter.parseBase64Binary(signresult));
//        bodyresult = (Map) JSONObject.parseObject(msg_content_Str, HashMap.class, new Feature[0]);
//        objresult.put("body", bodyresult);
//        String decryptJson = new String(JSONObject.toJSONBytes(objresult, new SerializerFeature[0]),
//                Charset.forName("UTF-8"));
//        return JSONObject.parseObject(decryptJson).getString("body");
//    }
//}