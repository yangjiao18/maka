package com.example.maka.Service.Impl;

import com.example.maka.Commen.Recording;
import org.springframework.stereotype.Service;

@Service
public class AppIumServiceImpl {
    @Recording
    public String executeScript(String a, String b) {
        System.out.println("任务执行");
        return a + b;
    }
}

