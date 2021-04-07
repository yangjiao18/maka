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

    @PostMapping("/createQueue")
    public void createQueue(){
        Queue queue = new Queue("hello.java.queue", true,false,false);
        amqpAdmin.declareQueue(queue);
        System.out.println("123");
    }

    @PostMapping("/createBinding")
    public void createBounding(){
        Binding binding = new Binding("hello.java.queue", Binding.DestinationType.QUEUE,
                "hello.java.liu", "hello.java", null);
        amqpAdmin.declareBinding(binding);
        java.util.UUID.randomUUID();
        System.out.println("123");
    }

    @PostMapping("/createGuid")
    public void createGuid(@RequestHeader("guid") String guid){
        System.out.println(guid);
        System.out.println(java.util.UUID.randomUUID());
    }

    @PostMapping("/send")
    public void send(@RequestBody String requestBody){

        DateTime date = new DateTime();
        DateTimeFormatter format = DateTimeFormat.forPattern("HHmmss");
        System.out.println(date.toString(format));

        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        System.out.println(String.format("%04d", 31));
//         String code = "123456";
//        String disCode = code.substring(0,3)+"-"+ code.substring(3,code.length()-3) +"-" +code.substring(code.length()-3);
//        String disCode01 = disCode.substring(0,5)+ "***" + disCode.substring(disCode.length()-6);
//        System.out.println(disCode);
//        System.out.println(disCode01);
//        JSONObject resultJson = JSON.parseObject(requestBody);
//        System.out.println(resultJson);
//        JSONObject json = new JSONObject();
//        json.put("mobile", "");
//
//        String numberWithPlus = json.getString("mobile") == null ? "" : json.getString("mobile");
//        String number = numberWithPlus.length() == 0 ? null : numberWithPlus.substring(1);

//        JSONObject requestJson = new JSONObject();
//
//        JSONObject a = new JSONObject();
//        a.put("number","18320270016");
//
//        requestJson.put("smsheader", a);
//
//        JSONArray mergeFeildArr = new JSONArray();
//        JSONObject b = new JSONObject();
//        b.put("name","name");
//        b.put("value","liu");
//        JSONObject c = new JSONObject();
//        c.put("name","code");
//        c.put("value","1993");
//        mergeFeildArr.add(b);
//        mergeFeildArr.add(c);
//        requestJson.put("mergeFeildList", mergeFeildArr);
        //System.out.println(json.toString());
    }

}
