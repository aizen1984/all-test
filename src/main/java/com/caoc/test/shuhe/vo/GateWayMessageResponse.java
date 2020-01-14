package com.caoc.test.shuhe.vo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GateWayMessageResponse implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 业务参数
	 */
	private String messageBody;

	/**
	 * 响应报文头部
	 */
	private MessageResponseHead head;
}
