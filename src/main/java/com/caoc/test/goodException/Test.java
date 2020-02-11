package com.caoc.test.goodException;

import com.caoc.test.goodException.constant.enums.ArgumentResponseEnum;

public class Test {
	public static void main(String[] args) {
		ArgumentResponseEnum.VALID_ERROR.assertNotNull(null);
	}
}
