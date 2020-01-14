package com.caoc.test.shuhe.vo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseHead {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 标识调用网关,网关是否正常处理此次请求
	 */
	private boolean success;

	/**
	 * 标识调用网关返回结果的状态码
	 */
	private int code;

	/**
	 * 标识调用网关发生异常时的错误描述
	 */
	private String errorStr;

	/**
	 * 标识调用网关返回结果的的描述
	 */
	private String desc;

	/**
	 * 报文ID
	 */
	private String requestMsgId;
}
