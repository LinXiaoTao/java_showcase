package com.leo.instrumentation;

import java.lang.instrument.Instrumentation;

/**
 * Created on 2017/2/27 下午7:43
 * leo linxiaotao1993@vip.qq.com
 */
public class LoadedAgent {

    //会自动调用的代理方法
    public static void agentmain(String args, Instrumentation instrumentation){
        //打印类名
        Class[] classes = instrumentation.getAllLoadedClasses();
        for (Class clazz : classes)
            System.out.println(clazz.getName());
    }
}
