package com.wdd.test.comm.util;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 9:32 2018/4/27
 */
public class CountDownlatchLock {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

        try {
            Thread.sleep(4000);
            System.out.println("The End!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static  class Waiter implements Runnable {

        CountDownLatch latch = null;

        public Waiter(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Waiter Released");
        }
    }

    static class Decrementer implements Runnable {

        CountDownLatch latch = null;

        public Decrementer(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {

            try {
                Thread.sleep(1000);
                this.latch.countDown();
                System.out.println("decrementer+one");
                Thread.sleep(1000);
                this.latch.countDown();
                System.out.println("decrementer+two");
                Thread.sleep(1000);
                this.latch.countDown();
                System.out.println("decrementer+three");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
