package com.caoc.test.goodException.exceptions;

import com.caoc.test.goodException.constant.enums.IResponseEnum;

public class BusinessException extends BaseException {

	private static final long serialVersionUID = 1L;

	public BusinessException(IResponseEnum responseEnum, Object[] args, String message) {
		super(responseEnum, args, message);
	}

	public BusinessException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
		super(responseEnum, args, message, cause);
	}
}
