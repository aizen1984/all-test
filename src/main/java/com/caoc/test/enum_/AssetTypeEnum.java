package com.caoc.test.enum_;

public enum AssetTypeEnum {
	HEAVY("1", "重资产"),
	LIGHT("0", "轻资产");
	private String assetType;
	private String assetTypeDesc;

	AssetTypeEnum(String assetType, String assetTypeDesc) {
		this.assetType = assetType;
		this.assetTypeDesc = assetTypeDesc;
	}
}
