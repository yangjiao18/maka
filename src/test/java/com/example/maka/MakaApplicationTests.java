package com.example.maka;

import com.example.maka.Service.MakaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MakaApplicationTests {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void create() {
        DirectExchange directExchange = new DirectExchange("hello.java.two", true, false);
        amqpAdmin.declareExchange(directExchange);
        System.out.println("123");
    }

}
