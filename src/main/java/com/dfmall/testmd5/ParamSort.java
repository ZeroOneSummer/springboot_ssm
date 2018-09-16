package com.dfmall.testmd5;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Project springboot_ssm.
 * Package: com.dfmall.test
 * Description: 描述
 * Author: ZeroOneSummer
 * Date: 2018年09月16日 11:38
 */
public class ParamSort {
    public ParamSort() {
    }

    public static String sort(String signStr) {
        Map<String, String> map = json2Map(signStr);
        StringBuilder sb = new StringBuilder();
        Iterator var3 = map.entrySet().iterator();

        while (var3.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) var3.next();
            sb.append((String) entry.getKey() + "=" + (String) entry.getValue() + "&");
        }

        return sb.toString().subSequence(0, sb.length() - 1) + "";
    }

    public static Map<String, String> json2Map(String jsonStr) {
        Map map = JSON.parseObject(jsonStr);
        Iterator entries = map.entrySet().iterator();

        while (true) {
            Object value;
            do {
                if (!entries.hasNext()) {
                    return sortMapByKey(map);
                }

                Map.Entry<String, String> entry = (Map.Entry) entries.next();
                value = entry.getValue();
            } while (value != null && !"".equals(value));

            entries.remove();
        }
    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            Map<String, String> sortMap = new TreeMap(new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            sortMap.putAll(map);
            return sortMap;
        } else {
            return null;
        }
    }
}

