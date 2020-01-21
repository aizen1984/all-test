package com.caoc.test.shuhe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BxCallResp {
	/**
	 * 状态码
	 * S 成功 F 失败
	 * */
	private String isSuccess;

	/**
	 * 响应代码
	 * */
	private String retCode;

	/**
	 * 响应消息
	 * */
	private String retMessage;

	/**
	 * 响应结果
	 * */
	private Object retResult;
}
