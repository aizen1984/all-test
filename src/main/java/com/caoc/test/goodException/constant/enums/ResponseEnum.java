package com.caoc.test.goodException.constant.enums;

import com.caoc.test.goodException.asserts.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {

	/**
	 *
	 */
	BAD_LICENCE_TYPE(7001, "Bad licence type."),

	/**
	 *
	 */
	LICENCE_NOT_FOUND(7002, "Licence not found.");

	/**
	 * 返回码
	 */
	private int code;
	/**
	 * 返回消息
	 */
	private String message;
}
