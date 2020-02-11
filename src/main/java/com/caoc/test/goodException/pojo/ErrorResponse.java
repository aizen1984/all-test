package com.caoc.test.goodException.pojo;

public class ErrorResponse extends BaseResponse {
	public ErrorResponse() {
	}

	public ErrorResponse(int code, String message) {
		super(code, message);
	}
}