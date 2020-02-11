package com.caoc.test.goodException.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class QueryDataResponse<T> extends CommonResponse<QueryData<T>> {
	public QueryDataResponse() {
	}

	public QueryDataResponse(QueryData<T> data) {
		super(data);
	}
}
