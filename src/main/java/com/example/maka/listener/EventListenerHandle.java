package com.example.maka.listener;

import cn.hutool.http.HttpUtil;
import com.example.maka.event.Order;
import com.example.maka.event.OrderEvent;
import com.example.maka.event.User;
import com.example.maka.event.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventListenerHandle {

    /**
     * EventListener 监听到OrderEvent事件，触发方法
     * @param orderEvent
     */
    @Async
    @EventListener
    public void handle(OrderEvent orderEvent){
        Order order = orderEvent.getOrder();
    }

    /**
     * EventListener 监听到UserEvent事件，触发方法
     * @param userEvent
     */
    @Async
    @EventListener
    public void handle(UserEvent userEvent){
        User user = userEvent.getUser();
        System.out.println("123");
    }
}
