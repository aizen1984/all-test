package com.caoc.test.goodException.pojo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class R<T> extends CommonResponse<T> {
	public R() {
		super();
	}

	public R(T data) {
		super();
		this.data = data;
	}

	public R(T data, String msg) {
		super();
		this.data = data;
		this.message = msg;
	}

	public R(Throwable e) {
		super();
		this.message = e.getMessage();
		this.code = -1;
	}
}
