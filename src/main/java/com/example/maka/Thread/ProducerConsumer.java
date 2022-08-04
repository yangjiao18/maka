package com.example.maka.Thread;

public class ProducerConsumer {
    /**
     * 题目：现在两个线程，可以操作初始值为0的一个变量
     * 实现一个线程对该变量 + 1，一个线程对该变量 -1
     * 实现交替10次
     * <p>
     * 诀窍：
     * 1. 高内聚低耦合的前提下，线程操作资源类
     * 2. 判断 、干活、通知
     */

    public static void main(String[] args) {
        Data data = new Data();

        //A线程增加
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        //B线程减少
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}

class Data {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        // 判断该不该这个线程做
        if (number != 0) {
            this.wait();
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        // 判断该不该这个线程做
        if (number == 0) {
            this.wait();
        }
        // 干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 通知
        this.notifyAll();
    }

}
