package com.example.maka.test;

import com.example.maka.event.Order;
import com.example.maka.event.OrderEvent;
import com.example.maka.event.User;
import com.example.maka.event.UserEvent;

public class Test01 {
    static  EventPush eventPush = new EventPush();
    public static void main(String[] args) {
        Order order = new Order();
        order.setId(1000L);
//0: 订单创建成功  1：支付成功  .....
        order.setStatus(1);

        User user = new User();
        user.setId(1000L);
//0: 退出成功  1：登录成功  .....
        user.setLoginStatus(String.valueOf(1));

//方式一：
        eventPush.orderEventPush(new OrderEvent(order));
        eventPush.userEventPush(new UserEvent(user));

//方式二：
        eventPush.publishEvent(new OrderEvent(order));
        eventPush.publishEvent(new UserEvent(user));

    }
}
