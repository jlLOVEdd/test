package com.wdd.test.comm.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 10:11 2018/4/27
 */
public class ExecutorServices {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Executor  e = Executors.newCachedThreadPool();
        Executor ee = Executors.newFixedThreadPool(22);
        Executor eer = Executors.newScheduledThreadPool(111);

        executor.execute(() ->{
                System.out.println("222");
        });
        executor.shutdown();
    }
}
