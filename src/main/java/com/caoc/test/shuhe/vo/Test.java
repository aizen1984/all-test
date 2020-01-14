package com.caoc.test.shuhe.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;

/**
 * @author caochen
 */
public class Test {
	public static void main(String[] args) {
		String code = "";
		System.out.println(BxAccountTypeEnum.getAccountTypeByTypeCode(code));
		TestReq req = new TestReq();
		req.setBxAccountTypeEnum(BxAccountTypeEnum.getAccountTypeByTypeCode(code));
		if (req.getBxAccountTypeEnum() == null) {
			System.out.println("null");
		}
	}


	public static void testHistory() {
		OpenAccountReq req = new OpenAccountReq();
		req.setVcode("vcode");
		req.setMobile("13651699199");
		req.setSeqNo("11111111");
		req.setCardId("16047c02-1ce8-4cbf-b524-217012a9b383");
		req.setOpenAccountType(OpenAccountTypeEnum.MANUAL_OPEN_ACCOUNT);
		req.setUid("d67babc0-d4a5-46dc-8d33-d3030eb0b5b0");
		req.setBank(DebitAccountChannel.WEBANK);

		System.out.println(JSON.toJSONString(req));
	}

	public static void testAccType(){
		String json = "{\"head\":{\"code\":200,\"desc\":\"成功\",\"success\":true},\"messageBody\":\"{\\\"retMessage\\\":\\\"成功\\\",\\\"retResult\\\":{\\\"linkedBankCode\\\":\\\"103100000026\\\",\\\"acctStatus\\\":\\\"A\\\",\\\"openCardTime\\\":\\\"20200113 08:50:22\\\",\\\"linkedBankName\\\":\\\"中国农业银行股份有限公司\\\",\\\"linkedAcctNo\\\":\\\"6228***79\\\",\\\"combAcctNo\\\":\\\"7c4e097c-3d50-40df-91cd-dc748ed153a2\\\",\\\"customerId\\\":\\\"100033953458\\\",\\\"combAcctChildType\\\":\\\"XD001\\\",\\\"acctName\\\":\\\"付孝怀\\\",\\\"cardNo\\\":\\\"6236***85\\\",\\\"acctLevel\\\":\\\"03\\\",\\\"combAcctType\\\":\\\"XD\\\"},\\\"retCode\\\":\\\"00000000\\\",\\\"isSuccess\\\":\\\"S\\\"}\"}";
		GateWayMessageResponse gateWayMessageResponse = JSON.parseObject(json, GateWayMessageResponse.class);
		System.out.println(gateWayMessageResponse.getHead());
		JSONObject jsonObject = JSON.parseObject(gateWayMessageResponse.getMessageBody());
		if (MapUtils.isNotEmpty(jsonObject)) {
			JSONObject jsonObject1 = jsonObject.getJSONObject("retResult");
			//02 二类户 03 三类户
			String accType = jsonObject1.getString("accType");
			System.out.println(accType);

		}
		System.out.println(gateWayMessageResponse.getMessageBody());
	}


}
