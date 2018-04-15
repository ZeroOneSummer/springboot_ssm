package com.dfmall.springboot_ssm.common;

import lombok.Data;

import java.util.List;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.common
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年04月14日 20:41
 */
@Data
public class Page {

    private int currPage;
    private int pageSize;
    private int totalPage;
    private int totalCount;

    private List<?> list;
    private Object query;

    public Page(List<?> list, int totalCount, Query query){
        this.list = list;
        this.currPage = query.getPage();
        this.pageSize = query.getLimit();
        this.totalCount =totalCount;
        this.totalPage = (int) Math.ceil((double)(totalCount/pageSize)); //向上取整
        this.query = query;
    }

}
