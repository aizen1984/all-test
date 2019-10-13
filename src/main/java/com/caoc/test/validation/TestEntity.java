package com.caoc.test.validation;


import javax.validation.constraints.NotEmpty;

public class TestEntity {

    @NotEmpty(message = "name can not be null")
    private String name;
    @NotEmpty(message = "sex can not be null")
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
