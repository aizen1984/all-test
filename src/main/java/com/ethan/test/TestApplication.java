package com.ethan.test;

import com.ethan.test.validation.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
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
