package com.leo.timing;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2017/3/1 下午5:16
 * leo linxiaotao1993@vip.qq.com
 */
@Timing
public class TestTiming {

    public static void main(String[] args) {
        TestTiming testTiming = new TestTiming();
        testTiming.testMethod();
        testTiming.otherMethod();
    }

    @Timing
    private void testMethod(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Timing
    private void otherMethod(){
        System.out.println("I'm Other Method");
    }
}
