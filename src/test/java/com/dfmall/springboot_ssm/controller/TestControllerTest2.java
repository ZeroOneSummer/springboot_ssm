package com.dfmall.springboot_ssm.controller;

import com.dfmall.WebApplication;
import com.dfmall.springboot_ssm.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.controller
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年09月02日 17:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class TestControllerTest2 {

    @Autowired
    private UserDao userDao;

    @Test
    public void getList() {
        List<String> list = userDao.getSigletonList();
        list.forEach(System.out::println);
    }

}