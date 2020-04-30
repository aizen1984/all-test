package com.caoc.test.spring.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@EnableConfigurationProperties({PropertiesCaoc.class}) 配合 ConfigurationProperties 使用
@Component
@Data
public class EnablePropertiesConfiguration implements EnvironmentAware {
	/**
	 * 通过spring来注入管理
	 */
//	@Autowired
	private PropertiesCaoc propertiesCaoc;

	/**
	 * 方式2 来注入propertiesCaoc对象 不用spring来管理
	 * @param environment
	 */
	@Override
	public void setEnvironment(Environment environment) {
		this.propertiesCaoc = PropertiesCaoc.class.cast(ConfigUtil.getConfig(environment, "caoc", PropertiesCaoc.class));
	}
}
