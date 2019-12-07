package com.caoc.test.enum_;

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(AssetTypeEnum.valueOf("HEAVY"));
		System.out.println(AssetTypeEnum.HEAVY.name());
	}

}
