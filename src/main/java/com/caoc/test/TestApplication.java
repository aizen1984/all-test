package com.caoc.test;

import com.caoc.test.validation.ValidateService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.ethan.test.mapper")
public class TestApplication {
    @Autowired
    ValidateService validateService;


    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        validateService.testValidate();
        return "ok";
    }

}
