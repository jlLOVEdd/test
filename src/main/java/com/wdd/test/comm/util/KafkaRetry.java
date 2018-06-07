package com.wdd.test.comm.util;

import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.context.RetryContextSupport;
import org.springframework.stereotype.Component;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 14:28 2018/5/22
 */
@Component
public class KafkaRetry {

    @Retryable(value = {RuntimeException.class}, maxAttempts = 3)
    public void retrytest() {
        //RetryContextSupport context  = new RetryContextSupport();
        System.out.println("do some things");
        throw new RuntimeException("this is test Exceptiion");

    }

    @Recover
    public void retrytest(RuntimeException e) {
        e.printStackTrace();
        System.out.println("重试结束  失败！！！！");
    }


}
