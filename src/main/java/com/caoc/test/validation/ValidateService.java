package com.caoc.test.validation;

import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class ValidateService {


    /**
     *
     */
    public void testValidate() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        TestEntity testEntity = new TestEntity();
        testEntity.setName("1");
        testEntity.setSex("2");
        Set<ConstraintViolation<TestEntity>> set = validator.validate(testEntity);
        set.stream().forEach(x -> System.out.println(x.getMessage()));
    }
}
