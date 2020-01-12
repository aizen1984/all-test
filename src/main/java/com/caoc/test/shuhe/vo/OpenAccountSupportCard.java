package com.caoc.test.shuhe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caochen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenAccountSupportCard {
	private Map<String, SupportInfo> supportInfo;


	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SupportInfo {
		private boolean openFlag;
		private List<String> supportList;
		private List<String> unSupportList;
	}
}


