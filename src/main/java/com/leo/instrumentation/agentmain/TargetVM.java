package com.leo.instrumentation.agentmain;

/**
 * Created on 2017/2/27 下午7:52
 * leo linxiaotao1993@vip.qq.com
 */
public class TargetVM {
    //测试类，将被代理的类
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println("运行中。。。");
            Thread.sleep(1000);
        }

    }
}
