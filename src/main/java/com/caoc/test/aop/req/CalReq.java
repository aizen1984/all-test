package com.caoc.test.aop.req;

import com.caoc.test.aop.domain.NeedAspectType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalReq implements NeedAspectType {
	private int id;
	private String name;
}
