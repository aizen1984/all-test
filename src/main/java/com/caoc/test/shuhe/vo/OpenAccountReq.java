package com.caoc.test.shuhe.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(description = "开户")
public class OpenAccountReq extends OpenAccountBaseReq {
	@ApiModelProperty(value = "动码", required = true)
	@NotNull
	private String vcode;

	@ApiModelProperty(value = "手机号", required = true)
	@NotBlank
	@Size(min = 11,max = 11)
	private String mobile;

	@ApiModelProperty(value = "动码流水号,暂时无用", required = true)
	@NotBlank
	private String seqNo;

	@ApiModelProperty(value = "卡ID", required = true)
	@NotBlank
	private String cardId;

	@ApiModelProperty(value = "开户类型")
	private OpenAccountTypeEnum openAccountType;
}
