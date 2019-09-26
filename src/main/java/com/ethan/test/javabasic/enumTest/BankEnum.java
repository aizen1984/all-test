package com.ethan.test.javabasic.enumTest;

public enum BankEnum {
	BOSC("boscService", FundPayWay.SUPER_NET, "上海银行"),
	HFB("hfService", FundPayWay.SUPER_NET, "恒丰银行"),
	SELF("shuheService", FundPayWay.SUPER_NET, "数禾银行"),
	FOTIC("foticService", FundPayWay.SUPER_NET, "外贸信托"),
	ZYB("zybService", FundPayWay.SUPER_NET, "中原银行"),
	BQD("bqdService", FundPayWay.SUPER_NET, "青岛银行"),
	FOCUS_LOAN("focusLoanService", FundPayWay.SUPER_NET, "分众小贷"),
	FOCUS_LOAN_CORE("", FundPayWay.SUPER_NET, "分众小贷核心订单"),
	NOAH("noahService", FundPayWay.SUPER_NET, "诺亚财富"),
	CBHB("bohaiService", FundPayWay.SUPER_NET, "渤海银行"),
	ZAB("zhonganService", FundPayWay.SUPER_NET, "众安保险"),
	NUB("zhenxinService", FundPayWay.SUPER_NET, "振兴银行"),
	BOC("bocdockingService", FundPayWay.SUPER_NET, "中银消费金融"),
	ZYCFC("zycfcDockingService", FundPayWay.SUPER_NET, "中原消费金融"),
	ZRB("zrbProxyService", FundPayWay.SUPER_NET, "真融宝"),
	TEST_FUND("testFundService", FundPayWay.SUPER_NET, "测试资方"),
	QIHU360("qihuService", FundPayWay.SUPER_NET, "360借条"),
	BQD_V2("bqdV2Service", FundPayWay.SUPER_NET, "青岛银行v2"),
	TBJ("tbjdockingService", FundPayWay.SUPER_NET, "铜板街"),
	FENGJR_HEAVY("fengjrService", FundPayWay.SUPER_NET, "凤凰金融"),
	JDJR("jdjrService", FundPayWay.SUPER_NET, "京东金融"),
	JINDAN("jindanService", FundPayWay.SUPER_NET, "金蛋"),
	GUOTONG("guotongBankAppService", FundPayWay.SUPER_NET, "国通"),
	SSJ("ssjService", FundPayWay.SUPER_NET, "随手记"),
	CIBCF("cibcfService", FundPayWay.SUPER_NET, "小鲨易贷"),
	BQS("bqsProxyService", FundPayWay.SUPER_NET, "白骑士"),
	CITIC("citicService", FundPayWay.SUPER_NET, "中信"),
	YNTRUST("yntrustService", FundPayWay.SUPER_NET, "云南信托"),
	MSXF("msxfdockingService", FundPayWay.SUPER_NET, "马上消费金融"),
	BOSC_V2("boscV2Service", FundPayWay.SUPER_NET, "上海银行"),
	AJXT("ajxtdockingService", FundPayWay.SUPER_NET, "爱建信托"),
	HAIER("haierDockingService", FundPayWay.SUPER_NET, "海尔消费金融"),
	WACAI("wacaiDockingService", FundPayWay.SUPER_NET, "挖财"),
	HFB_V2("hfService", FundPayWay.SUPER_NET, "恒丰银行"),
	GUOMEI("guomeiService", FundPayWay.SUPER_NET, "国美"),
	SUNING("suningService", FundPayWay.SUPER_NET, "苏宁"),
	SELF_P2P("p2pService", FundPayWay.SUPER_NET, "自营p2p"),
	JXD("jxdDockingService", FundPayWay.SUPER_NET, "急现贷"),
	YY("yyService", FundPayWay.SUPER_NET, "YY金融"),
	WANDA("wandaDockingService", FundPayWay.SUPER_NET, "万达普惠"),
	WCXD("wcxdDockingService", FundPayWay.SUPER_NET, "信喜小贷"),
	BOBCFC("bobccfcDockingService",FundPayWay.SUPER_NET,"北银消金"),
	SNCFC("sncfcDockingService", FundPayWay.SUPER_NET, "苏宁消金"),
	MNW("manaowanService",FundPayWay.SUPER_NET,"玛瑙湾"),
	YUECAI("fundCoreService",FundPayWay.SUPER_NET,"粤财信托"),
	JXD_LIGHT("cnlightService",FundPayWay.SUPER_NET,"急现贷优享"),
	MSXFCFC("fundCoreService",FundPayWay.SUPER_NET,"马上消费金融股份有限公司"),
	XWYH("fundCoreService",FundPayWay.SUPER_NET,"新网银行"),
	CEBTRUST("fundCoreService",FundPayWay.SUPER_NET,"光大信托"),
	CITICCFC("fundCoreService",FundPayWay.SUPER_NET,"中信消金"),
	ZYXJ("fundCoreService",FundPayWay.SUPER_NET,"中原消金"),
	SSJ_JXD("ssjJxdDockingService",FundPayWay.SUPER_NET,"随手记急现贷"),
	FUMIN("ssjJxdDockingService",FundPayWay.SUPER_NET,"富民银行"),
	AIBANK("fundCoreService",FundPayWay.SUPER_NET,"百信银行"),
	JMX("fundCoreService",FundPayWay.SUPER_NET,"金美信信托"),
	ZBANK("fundCoreService", FundPayWay.SUPER_NET, "众邦银行"),
	FUQICBHB("ssjJxdDockingService",FundPayWay.SUPER_NET,"福琪渤海"),
	YHJR("yhjrService", FundPayWay.SUPER_NET, "永辉金融");

	private String implClass;
	private FundPayWay netWay;
	private String bankName;

	BankEnum(String implClass, FundPayWay netWay, String bankName) {
		this.implClass = implClass;
		this.netWay = netWay;
		this.bankName = bankName;
	}

	public String getImplClass() {
		return implClass;
	}

	public FundPayWay getNetWay() {
		return netWay;
	}

	public String getBankName() {
		return bankName;
	}
}
