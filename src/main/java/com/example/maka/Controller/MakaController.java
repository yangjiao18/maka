package com.example.maka.Controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.example.maka.Controller.request.SaveRequest;
import com.example.maka.Service.MakaService;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    public void getCode(){
        long timestamp = 1688392689941L;
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        String formattedDate = DateUtil.format(new Date(timestamp), dateFormat);
        System.out.println(new Date(timestamp));
    }


}
