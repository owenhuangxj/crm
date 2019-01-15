package com.ss.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermInfo {

    /**
     * 权限值
     */
    String pval() default "";

    /**
     * 权限名称
     * pname的别名
     */
    String value() default "";

}
