package com.caoc.test.spring.listener;

/**
 * @author caochen
 */
public class OpenAccountDoneEvent extends ExchangeAwareEvent<OpenAccountDoneBo> {

	public OpenAccountDoneEvent(OpenAccountDoneBo source) {
		super(source, "rabbitmq.exchange.name");
	}

	@Override
	public Object getBody() {
		return super.getSource().getName();
	}
}
