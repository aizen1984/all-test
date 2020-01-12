package com.caoc.test.shuhe.vo;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OpenAccountTypeEnum {
	USER_APPLY_SILENT_OPEN_ACCOUNT("用户申请静默开户"),
	LEND_SILENT_OPEN_ACCOUNT("借款静默开户"),
	REPAY_SILENT_OPEN_ACCOUNT("还款静默开户"),
	CREDIT_MANUAL_OPEN_ACCOUNT("信用卡还款主动开户", OpenAccountChannel.WEBANK_UN_SILENT),
	WALLET_MANUAL_OPEN_ACCOUNT("钱包账户主动开户", OpenAccountChannel.WEBANK_UN_SILENT),
	MANUAL_OPEN_ACCOUNT("主动开户", OpenAccountChannel.WEBANK_UN_SILENT),
	BATCH_OPEN_ACCOUNT("批量开户");

	@NonNull
	private String desc;

	private final OpenAccountChannel channel;

	OpenAccountTypeEnum(String desc) {
		this(desc, OpenAccountChannel.WEBANK_SILENT);
	}
}
