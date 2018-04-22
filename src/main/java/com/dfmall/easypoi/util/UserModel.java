package com.dfmall.easypoi.util;

import com.dfmall.easypoi.entity.Product;
import com.dfmall.easypoi.entity.User;
import com.dfmall.easypoi.entity.User2;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.easypoi.util
 * Description: 模拟DB参数
 * Author: ZeroOneSummer
 * Date: 2018年04月22日 15:54
 */
@Slf4j
public class UserModel {

    //模拟数据（有关联实体类）
    public static List<User> getUsers() {
        Date time = new Date();
        //实体
        Product p1 = new Product(1,"苹果",10, time);
        Product p2 = new Product(2,"梨子",30, time);
        //实体集合
        List<Product> products = new ArrayList<Product>();
        products.add(p1);
        products.add(p2);
        //顾客
        User u1 = new User(1L,"小明",21, p1, products, time, 1);
        User u2 = new User(2L,"小红",23, p2, products, time, 2);
        //顾客集合
        List<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
        //顾客集合（顾客 + 产品 + 产品列表）*/
        return users;
    }

    //模拟数据（无关联实体类）
    public static List<User2> getUser2s() {
        Date time = new Date();

        //顾客
        User2 u1 = new User2(1L,"小明",21, time, 1);
        User2 u2 = new User2(2L,"小红",23, time, 2);
        //顾客集合
        List<User2> users = new ArrayList<User2>();
        users.add(u1);
        users.add(u2);

        return users;
    }



}
