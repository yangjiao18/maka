package com.example.maka.Controller;

import com.example.maka.Service.AthenaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("athena")
public class AthenaController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AthenaService athenaService;

    @PostMapping("/queryS3")
    public void queryS3() throws Exception {
        athenaService.query();
    }
}
