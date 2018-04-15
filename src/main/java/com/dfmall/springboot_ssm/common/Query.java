package com.dfmall.springboot_ssm.common;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.common
 * Description: 查询条件类
 * Author: ZeroOneSummer
 * Date: 2018年04月14日 20:23
 */

@Data
public class Query extends LinkedHashMap<String, Object> {

    private int page; //当前页
    private int limit; //页码容量

    public Query(){
    }

    public Query(Map<String, Object> params){
        this.putAll(params);
        //分页
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        put("page", page);
        put("limit", limit);
        put("offset", (page - 1) * limit);

    }
}
