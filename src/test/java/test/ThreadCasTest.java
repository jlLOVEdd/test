package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 10:18 2018/4/18
 */
public class ThreadCasTest {


    static  volatile  int num = 0;

    static AtomicInteger  atomicInt =new AtomicInteger();

    public static void main(String[] args) {
        try {
            for (int j = 0; j < 100; j++) {
                new Thread(()-> {
                        for (int i = 0; i < 1000; i++) {
                            ++num;
                            atomicInt.getAndIncrement();
                        }
                        System.out.println(Thread.currentThread().getName() + "--------" + num);
                }, "thread" + j).start();
            }
            Thread.sleep(1000);
            System.out.println(num);
            System.out.println(atomicInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
