package com.leo.instrumentation.premain;

import java.lang.instrument.Instrumentation;

/**
 * premain方式添加代理类
 * Created on 2017/2/28 下午2:04
 * leo linxiaotao1993@vip.qq.com
 */
public class Agent {

    public static void premain(String args, Instrumentation instrumentation){
        System.out.println("I am agent!!!");
        //添加转化类
        instrumentation.addTransformer(new TestTransformer());
    }
}
