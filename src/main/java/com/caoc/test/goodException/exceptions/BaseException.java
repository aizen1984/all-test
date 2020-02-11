package com.caoc.test.goodException.exceptions;

import com.caoc.test.goodException.constant.enums.IResponseEnum;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**
	 * 返回码
	 */
	protected IResponseEnum responseEnum;

	protected Object[] args;

	public BaseException(IResponseEnum responseEnum) {
		super(responseEnum.getMessage());
		this.responseEnum = responseEnum;
	}


	public BaseException(int code, String msg) {
		super(msg);
		this.responseEnum = new IResponseEnum() {
			@Override
			public int getCode() {
				return code;
			}

			@Override
			public String getMessage() {
				return msg;
			}
		};
	}

	public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
		super(message);
		this.responseEnum = responseEnum;
		this.args = args;
	}

	public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
		super(message, cause);
		this.responseEnum = responseEnum;
		this.args = args;
	}


}
