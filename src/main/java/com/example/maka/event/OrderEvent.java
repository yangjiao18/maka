package com.example.maka.event;

import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {

    private Order order;

    public OrderEvent(Order order) {
        //ApplicationEvent 构造函数中必须传入source对象,  官方注释中被定义为最初发生事件的对象
        super(order);
        //方式二
        //super(order.getId());
        order = order;
    }

    public Order getOrder(){
        return order;
    }
}
