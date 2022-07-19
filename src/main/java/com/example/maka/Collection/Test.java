package com.example.maka.Collection;

import java.util.ArrayList;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        //获取一个版本4根据随机字节数组的UUID。
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replaceAll("-", ""));
        //获取一个版本3(基于名称)根据指定的字节数组的UUID。
        byte[] nbyte = {10, 20, 30};
        UUID uuidFromBytes = UUID.nameUUIDFromBytes(nbyte);
        System.out.println(uuidFromBytes.toString().replaceAll("-", ""));
    }
}
