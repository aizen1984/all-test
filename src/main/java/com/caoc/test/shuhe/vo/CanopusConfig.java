package com.caoc.test.shuhe.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caochen
 */
public class CanopusConfig {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		//工商银行
		list.add("工商银行");
		//农业银行
		list.add("农业银行");
		//中国银行
		list.add("中国银行");
		//建设银行
		list.add("建设银行");
		//邮储银行
		list.add("邮储银行");
		//招商银行
		list.add("招商银行");
		//民生银行
		list.add("民生银行");
		//光大银行
		list.add("光大银行");
		//兴业银行
		list.add("兴业银行");
		//平安银行
		list.add("平安银行");
		//广发银行
		list.add("广发银行");
		//中信银行
		list.add("中信银行");
		//交通银行
		list.add("交通银行");
		//浦发银行
		list.add("浦发银行");
		//上海银行
		list.add("上海银行");
		//华夏银行
		list.add("华夏银行");
		//北京银行
		list.add("北京银行");

		System.out.println(list.size());

		OpenAccountSupportCard.SupportInfo supportInfo = new OpenAccountSupportCard.SupportInfo();
		supportInfo.setOpenFlag(true);
		supportInfo.setSupportList(list);
		supportInfo.setUnSupportList(new ArrayList<>());


		OpenAccountSupportCard.SupportInfo unSupportInfo = new OpenAccountSupportCard.SupportInfo();
		unSupportInfo.setOpenFlag(true);
		unSupportInfo.setSupportList(new ArrayList<>());
		unSupportInfo.setUnSupportList(new ArrayList<>());


		Map<String, OpenAccountSupportCard.SupportInfo> supportMap = new HashMap<>();
		supportMap.put("CREDIT", unSupportInfo);
		supportMap.put("DEBIT", supportInfo);


		OpenAccountSupportCard baixin = new OpenAccountSupportCard();
		baixin.setSupportInfo(supportMap);


		OpenAccountSupportCard weizhong = new OpenAccountSupportCard();
		weizhong.setSupportInfo(supportMap);


		Map<String, OpenAccountSupportCard> openAccountSupportCardHashMap = new HashMap<>();
		openAccountSupportCardHashMap.put("BXBANK", baixin);
		openAccountSupportCardHashMap.put("WEBANK", weizhong);
		System.out.println(JSON.toJSONString(openAccountSupportCardHashMap, SerializerFeature.DisableCircularReferenceDetect));

		System.out.println(JSON.toJSON(baixin));


	}
}
