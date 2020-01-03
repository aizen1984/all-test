package com.caoc.test.shuhe.vo;

import com.alibaba.fastjson.JSON;

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

		OpenAccountCardConfig.SupportInfo supportInfo = new OpenAccountCardConfig.SupportInfo();

		supportInfo.setOpenFlag(true);
		supportInfo.setSupportList(list);
		supportInfo.setUnSupportList(new ArrayList<>());


		OpenAccountCardConfig.SupportInfo unSupportInfo = new OpenAccountCardConfig.SupportInfo();

		unSupportInfo.setOpenFlag(true);
		unSupportInfo.setSupportList(new ArrayList<>());
		unSupportInfo.setUnSupportList(new ArrayList<>());

		Map<String, OpenAccountCardConfig.SupportInfo> supportMap = new HashMap<>();
		supportMap.put("CREDIT", unSupportInfo);
		supportMap.put("DEBIT", supportInfo);


		OpenAccountCardConfig baixin = new OpenAccountCardConfig();
		baixin.setSupportInfoMap(supportMap);

		OpenAccountCardConfig weizhong = new OpenAccountCardConfig();
		weizhong.setSupportInfoMap(supportMap);


		Map<String, List<String>> unSupportMap2 = new HashMap<>(16);
		unSupportMap2.put("CREDIT", new ArrayList<>());
		unSupportMap2.put("DEBIT", new ArrayList<>());


		Map<String, OpenAccountCardConfig> map = new HashMap<>();
		map.put("BXBANK", baixin);
		map.put("WEBANK", weizhong);
		System.out.println(JSON.toJSONString(map));

	}
}
