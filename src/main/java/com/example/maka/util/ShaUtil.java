package com.example.maka.util;

import cn.hutool.crypto.SecureUtil;

import java.util.*;

public class ShaUtil {

    public static String sign(Map<String, Object> params,String signKey) throws Exception {
        params.put("sign_key", signKey);
        Map<String, String> needVerify = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            needVerify.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        List<Map.Entry<String, String>> entryList = new ArrayList<>(needVerify.entrySet());
        //排序
        Collections.sort(entryList, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, String> entry : entryList) {
            buffer.append(entry.getKey()).append(entry.getValue());
        }
        return SecureUtil.sha1(buffer.toString());
    }

}
