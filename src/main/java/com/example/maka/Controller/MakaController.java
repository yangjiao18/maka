package com.example.maka.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @PostMapping("/getCode")
    public void getCode() throws Exception {
        logger.info("1993");
    }

}
