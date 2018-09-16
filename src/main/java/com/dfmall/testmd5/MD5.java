package com.dfmall.testmd5;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.test
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年09月16日 11:37
 */
public class MD5 {
    private static Logger logger = Logger.getLogger(MD5.class);

    public MD5() {
    }

    public static byte[] getMD5(byte[] data) {
        byte[] md5 = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md5 = md.digest(data);
        } catch (Exception var3) {
            ;
        }

        return md5;
    }

    public static String getMD5Str(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            if (!StringUtils.isEmpty(str)) {
                messageDigest.update(str.getBytes("UTF-8"));
            }
        } catch (NoSuchAlgorithmException var5) {
            logger.error(var5);
        } catch (UnsupportedEncodingException var6) {
            logger.error(var6);
        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; ++i) {
            if (Integer.toHexString(255 & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(255 & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(255 & byteArray[i]));
            }
        }

        return md5StrBuff.toString().toUpperCase();
    }

    public static String getMD5Str(byte[] data) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(data);
        } catch (NoSuchAlgorithmException var5) {
            ;
        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; ++i) {
            if (Integer.toHexString(255 & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(255 & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(255 & byteArray[i]));
            }
        }

        return md5StrBuff.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(getMD5Str("xxxx"));
        System.out.println(DigestUtils.md5Hex("xxxx").toUpperCase());
    }
}
