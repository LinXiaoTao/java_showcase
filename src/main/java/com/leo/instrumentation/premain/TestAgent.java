package com.leo.instrumentation.premain;

/**
 * Created on 2017/2/28 下午2:16
 * leo linxiaotao1993@vip.qq.com
 */
public class TestAgent {

    static int sValue;

    static {
        sValue = 100;
        System.out.println(sValue);
    }

    public static void main(String[] args) {
        TestAgent testAgent = new TestAgent();
        testAgent.test();
    }

    public void test(){
//        System.out.println("Hello World");
    }




}
