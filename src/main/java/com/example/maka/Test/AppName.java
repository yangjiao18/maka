package com.example.maka.Test;

import lombok.Data;
import lombok.Getter;

import java.util.*;

@Getter
public enum AppName {

    Jing(100001L, "京东"),
    Tao(100002L,"淘宝");

    private Long key;

    private String Name;

    AppName(Long key, String name) {
        this.key = key;
        Name = name;
    }

    public static List<Map<String, Object>> toList() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (AppName item: AppName.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", item.getKey());
            map.put("name", item.getName());
            list.add(map);
        }
        return list;
    }

}
