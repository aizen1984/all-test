package com.caoc.test.shuhe.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author caochen
 */
@Data
public class OpenAccountCardConfig {
	private Map<String, SupportInfo> supportInfo;


	@Data
	public static class SupportInfo {
		private boolean openFlag;
		private List<String> supportList;
		private List<String> unSupportList;
	}

}


