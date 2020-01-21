package com.caoc.test.shuhe.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;

/**
 * @author caochen
 */
public class Test {
	public static void main(String[] args) {
		testAccType();
	}

	public static void testAccType() {
		String json = "{\n" +
				"\t\"head\": {\n" +
				"\t\t\"code\": 200,\n" +
				"\t\t\"desc\": \"成功\",\n" +
				"\t\t\"success\": true\n" +
				"\t},\n" +
				"\t\"messageBody\": \"{\\\"retMessage\\\":\\\"成功\\\",\\\"retResult\\\":{\\\"linkedBankCode\\\":\\\"102100099996\\\",\\\"acctStatus\\\":\\\"A\\\",\\\"openCardTime\\\":\\\"20200114 17:15:22\\\",\\\"linkedBankName\\\":\\\"中国工商银行\\\",\\\"linkedAcctNo\\\":\\\"6215***58\\\",\\\"combAcctNo\\\":\\\"6772afa0-1bda-4e9e-80d7-90c4d834bfc4\\\",\\\"customerId\\\":\\\"100038494660\\\",\\\"combAcctChildType\\\":\\\"XD001\\\",\\\"acctName\\\":\\\"张涛\\\",\\\"cardNo\\\":\\\"6236***78\\\",\\\"acctLevel\\\":\\\"03\\\",\\\"combAcctType\\\":\\\"XD\\\"},\\\"retCode\\\":\\\"00000000\\\",\\\"isSuccess\\\":\\\"S\\\"}\"\n" +
				"}";
		GateWayMessageResponse gateWayMessageResponse = JSON.parseObject(json, GateWayMessageResponse.class);
//		System.out.println(gateWayMessageResponse.getHead());
//		JSONObject jsonObject = JSON.parseObject(gateWayMessageResponse.getMessageBody());
//		if (MapUtils.isNotEmpty(jsonObject)) {
//			JSONObject jsonObject1 = jsonObject.getJSONObject("retResult");
//			//02 二类户 03 三类户
//			String accType = jsonObject1.getString("accType");
//			System.out.println(accType);
//
//		}
		BxCallResp resp = JSON.parseObject(gateWayMessageResponse.getMessageBody(), BxCallResp.class);
		System.out.println(JSON.toJSON(resp));
	}


	public static void testEnum() {
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


}
