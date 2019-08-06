package com.vah.component;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/8/5 17:14
 * @Version 1.0
 **/
public class User {
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

    @Override
    public String toString() {
        return "com.vah.component.User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
