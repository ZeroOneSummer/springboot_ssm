package com.dfmall.springboot_ssm.annotation;

import lombok.Data;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.annotation
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月17日 23:23
 */
@Data
public class Test {

    @FruitColor(fruitColor = Color.blue)
    private FruitColor fruitColor;

    public void show(){
        System.out.println(fruitColor);
    }

    public static void main(String[] args) {
        new Test().show();
    }

}
