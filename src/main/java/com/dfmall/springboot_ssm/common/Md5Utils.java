package com.dfmall.springboot_ssm.common;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.springboot_ssm.common
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年09月02日 15:24
 */
public class Md5Utils {

    //md5加密
    public static String MD5Encode(String str, String chartset) {
        String rs = new String(str);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (StringUtils.isBlank(chartset))
                rs = bAToStr(md.digest(str.getBytes()));
            else
                rs = bAToStr(md.digest(str.getBytes(chartset))); //带编码的转换
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    //byte数组转string
    public static String bAToStr(byte[] bytes) {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sbf.append(bToStr(bytes[i]));
        }
        return sbf.toString();
    }

    public static String bToStr(byte b) {
        int n = b; //byte转int
        if (n < 0) n += 256;  //负数转正
        int s1 = n / 16;
        int s2 = n % 16;
        return enodeByte[s1] + enodeByte[s2];
    }

    //16进制数组
    private static final String[] enodeByte = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f", "g"};

    public static void main(String[] args) {
        System.out.println(MD5Encode("hello123", null));
        System.out.println(MD5Encode("hello123", "utf-8"));
    }

}
