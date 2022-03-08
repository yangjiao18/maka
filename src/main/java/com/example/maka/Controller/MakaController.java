package com.example.maka.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.example.maka.Service.MakaService;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.joda.time.DateTime;
import java.util.Date;
import java.util.HashMap;
/**
 * @author Administrator
 */
@RestController
@RequestMapping("maka")
public class MakaController {

    @Value("${name.value}")
    private String value;

    @PostMapping("/getCode")
    public void getCode() throws Exception {

    }

}
