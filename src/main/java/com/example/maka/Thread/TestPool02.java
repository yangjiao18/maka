package com.example.maka.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool02 {
    public static void main(String[] args) {
        ExecutorService pool01 = Executors.newFixedThreadPool(10);
        try {
            for (int i = 0; i < 10; i++) {
                pool01.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "执行任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           pool01.shutdown();
        }

    }
}
