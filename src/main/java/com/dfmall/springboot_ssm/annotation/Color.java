package com.dfmall.springboot_ssm.annotation;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.annotation
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月17日 23:32
 */
public enum Color {

    red(1,"红色","aa"),blue(2,"蓝色","bb");

    private int id;
    private String name;
    private String code;

    //必填
    Color(int id, String name,String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public static void main(String[] args) {
        System.out.println(Color.red.id +"--" + Color.red.name  +"--" + Color.red.code);
        System.out.println(Color.blue.code +"--" + Color.blue.name);
    }
}
