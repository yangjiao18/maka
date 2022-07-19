package com.example.maka.Thread;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class Test02 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(RandomUtils.nextBytes(10));
        }
    }

}
