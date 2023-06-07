package com.example.maka.Controller;

import com.example.maka.Service.MakaService;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Administrator
 */
@RestController
@RequestMapping("maka")
public class MakaController {

    @Value("${name.value}")
    private String value;

    @Autowired
    MakaService makaService;

    @Autowired
    AmqpAdmin amqpAdmin;

    @PostMapping("/getCode")
    public void getCode(String name){
        DirectExchange directExchange = new DirectExchange("hello.java.liu", true, false);
        amqpAdmin.declareExchange(directExchange);
        System.out.println("123");
    }

}
