package com.example.maka.Test;

public class Girl extends Person implements DoIt{
    @Override
    void printName() {
        System.out.println("girlName");
        super.printName();
    }

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }
}
