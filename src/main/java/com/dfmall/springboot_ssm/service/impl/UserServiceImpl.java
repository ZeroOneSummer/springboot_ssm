package com.dfmall.springboot_ssm.service.impl;

import com.dfmall.springboot_ssm.common.Query;
import com.dfmall.springboot_ssm.dao.UserDao;
import com.dfmall.springboot_ssm.entity.User;
import com.dfmall.springboot_ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.service.service.impl
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月14日 19:28
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUser(Query query) {
        return userDao.getAllUser(query);
    }

    @Override
    public Integer getCount(Query query) {
        return userDao.getCount(query);
    }

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
