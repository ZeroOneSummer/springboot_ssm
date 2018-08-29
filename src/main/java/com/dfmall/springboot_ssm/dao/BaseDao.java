package com.dfmall.springboot_ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.dao
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年08月29日 22:38
 */
public interface BaseDao<T> {

    void insert(T t);
    void insertBatch(Map<String, Object> map);

    void delete(Long id);
    void deleteBatch(Long[] ids);

    void update(T t);
    void updateBatch(Map<String, Object> map);

    List<T> queryObject(T t);
    List<T> query(Map<String, Object> map);

}
