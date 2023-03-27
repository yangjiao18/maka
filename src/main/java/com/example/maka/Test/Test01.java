package com.example.maka.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       new Girl().printName();
       new Girl();
    }
}
