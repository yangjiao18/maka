package com.example.maka.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator
 */
@FeignClient(name = "MakaService", url = "http://localhost:8048/demo/Customer")
public interface MakaService {

    /**
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getName")
    String getNametoo(@RequestBody String name);
}
