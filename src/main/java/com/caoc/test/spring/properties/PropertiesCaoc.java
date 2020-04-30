package com.caoc.test.spring.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "caoc")
@Data
public class PropertiesCaoc {
	private String name;
	private Integer sex;
}
