package com.example.maka.Controller;

import com.example.maka.Service.MakaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("maka")
public class MakaController {

    @Autowired
    MakaService makaService;

    @PostMapping("/getCode")
    public void getCode(String name){
        String code = makaService.getNametoo("jackCode");
        System.out.println(code);
    }

}
