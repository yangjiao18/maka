package com.example.maka.Service.Impl;

import com.example.maka.Bean.Order;
import com.example.maka.Service.MakaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MakaServiceImpl implements MakaService {
    private int deep = 1;

    @Override
    public void loop() {
        try {
            stackLeak();
        } catch (Throwable e) {
            log.info("deep : {}", deep);
            throw e ;
        }
    }

    @Override
    public void getOrderList() throws InterruptedException {
        List<Order> list = new ArrayList<>();
        for (;;) {
            Order order = new Order();
            order.setId("1");
            list.add(order);
            Thread.sleep(10);
            log.info("size : {}", list.size());
        }
    }

    private void stackLeak() {
        deep++;
        stackLeak();
    }

}
