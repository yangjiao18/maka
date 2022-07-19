package com.example.maka.Controller;

import com.example.maka.Service.MakaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("maka")
public class MakaController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MakaService makaService;

    @PostMapping("/getCode")
    public void getCode() throws Exception {
        logger.info("1993");
    }

    @PostMapping("/loop")
    public void loop() throws Exception {
        makaService.loop();
    }

    @PostMapping("/getOrderList")
    public void getOrderList() throws Exception {
        makaService.getOrderList();
    }
}
