package com.dfmall.springboot_ssm.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.entity
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月14日 17:16
 */
@Data
public class User {

    @Excel(name = "ID", orderNum = "1", needMerge = false, width = 20)
    private int id;
    @Excel(name = "姓名", orderNum = "2", needMerge = false, width = 20)
    private String name;
    @Excel(name = "年龄", orderNum = "3", needMerge = false, width = 20)
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
