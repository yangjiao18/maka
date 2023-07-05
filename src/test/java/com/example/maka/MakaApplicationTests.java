package com.example.maka;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.example.maka.Service.MakaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class MakaApplicationTests {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void create(){
        System.out.println(JSONUtil.parse(new Date()));
    }

}
