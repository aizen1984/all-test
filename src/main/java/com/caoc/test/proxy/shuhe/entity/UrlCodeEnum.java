package com.caoc.test.proxy.shuhe.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UrlCodeEnum {
	acctverify("100008", "账户验证"),
	transquery("100003", "单笔实时查询"),
	settleacctquery("100004", "中间账户查询"),
	crtransfer("100001", "单笔转入"),
	drtransfer("100002", "单笔转出"),
	transfercallback("100005", "确认回执（反向通知）"),
	transferreverse("100006", "冲正"),
	settlefileinfo("100007", "对账文件通知"),
	dateswitchinfo("100010", "日切通知"),
	linetest("100011", "通讯线路测试"),
	notifyAcctInfo("100012", "开户申请"),
	queryBalance("100013", "账户余额查询"),
	queryRiskInfo("100014", "风评结果查询"),
	syncRiskInfo("100015", "风评信息同步"),
	cardPasswordAuth("100016", "银行卡密码验证"),
	queryCardInfos("100017", "客户银行卡信息查询"),
	signInfoNotify("100018", "签约信息同步"),
	queryCloseAcctFlag("100019", "销户查询"),
	cardStatusNotify("100020", "卡状态同步"),
	accountOpenedNotify("100021", "开户通知"),
	crtransferPlus("100022", "活期+扣款"),
	queryCustomerInfo("100023", "存量客户查询"),
	queryFinancialProducts("100024", "理财产品查询"),
	crtransfer_syn("100026", "单笔转入(同步)"),
	drtransfer_syn("100027", "单笔转出（同步）"),
	updatePhoneNo("100025", "客户手机号修改"),
	crtransferPlus_syn("100028", "活期+扣款(同步)"),
	queryAssetsInfo("100029", "客户理财资产查询"),
	accountInfoQueryToken("100030", "客户信息查询及鉴权"),
	accountSucessNotify("100031", "开户成功通知（账户+）"),
	auditFailNotify("100032", "异步审核结果通知"),
	consume("100033", "消费扣款"),
	consumeReverse("100034", "消费撤单"),
	consumeQuery("100035", "消费查询"),
	certUploadNotify("100036", "身份证上传"),
	accontQuery("100037", "账户信息查询（账户+）"),
	debit("100038", "申购/撤销代扣"),
	debitQuery("100039", "申购/撤销代扣时查询"),
	refund("100040", "消费退货"),
	orgOpenAcctApply("100041", "开户请求（账户+）"),
	accountRiskInfoQuery("100042", "查询合作机构客户风控信息"),
	querySecondCardBalance("100043", "二类户余额查询"),
	verifyPassword("100044", "验密,密码验证串校验"),
	consumeReverseCancel("100045", "消费退货冲正"),
	customerIdImagesQuery("100046", "客户影像信息查询"),
	nonbankPasswordAuth("100047", "非银机构密码验证"),
	customerRiskLevelSync("100048", "客户风评信息同步"),
	creditCardRepay("100049", "信用卡还款"),
	otpSend("100050", "OTP发送申请"),
	creditCardRepayQuery("100052", "信用卡还款查询/信用卡还款实时查询"),
	creditCardRepayCallback("100051", "信用卡还款结果通知"),
	bindCardVerify("100053", "绑卡鉴权"),
	consumeDeduct("100059", "消费扣款(对方发起)"),
	consumeRefund("100060", "消费退货(对方发起)"),
	passwordVerify("100061", "密码验证(对方发起)"),
	custInfoVerify("100062", "客户信息鉴权"),
	creditCardOrderRepay("100063", "信用卡预约还款"),
	creditCardOrderRepayCancel("100064", "信用卡预约还款取消/信用卡预约还款撤销"),
	creditCardOrderRepayExecute("100065", "信用卡预约还款执行"),
	creditCardOrderRepayCallback("100067", "信用卡预约还款结果通知/信用卡预约还款异步通知"),
	creditCardOrderRepayQuery("100066", "信用卡预约还款结果查询/信用卡预约还款查询"),
	chargeAndConSumeAndReturnCallback("100069", "充值/消费/退货结果通知"),
	charge("100071", "充值"),
	chargeAndConSumeAndReturnQuery("100070", "充值/消费/退货结果查询"),
	idCardUpload("100076", "身份证上传");

	private final String code;
	private final String desc;
}
