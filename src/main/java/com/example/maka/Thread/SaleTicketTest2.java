package com.example.maka.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketTest2 {
    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();

        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket2.saleTicket();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket2.saleTicket();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket2.saleTicket();
            }
        }, "C").start();

    }
}

class Ticket2 { // 资源类
    private Lock lock = new ReentrantLock();

    private int number = 30;

    public void saleTicket() {
        lock.lock();

        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第 " + (number--) + "票,还剩下:" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
