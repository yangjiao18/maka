package com.example.maka.Test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import static com.example.maka.Test.Sleeper.sleep;

@Slf4j(topic = "c.TestJoin")
public class Test02 {
    static int r = 0;
    static int r1 = 0;
    static int r2 = 0;
    public static void main(String[] args) throws InterruptedException {
        //test1();
        test2();
    }

    private static void test1() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            log.debug("t1开始");
            sleep(2);
            log.debug("结束");
            r = 10;
        });

        log.debug("main开始");
        t1.start();
        t1.join();
        log.debug("结果为:{}", r);
        log.debug("结束");
    }

    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            sleep(5);
            r1 = 10;
        });
        Thread t2 = new Thread(() -> {
            sleep(20);
            r2 = 20;
        });
        t1.start();
        t2.start();
        long start = System.currentTimeMillis();
        log.debug("join begin");
        t1.join();
        log.debug("t1 join end");
        t2.join();
        log.debug("t2 join end");
        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
    }

}
