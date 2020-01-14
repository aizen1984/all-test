package com.caoc.test.shuhe.vo;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
@Getter
public enum BxAccountTypeEnum {
	SECOND_ACCOUNT("02", "二类户"),
	THIRD_ACCOUNT("03", "三类户");

	private String bxAccTypeCode;
	private String desc;

	BxAccountTypeEnum(String bxAccTypeCode, String desc) {
		this.bxAccTypeCode = bxAccTypeCode;
		this.desc = desc;
	}

	/**
	 * 根据百信返回code 返回账户类型
	 *
	 * @param bxAccTypeCode
	 * @return
	 */
	public static BxAccountTypeEnum getAccountTypeByTypeCode(String bxAccTypeCode) {
		if (StringUtils.isEmpty(bxAccTypeCode)) {
			return null;
		}
		for (BxAccountTypeEnum bxAccountTypeEnum : BxAccountTypeEnum.values()) {
			if (StringUtils.equals(bxAccountTypeEnum.getBxAccTypeCode(), bxAccTypeCode)) {
				return bxAccountTypeEnum;
			}
		}
		return null;
	}
}
