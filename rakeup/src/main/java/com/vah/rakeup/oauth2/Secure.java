package com.vah.rakeup.oauth2;

import java.lang.annotation.*;

/**
 * 自定义权限注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Secure {

    String value() default "";
}
