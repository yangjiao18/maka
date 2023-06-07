package com.example.maka.event;

import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {

    private User user;

    public UserEvent(User user) {
        super(user);
        user = user;
    }

    public User getUser(){
        return user;
    }
}
