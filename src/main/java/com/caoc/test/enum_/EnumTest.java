package com.caoc.test.enum_;

import net.bytebuddy.dynamic.DynamicType;

import java.util.Optional;

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(AssetTypeEnum.valueOf("HEAVY"));
		System.out.println(AssetTypeEnum.HEAVY.name());

		AssetTypeEnum assetTypeEnum = AssetTypeEnum.valueOf("1");
//		System.out.println(Optional.ofNullable(assetTypeEnum.name()).orElse("1"));
		System.out.println(assetTypeEnum);




	}

}
