package com.example.maka.Thread;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * @author Administrator
 */
public class Test01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomStringUtils.random(10,"ABCNGFFF"));
        }
    }
}
