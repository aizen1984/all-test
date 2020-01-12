package com.caoc.test.shuhe.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DebitAccountChannel {
	WEBANK("weBankServiceImpl", "微众银行", "01"),
	BXBANK("NONE", "百信银行", "02");


	private final String implName;

	private final String desc;
	private final String code;
}
