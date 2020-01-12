package com.caoc.test.shuhe.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class OpenAccountBaseReq {
	@ApiModelProperty(value = "uid", required = true)
	private String uid;

	@ApiModelProperty(value = "开户银行名称", required = true)
	@NotNull
	private DebitAccountChannel bank;
}
