package com.caoc.test.spring.scan;


//配置类==配置文件

import com.caoc.test.validation.ValidateService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


@Configuration // 告诉Spring这是一个配置类
@ComponentScan(value = "com.caoc.test", includeFilters = {
		//只扫描有@Controller注解的类
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
		//只扫描类型是BookService的类
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {ValidateService.class}),
		//自定义过滤规则
		@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
		useDefaultFilters = false)
// @ComponentScan value:指定要扫描的包
// excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
// includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
// FilterType.ANNOTATION：按照注解
// FilterType.ASSIGNABLE_TYPE：按照给定的类型；
// FilterType.ASPECTJ：使用ASPECTJ表达式
// FilterType.REGEX：使用正则指定
// FilterType.CUSTOM：使用自定义规则
public class MyConfig {
}
