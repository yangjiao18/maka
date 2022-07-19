package com.example.maka.Controller;

import com.example.maka.Service.Impl.AppIumServiceImpl;
import com.example.maka.Service.MakaService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("maka")
public class MakaController {

    @Autowired
    private MakaService makaService;

    @Autowired
    private AppIumServiceImpl appIumService;

    @PostMapping("/getCode")
    public void getCode() throws Exception {
        makaService.safeTest();
    }

    @RequestMapping("/executeScript")
    public String executeScript() {
        appIumService.executeScript( "张三" , "李四");
        return "execute ok";
    }

}
