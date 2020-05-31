package com.caoc.test.modeMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.caoc.test")
@Component
public class ModelMapperTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.register(ModelMapperTest.class);


		ModMapperEntity sourceEntity = new ModMapperEntity();
		sourceEntity.setCode("code1");
		sourceEntity.setName("name1");
		ModMapperEntity2 entity2 = new ModMapperEntity2();
		entity2.setCode("code2");
		entity2.setName("name2");
		sourceEntity.setModMapperEntity2(entity2);




		configApplicationContext.refresh();
		ModelMapper modelMapper = configApplicationContext.getBean(ModelMapper.class);
		ModMapperEntity needCopy = new ModMapperEntity();
		modelMapper.map(sourceEntity, needCopy);
		System.out.println(sourceEntity);
		System.out.println(needCopy);
		configApplicationContext.close();


	}
}
