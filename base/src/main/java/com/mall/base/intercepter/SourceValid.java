package com.mall.base.intercepter;

import java.lang.annotation.*;

/**
 * 自定义角色权限注解
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SourceValid {
    String [] value() default {};
}
