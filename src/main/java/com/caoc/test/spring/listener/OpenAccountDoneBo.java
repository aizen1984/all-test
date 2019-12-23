package com.caoc.test.spring.listener;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author caochen
 */
@NoArgsConstructor
@Data
public class OpenAccountDoneBo {
	@NonNull
	private String name;
	@NonNull
	private String idCardNo;
}
