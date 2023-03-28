package com.example.maka.util;

public class StrUtil {

    public static void main(String[] args) {
        System.out.println(getInValueStr("one,two,three"));
    }

    public static String getInValueStr(String value) {
        StringBuffer sb = new StringBuffer();
        String[] array = value.split(",");
        sb.append("(");
        for (String str : array) {
            sb.append("'" + str + "',");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(")");
        return sb.toString();
    }
}
