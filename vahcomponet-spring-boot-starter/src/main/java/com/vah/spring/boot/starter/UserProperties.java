package com.vah.spring.boot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/8/5 17:26
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "com.vah")
public class UserProperties {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
