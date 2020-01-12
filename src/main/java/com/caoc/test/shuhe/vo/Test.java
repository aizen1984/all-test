package com.caoc.test.shuhe.vo;

import com.alibaba.fastjson.JSON;

/**
 * @author caochen
 */
public class Test {
	public static void main(String[] args) {
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
