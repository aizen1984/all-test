package com.caoc.test.goodException.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CommonResponse<T> extends BaseResponse {
	protected T data;

	public CommonResponse() {
		super();
	}

	public CommonResponse(T data) {
		super();
		this.data = data;
	}
}
