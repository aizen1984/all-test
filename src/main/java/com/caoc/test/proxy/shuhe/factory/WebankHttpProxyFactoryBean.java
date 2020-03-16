package com.caoc.test.proxy.shuhe.factory;

import com.caoc.test.proxy.shuhe.aop.SignVerifyInitializingBean;
import com.caoc.test.proxy.shuhe.aop.WebankHttpInvocationHandler;
import com.caoc.test.proxy.shuhe.service.WebankHttp;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WebankHttpProxyFactoryBean extends AbstractServiceProxyFactoryBean<WebankHttp>
		implements SignVerifyInitializingBean {

	@Autowired
	private WebankHttpInvocationHandler handler;

	private final Class<WebankHttp> type = WebankHttp.class;
}
