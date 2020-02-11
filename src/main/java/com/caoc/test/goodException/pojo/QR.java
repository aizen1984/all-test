package com.caoc.test.goodException.pojo;

public class QR<T> extends QueryDataResponse<T> {
	public QR() {
		super();
	}

	public QR(QueryData<T> data) {
		super(data);
	}
}
