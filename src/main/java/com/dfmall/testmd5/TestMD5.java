package com.dfmall.testmd5;

import com.alibaba.fastjson.JSONObject;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.test
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年09月16日 11:40
 */
public class TestMD5 {
    public static void main(String[] args) {
        ConvertUtil convertUtil = new ConvertUtil();
        //param:{"result":"1","mall":"KKG","sign":"6F5A2F811ED4F3A412AFD441190D80D5",
        // "remark":"测试订单","buyBackNumber":"H18091510191703644693","key":"j123456"}

        JSONObject syncParams = new JSONObject();
        syncParams.put("buyBackNumber", "H18091510191703644693");
        syncParams.put("result", "1");
        syncParams.put("remark", "测试订单");
        String sign = convertUtil.crypt(syncParams);
        syncParams.put("sign", sign);
        syncParams.put("mall", "KKG");

        System.out.println(syncParams);
    }
}
