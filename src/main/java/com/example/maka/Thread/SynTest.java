package com.example.maka.Thread;

import lombok.Synchronized;

public class SynTest {

    public static void main(String[] args) throws InterruptedException {
       Thread t1 = new Thread( ()-> {
           System.out.println(Thread.currentThread().getName());
           new WaitServer().waitMethod();
       });

        Thread t2 = new Thread( ()-> {
            System.out.println(Thread.currentThread().getName());
            new WaitServer().notifyMethod();
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();

    }
}
