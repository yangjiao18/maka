package com.example.maka.Thread;

public class FIFOThreadExample {

    public static void foo(String name) {
        System.out.print(name);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> foo("A"));
        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState());

    }
}

