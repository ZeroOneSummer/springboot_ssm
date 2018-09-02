package com.dfmall.springboot_ssm.controller;

import com.alibaba.fastjson.JSON;
import com.dfmall.springboot_ssm.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.controller
 * Description: List泛型不用entity
 * Author: ZeroOneSummer
 * Date: 2018年08月29日 22:01
 */
@Slf4j
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/info")
    public String getTestInfo() {
        List<Map<String, String>> lmap = userDao.getInfo();
        log.info("result: {} ", lmap);
        for (Map<String, String> map : lmap) {
            log.info("-- " + map.get("address") + "|" + map.get("name") + "|" + map.get("stuNo"));
        }
        return JSON.toJSONString(lmap);
    }

    @RequestMapping("/sigle")
    public String getSigletonList() {
        List<String> list = userDao.getSigletonList();
        return JSON.toJSONString(list);
    }

}
