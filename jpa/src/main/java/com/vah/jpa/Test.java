package com.vah.jpa;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/5/28 12:04
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        String[] split = "web".split(":", -1);
        System.out.println(split.length);
        System.out.println(Long.valueOf(split[1]));
    }
}
