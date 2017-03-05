package com.leo.timing;

import java.lang.instrument.Instrumentation;

/**
 * Created on 2017/3/2 上午10:28
 * leo linxiaotao1993@vip.qq.com
 */
public class Agent {

    public static void premain(String args, Instrumentation instrumentation){
        System.out.println("prermain");
        instrumentation.addTransformer(new TimingTransformer());
    }
}
