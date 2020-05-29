package com.caoc.test.javabasic.enumTest;

import java.math.BigDecimal;

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(OrderTypeEnum.CHILD.getDescription());



//		System.out.println(BankEnum.valueOf("BQD_V2").getClass().getSimpleName());
//
//		String str = "12";
//		System.out.println(str.length()>3?str.substring(0,3):str);
//		String str2 = "{\"account\":{\"accountNo\":\"010100166201\",\"availableLimit\":954310193,\"businessType\":\"BALANCE_TRANSFER\",\"createdAt\":1563957317000,\"customerNo\":\"0101001662\",\"feeRateInfoList\":[{\"annualFeeRate\":30.5,\"dayInterestRate\":0.0,\"discountRate\":5.48,\"drawCashFeeRate\":0.0,\"earlySettleFeeRate\":0.0,\"feeRate\":0.00458,\"groupId\":3,\"interestRate\":0.01,\"lateFeeRate\":0.05,\"productId\":3,\"stage\":12},{\"annualFeeRate\":10.0,\"dayInterestRate\":0.0,\"discountRate\":5.48,\"drawCashFeeRate\":0.0,\"earlySettleFeeRate\":0.04,\"feeRate\":0.00557,\"groupId\":618,\"interestRate\":0.01,\"lateFeeRate\":0.05,\"productId\":3,\"stage\":12},{\"annualFeeRate\":33.0,\"dayInterestRate\":0.0,\"discountRate\":5.48,\"drawCashFeeRate\":0.0,\"earlySettleFeeRate\":0.0,\"feeRate\":0.002,\"groupId\":1,\"interestRate\":0.01,\"lateFeeRate\":0.05,\"productId\":3,\"stage\":3},{\"annualFeeRate\":10.2,\"dayInterestRate\":0.0,\"discountRate\":5.48,\"drawCashFeeRate\":0.0,\"earlySettleFeeRate\":0.0,\"feeRate\":0.00457,\"groupId\":2,\"interestRate\":0.01,\"lateFeeRate\":0.05,\"productId\":3,\"stage\":6},{\"annualFeeRate\":10.0,\"dayInterestRate\":0.0,\"discountRate\":5.48,\"drawCashFeeRate\":0.0,\"earlySettleFeeRate\":0.04,\"feeRate\":0.00558,\"groupId\":617,\"interestRate\":0.01,\"lateFeeRate\":0.05,\"productId\":3,\"stage\":12}],\"identificationNo\":\"512324197212051330\",\"limit\":1015800000,\"mobile\":\"13120767761\",\"name\":\"黄节林\",\"uid\":\"d67babc0-d4a5-46dc-8d33-d3030eb0b5b0\"},\"accountType\":\"BALANCE_TRANSFER\",\"annualFeeRate\":24,\"applyTime\":1590634087320,\"assetBank\":\"BOSC_V2\",\"assetProductId\":\"BOSC_V2\",\"availableLimit\":954310193,\"bizSerial\":\"12620414-14bf-4273-bc1b-cdbd335ea000\",\"businessType\":\"BALANCE_TRANSFER\",\"extField\":{\"loanLifeToken\":\"d8878f5c-e918-4d23-9b8b-017fd5a6efd3\",\"submitTradeNo\":\"d8878f5c-e918-4d23-9b8b-017fd5a6efd3\"},\"feeRate\":0.850000,\"firstBizSerial\":\"12620414-14bf-4273-bc1b-cdbd335ea000\",\"firstLendCard\":{\"bankName\":\"建设银行\",\"baofuBankCode\":\"CCB\",\"bindStatus\":\"1\",\"cardBin\":\"621700\",\"cardId\":\"7885483b-be77-4413-8445-8db7b51a3c81\",\"cardName\":\"龙卡通\",\"cardNo\":\"6217001830003311111\",\"cardType\":\"DEBIT\",\"createdAt\":1536820563000,\"default\":false,\"functions\":\"[]\",\"fundttBankCode\":\"005\",\"length\":19,\"mobile\":\"13120767761\",\"repaymentDay\":\"\",\"uid\":\"d67babc0-d4a5-46dc-8d33-d3030eb0b5b0\",\"unipayBankCode\":\"01050000\",\"updatedAt\":1586836194000},\"ignoreLimit\":true,\"isFirstLend\":false,\"leGenCusOrderNo\":\"0100166205S38887\",\"leGenOrderNo\":\"BT202005281000002\",\"lendAmount\":100000,\"lendAt\":1590634087320,\"lendCard\":{\"$ref\":\"$.firstLendCard\"},\"lendSource\":\"APP\",\"lendType\":\"LOAN\",\"limit\":1015800000,\"needNewPipe\":true,\"newRouteFlag\":false,\"parentBizSerial\":\"12620414-14bf-4273-bc1b-cdbd335ea000\",\"pollingHold\":false,\"repayCard\":{\"$ref\":\"$.firstLendCard\"},\"sendMsg\":false,\"stage\":6,\"uid\":\"d67babc0-d4a5-46dc-8d33-d3030eb0b5b0\",\"user\":{\"academic\":\"高中\",\"address\":\"上海市上海市浦东新区居里路357号\",\"auditMobile\":\"17600039987\",\"auditStatus\":\"ACCEPTED\",\"cardValidDate\":\"2008.11.22-2028.11.22\",\"channel\":\"HNB\",\"city\":\"上海市\",\"closeMobile\":\"18351924856\",\"closeName\":\"880\",\"commonMobile\":\"18701862237\",\"commonName\":\"Emily\",\"companyName\":\"数禾\",\"countryTown\":\"江宁区\",\"createdAt\":1514880593000,\"creditCardNo\":\"6259655533117715\",\"email\":\"shuiyajuan@lattebank.com\",\"fundSource\":\"HFB\",\"idCardBack\":\"2748ff9f-1515-4f03-876a-fb71bc105f62\",\"idCardFront\":\"c7588a86-d545-44cf-b90c-6212726dae3a\",\"identAddress\":\"重庆市丰都县董家镇董家场村1组\",\"identificationNo\":\"512324197212051338\",\"issueGroup\":\"丰都县公安局\",\"latest3MonthSameLBSApplyCount\":0,\"marriage\":\"未婚\",\"meridian\":\"121.596878481389\",\"mobile\":\"13120767761\",\"name\":\"黄节林\",\"parallel\":\"31.20881128987766\",\"product\":\"BALANCE_TRANSFER\",\"province\":\"上海市\",\"sameDeviceBssiCount\":0,\"sameDeviceUserCount\":0,\"sensitiveUserContactCount\":0,\"thirdApplyInfo\":\"[{\\\"name\\\":\\\"question1\\\",\\\"length\\\":\\\"30\\\",\\\"answers\\\":\\\"1千以下,1-3千,3-5千,5千-1万,1-2万,2万及以上\\\",\\\"title\\\":\\\"平均月收入\\\",\\\"type\\\":\\\"radio\\\",\\\"prompt\\\":\\\"请选择您的税后月收入范围\\\",\\\"value\\\":\\\"1千以下\\\"}]\",\"uid\":\"d67babc0-d4a5-46dc-8d33-d3030eb0b5b0\",\"updatedAt\":1587030027000,\"userContactCount\":642,\"virtual\":false}} ";
//		String syncPayBo = "{\"firstLendCard\":{\"fromAppName\":\"hb\",\"cardName\":\"E时代卡\",\"functions\":\"[BALANCE_TRANSFER]\",\"bankName\":\"工商银行\",\"cardNo\":\"6222024679467949461\",\"createdAt\":1588850211000,\"uid\":\"b50f5ed2-2736-4adc-a09f-46be8a356a3c\",\"default\":false,\"cardBin\":\"622202\",\"fundttBankCode\":\"002\",\"bindStatus\":\"1\",\"updatedAt\":1588850211000,\"unipayBankCode\":\"01020000\",\"baofuBankCode\":\"ICBC\",\"length\":19,\"cardType\":\"DEBIT\",\"mobile\":\"13495595984\",\"cardId\":\"faf733c4-40d5-419d-bd78-5c2f0c5790a5\"},\"lendTransId\":\"34f54504-3222-4e34-a3ce-707fdb4b46f7\",\"groupId\":6,\"newRouteFlag\":true,\"leGenOrderNo\":\"CH202005251000134\",\"firstOrderNo\":\"CH202005251000134\",\"leGenCusOrderNo\":\"6158995605P68797\",\"lendAt\":1590404797282,\"eventNo\":\"3f8fb838-d7de-4bba-b107-53220e88fc5c\",\"assetBank\":\"ZJRCBANK\",\"isFirstLend\":false,\"pollingHold\":false,\"limit\":13000000,\"extField\":{\"loanLifeToken\":\"8435a053-f291-48ff-b836-0f9f4e085eac\",\"lendV2Flag\":\"1\",\"submitTradeNo\":\"8435a053-f291-48ff-b836-0f9f4e085eac\"},\"applyTime\":1590404797282,\"repayCard\":{\"fromAppName\":\"hb\",\"cardName\":\"E时代卡\",\"functions\":\"[BALANCE_TRANSFER]\",\"bankName\":\"工商银行\",\"cardNo\":\"6222024679467949461\",\"createdAt\":1588850211000,\"uid\":\"b50f5ed2-2736-4adc-a09f-46be8a356a3c\",\"default\":false,\"cardBin\":\"622202\",\"fundttBankCode\":\"002\",\"bindStatus\":\"1\",\"updatedAt\":1588850211000,\"unipayBankCode\":\"01020000\",\"baofuBankCode\":\"ICBC\",\"length\":19,\"cardType\":\"DEBIT\",\"mobile\":\"13495595984\",\"cardId\":\"faf733c4-40d5-419d-bd78-5c2f0c5790a5\"},\"needNewPipe\":true,\"orderNo\":\"CH202005251000134\",\"productId\":4,\"accountType\":\"CASH\",\"ignoreLimit\":true,\"assetProductId\":\"ZJRCBANK\",\"lendCard\":{\"fromAppName\":\"hb\",\"cardName\":\"E时代卡\",\"functions\":\"[BALANCE_TRANSFER]\",\"bankName\":\"工商银行\",\"cardNo\":\"6222024679467949461\",\"createdAt\":1588850211000,\"uid\":\"b50f5ed2-2736-4adc-a09f-46be8a356a3c\",\"default\":false,\"cardBin\":\"622202\",\"fundttBankCode\":\"002\",\"bindStatus\":\"1\",\"updatedAt\":1588850211000,\"unipayBankCode\":\"01020000\",\"baofuBankCode\":\"ICBC\",\"length\":19,\"cardType\":\"DEBIT\",\"mobile\":\"13495595984\",\"cardId\":\"faf733c4-40d5-419d-bd78-5c2f0c5790a5\"},\"lendPurpose\":\"3\",\"bizSerial\":\"8435a053-f291-48ff-b836-0f9f4e085eac\",\"lendSource\":\"HB_CASH\",\"feeRate\":0.833333,\"firstBizSerial\":\"8435a053-f291-48ff-b836-0f9f4e085eac\",\"uid\":\"b50f5ed2-2736-4adc-a09f-46be8a356a3c\",\"sendMsg\":false,\"lv2PreAvailableLimit\":12800000,\"annualFeeRate\":10.0,\"lendAmount\":100000,\"lv1PreAvailableLimit\":12400000,\"availableLimit\":12400000,\"stage\":12,\"lendType\":\"LOAN\",\"businessType\":\"CASH\",\"user\":{\"commonName\":\"还好还好哈\",\"sameDeviceBssiCount\":0,\"creditCardNo\":\"4026745659464949\",\"companyName\":\"哦随意\",\"identAddress\":\"新疆若羌县米兰镇36团园丁路27栋1号\",\"channel\":\"HNB\",\"auditMobile\":\"15812120330\",\"createdAt\":1588850125000,\"issueGroup\":\"上海市公安局徐汇分局\",\"province\":\"上海市\",\"academic\":\"硕士\",\"closeName\":\"测试姑\",\"updatedAt\":1589176474000,\"countryTown\":\"浦东新区\",\"name\":\"张洁珺瑶\",\"sameDeviceUserCount\":0,\"virtual\":false,\"userContactCount\":11,\"city\":\"上海市\",\"thirdApplyInfo\":\"[{\\\"name\\\":\\\"question1\\\",\\\"length\\\":\\\"30\\\",\\\"answers\\\":\\\"1千以下,1-3千,3-5千,5千-1万,1-2万,2万及以上\\\",\\\"title\\\":\\\"平均月收入\\\",\\\"type\\\":\\\"radio\\\",\\\"prompt\\\":\\\"请选择您的税后月收入范围\\\",\\\"value\\\":\\\"1千以下\\\"},{\\\"name\\\":\\\"question2\\\",\\\"length\\\":\\\"30\\\",\\\"answers\\\":\\\"装修,婚庆,旅游,教育,租房,医疗,汽车周边,电子数码1\\\",\\\"optional\\\":true,\\\"title\\\":\\\"贷款用途\\\",\\\"type\\\":\\\"radio\\\",\\\"prompt\\\":\\\"请选择您的贷款用途\\\",\\\"value\\\":\\\"装修\\\"},{\\\"name\\\":\\\"creditLimit\\\",\\\"length\\\":\\\"30\\\",\\\"answers\\\":\\\"无信用卡,5千以下,5千-1万,1-2万,2-3万,3-5万,5万及以上\\\",\\\"optional\\\":true,\\\"title\\\":\\\"信用卡额度\\\",\\\"type\\\":\\\"radio\\\",\\\"prompt\\\":\\\"请选择您的信用卡额度\\\"},{\\\"linkageInfo\\\":[{\\\"name\\\":\\\"companyName\\\",\\\"length\\\":\\\"30\\\",\\\"linkage\\\":\\\"企业\\\",\\\"type\\\":\\\"input\\\",\\\"title\\\":\\\"公司名称\\\",\\\"prompt\\\":\\\"请输入公司名称，若无填“个人”\\\"},{\\\"name\\\":\\\"companyName\\\",\\\"length\\\":\\\"30\\\",\\\"linkage\\\":\\\"事业\\\",\\\"type\\\":\\\"input\\\",\\\"title\\\":\\\"公司名称\\\",\\\"prompt\\\":\\\"请输入公司名称，若无填“个人”\\\"},{\\\"name\\\":\\\"companyName\\\",\\\"length\\\":\\\"30\\\",\\\"linkage\\\":\\\"政府\\\",\\\"type\\\":\\\"input\\\",\\\"title\\\":\\\"职业性质\\\",\\\"prompt\\\":\\\"请输入职业性质\\\"},{\\\"name\\\":\\\"companyName\\\",\\\"length\\\":\\\"30\\\",\\\"linkage\\\":\\\"个人\\\",\\\"type\\\":\\\"input\\\",\\\"title\\\":\\\"职业类型\\\",\\\"prompt\\\":\\\"例：网店老板/律师/自由职业者/无业游民\\\"},{\\\"name\\\":\\\"companyName\\\",\\\"length";

//		System.out.println(str2.length());
//		System.out.println(syncPayBo.length());
//		BigDecimal a = new BigDecimal(1.01);
//		BigDecimal b = new BigDecimal(1.02);
//		BigDecimal c = new BigDecimal("1.01");
//		BigDecimal d = new BigDecimal("1.02");
//		System.out.println(a.add(b));
//		System.out.println(c.add(d));

//		try {
//			new Thread(()->{
//				System.out.println(1/0);
//			}).start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		String str = null;
		StringBuilder sb = new StringBuilder();
		sb.append("1").append(str);
		System.out.println(sb.toString());


	}
}
