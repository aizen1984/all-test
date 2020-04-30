package com.caoc.test.spring.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.bind.PropertySourcesPlaceholdersResolver;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySources;
import org.springframework.util.Assert;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.NoSuchElementException;

public class ConfigUtil {
	private static final Logger log = LoggerFactory.getLogger(ConfigUtil.class);

	public ConfigUtil() {
	}

	private static PropertySources getSources(Environment environment) {
		Assert.notNull(environment, "Environment must not be null");
		Assert.isInstanceOf(ConfigurableEnvironment.class, environment, "Environment must be a ConfigurableEnvironment");
		return ((ConfigurableEnvironment) environment).getPropertySources();
	}

	public static <T> T getConfig(Environment environment, String prefix, Class<T> claz) {
		try {
			PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}", ":", true);
			PropertySources sources = getSources(environment);
			PropertySourcesPlaceholdersResolver placeholdersResolver = new PropertySourcesPlaceholdersResolver(sources, helper);
			Binder binder = new Binder(ConfigurationPropertySources.get(environment), placeholdersResolver);
			BindResult<T> binderResult = binder.bind(prefix, claz);
			return binderResult.get();
		} catch (NoSuchElementException var8) {
			log.info("没有发现配置，prefix={}", prefix);
			return null;
		} catch (Exception var9) {
			log.error("解析配置参数失败, prefix={}", prefix, var9);
			throw new RuntimeException(var9);
		}
	}
}
