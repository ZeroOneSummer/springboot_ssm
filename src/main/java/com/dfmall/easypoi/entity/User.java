package com.dfmall.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ExcelTarget("User")
/**
 * 一级标题实体
 */
public class User implements Serializable {
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


    /**
     * 该一级标题下有二级标题
     */
    @ExcelCollection(name = "商品序列")
    private List<Product> products;
    /**
     * 二级标题实体
     */
    @ExcelEntity(name = "商品")
    private Product product;



    public User(Long id, String name, Integer age, Product product, List<Product> products, Date time, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.product = product;
        this.products = products;
        this.time = time;
        this.sex = sex;
    }

}