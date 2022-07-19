package com.example.maka.Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestPool {
    AtomicInteger c = new AtomicInteger(1);
    ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(3);
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,
            5,
            1,
            TimeUnit.MINUTES,
            queue,
            r -> new Thread(r, "Thread"+c.getAndIncrement()),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );
}
