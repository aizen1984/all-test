package com.caoc.test;

import com.caoc.test.goodException.constant.enums.ResponseEnum;
import com.caoc.test.goodException.exceptions.BusinessException;
import com.caoc.test.validation.ValidateService;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
//@MapperScan("com.caoc.test.mapper")
public class TestApplication {
    @Autowired
    ValidateService validateService;

    //@Autowired
    //PersonService persionService;


    public static void main(String[] args)
    {
        SpringApplication.run(TestApplication.class, args);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        //校验
        //validateService.testValidate();
        //return persionService.getPersonName();
        return "hello46";
    }

    @GetMapping(value = "/hello")
    public String hello(){
        ResponseEnum.BAD_LICENCE_TYPE.assertNotEmpty("");
        return "hello";
    }

}
