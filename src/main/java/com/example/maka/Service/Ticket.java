package com.example.maka.Service;

/**
 * @author Administrator
 */
public class Ticket {
    //票数
    private int number = 100;

    //操作方法：卖票
    public void sale() {
        //判断：是否有票
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + " : 卖出：" + (number--) + " 剩下：" + number);
        }
    }

}
