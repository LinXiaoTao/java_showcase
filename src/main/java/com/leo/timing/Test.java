package com.leo.timing;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2017/3/1 下午5:05
 * leo linxiaotao1993@vip.qq.com
 */
public class Test {


    public static void main(String[] args) {
        Test test = new Test();
        test.testMethod();
    }

    private void testMethod(){
        CalculateUtil.setStartTime(System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CalculateUtil.run("testMethod",System.currentTimeMillis());
    }
}
