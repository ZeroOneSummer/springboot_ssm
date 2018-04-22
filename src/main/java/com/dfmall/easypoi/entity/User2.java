package com.dfmall.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ExcelTarget("User2")
/**
 * 一级标题实体
 */
public class User2 implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 一级标题
     */
    @Excel(name = "用户id", needMerge = true)
    private Long id;

    @Excel(name = "用户名", needMerge = true)
    private String name;

    @Excel(name = "年龄", needMerge = true)
    private Integer age;

    @Excel(name = "创建时间", format = "yyyy-mm-dd", needMerge = true)
    private Date time;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, needMerge = true)
    private int sex;

    public User2(Long id, String name, Integer age, Date time, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.time = time;
        this.sex = sex;
    }

}