package com.example.maka.util;

import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class StrUtil {

    public static void main(String[] args) {
        System.out.println(weekOfYear());
    }

    /**
     * 获取当前时间所在自然周的起止日期
     *
     * @return
     */
    public static int weekOfYear() {
        Date date = DateUtil.parseDate("2023-09-29 10:00:00");
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.setMinimalDaysInFirstWeek(4);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

}
