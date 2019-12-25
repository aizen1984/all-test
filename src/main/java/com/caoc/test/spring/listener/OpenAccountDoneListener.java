package com.caoc.test.spring.listener;

/**
 * @author caochen
 */
public class OpenAccountDoneListener extends GenericsEventListener<OpenAccountDoneBo> {
	@Override
	protected void onEvent(OpenAccountDoneBo openAccountDoneBo) {
		System.out.println("斯国一");
	}
}
