package com.example.maka.Thread;

public class SaleTicketTest1 {
    /*
     * 题目：三个售票员 卖出 30张票
     * 多线程编程的企业级套路：
     * 1. 在高内聚低耦合的前提下， 线程 操作(对外暴露的调用方法) 资源类
     */

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "C").start();

    }

}

class Ticket { // 资源类
    private int number = 200;

    public synchronized void saleTicket() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第 " + (number--) + "票,还剩下:" + number);
        }
    }
}
