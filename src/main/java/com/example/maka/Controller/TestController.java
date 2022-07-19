package com.example.maka.Controller;

import com.example.maka.Bean.Man;
import com.example.maka.Bean.Person;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 */
public class TestController {
    public static Integer num = 1;

    public static void main(String[] args) {
        ReentrantLock lock= new ReentrantLock(true);
        new Thread(()->{
            lock.lock();
            System.out.println("abc");
            lock.unlock();
            lock.lock();
            System.out.println("def");
            lock.lock();
        }).start();

        new Thread(()->{
            lock.lock();
            System.out.println("6666");
            lock.unlock();
        }).start();
    }

}
