package com.example.maka.Thread;

/**
 * @author Administrator
 */
public class TestMain {

    public static void main(String[] args) {

        Test01 t1 = new Test01();
        t1.start();

        Test02 t2 = new Test02();
        new Thread(t2).start();

    }

}
