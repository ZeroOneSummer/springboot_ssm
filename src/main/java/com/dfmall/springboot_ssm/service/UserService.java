package com.dfmall.springboot_ssm.service;

import com.dfmall.springboot_ssm.common.Query;
import com.dfmall.springboot_ssm.entity.User;

import java.util.List;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.service
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月14日 19:27
 */

public interface UserService {

    List<User> getAllUser(Query query);

    Integer getCount(Query query);

    Integer addUser(User user);

    List<User> getUsers();
}
