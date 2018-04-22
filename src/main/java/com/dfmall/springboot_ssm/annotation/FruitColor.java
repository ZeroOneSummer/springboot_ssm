package com.dfmall.springboot_ssm.annotation;

import java.lang.annotation.*;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.annotation
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月17日 23:26
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    Color fruitColor() default Color.red;

    public enum color{red,blue,green};

    public String value() default "";

}
