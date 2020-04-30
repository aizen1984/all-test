package com.caoc.test.spring.properties;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableConfigurationProperties({PropertiesCaoc.class})
@Data
public class EnablePropertiesConfiguration implements EnvironmentAware {
	private PropertiesCaoc propertiesCaoc;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertiesCaoc = PropertiesCaoc.class.cast(ConfigUtil.getConfig(environment, "caoc", PropertiesCaoc.class));
	}
}
