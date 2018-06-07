package com.wdd.test.comm.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 15:46 2018/3/21
 */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Thread t1= new Thread();
        pool.execute(t1);
    }

}
