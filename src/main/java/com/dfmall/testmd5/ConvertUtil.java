package com.dfmall.testmd5;

import com.alibaba.fastjson.JSONObject;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.test
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年09月16日 11:36
 */
public class ConvertUtil {

    public String crypt(JSONObject params) {
        params.put("key", "j123456");
        String jsonStr = ParamSort.sort(params.toString());
        String upperCase = MD5.getMD5Str(jsonStr).toUpperCase();
        System.out.println(upperCase);
        return upperCase;
    }
}
