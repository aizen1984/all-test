package com.caoc.test.goodException.pojo;

import com.caoc.test.goodException.constant.enums.CommonResponseEnum;
import com.caoc.test.goodException.constant.enums.IResponseEnum;
import lombok.Data;

@Data
public class BaseResponse {
	/**
	 * 返回码
	 */
	protected int code;
	/**
	 * 返回消息
	 */
	protected String message;

	public BaseResponse() {
		this(CommonResponseEnum.SUCCESS);
	}

	public BaseResponse(IResponseEnum iResponseEnum) {
		this(iResponseEnum.getCode(), iResponseEnum.getMessage());
	}

	public BaseResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

}
