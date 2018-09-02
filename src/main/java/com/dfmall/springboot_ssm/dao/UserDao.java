package com.dfmall.springboot_ssm.dao;

import com.dfmall.springboot_ssm.common.Query;
import com.dfmall.springboot_ssm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.Dao
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月14日 19:26
 */

@Mapper
public interface UserDao extends BaseDao<User>{

    @Select("select * from user2 limit #{offset},#{limit}")
    List<User> getAllUser(Query query);

    @Select("select count(1) from user2 limit #{offset},#{limit}")
    Integer getCount(Query query);

    Integer addUser(User user);

    @Select("select * from user2")
    List<User> getUsers();

    List<Map<String, String>> getInfo();

    @Select("select name from user")
    List<String> getSigletonList();

}
