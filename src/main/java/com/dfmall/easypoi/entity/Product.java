package com.dfmall.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 二级标题
     */
    private int id;
    @Excel(name = "商品名", needMerge = true)
    private String name;
    @Excel(name = "价格", needMerge = true)
    private double price;
    @Excel(name = "购买时间", format = "yyyy/mm/dd", needMerge = true)
    private Date time;

    public Product(int id, String name, double price, Date time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
    }
}