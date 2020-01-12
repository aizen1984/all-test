package com.caoc.test.shuhe.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OpenAccountChannel {
	WEBANK_SILENT("微众银行静默开户",DebitAccountChannel.WEBANK),
	WEBANK_UN_SILENT("微众银行非静默开户",DebitAccountChannel.WEBANK);
	private final String desc;
	private final DebitAccountChannel bank;
}
