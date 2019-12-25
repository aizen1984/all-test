package com.caoc.test.spring.listener;

import lombok.*;

/**
 * @author caochen
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class OpenAccountDoneBo {
	@NonNull
	private String name;
	@NonNull
	private String idCardNo;
}
