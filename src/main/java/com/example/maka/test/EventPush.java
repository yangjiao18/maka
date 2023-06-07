package com.example.maka.test;

import com.example.maka.event.OrderEvent;
import com.example.maka.event.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventPush {

    /**
     * ApplicationContext 继承实现了 ApplicationEventPublisher, 可以直接发布事件
     */
    @Autowired
    private ApplicationContext applicationContext;

    @Async
    public void publishEvent(ApplicationEvent event) {
        if (event instanceof OrderEvent) {
            applicationContext.publishEvent((OrderEvent) event);
            return;
        } else if (event instanceof UserEvent) {
            applicationContext.publishEvent((UserEvent) event);
            return;
        } else {
            //发布失败
        }
    }

    @Async
    public void orderEventPush(OrderEvent event) {
        applicationContext.publishEvent(event);
    }

    @Async
    public void userEventPush(UserEvent event) {
        applicationContext.publishEvent(event);
    }
}
