package com.dfmall.springboot_ssm.common;

import java.util.HashMap;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.common
 * Description: 返回结果状态类
 * Author: ZeroOneSummer
 * Date: 2018年04月14日 20:13
 */
public class R extends HashMap<String, Object> {

    public R(){
        this.put("code", 200);
        this.put("msg", "success");
    }

    public static R ok(){
        return new R();
    }

    public static R ok(Object data) {
        R r = new R();
        r.put("data", data);
        return r;
    }

    public static R ok(int id) {
        R r = new R();
        r.put("rtId", id);
        return r;
    }

    public static R error(){
        R r = new R();
        r.put("code", 500);
        r.put("msg", "failed");
        return r;
    }
}
