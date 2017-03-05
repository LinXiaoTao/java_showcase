package com.leo.instrumentation.agentmain;

import java.lang.instrument.Instrumentation;

/**
 * 使用agentmain方法代理
 * Created on 2017/2/27 下午7:43
 * leo linxiaotao1993@vip.qq.com
 */
public class LoadedAgent {

    //会自动调用的代理方法
    public static void agentmain(String args, Instrumentation instrumentation){
        System.out.println("===================================================================================");
        System.out.println("执行到agentmain");
        Class[] classes = instrumentation.getAllLoadedClasses();
        for (Class clazz : classes)
//            if (clazz.getName().endsWith("ProcessBuilder"))
                System.out.println(clazz.getName());
        System.out.println("===================================================================================");
    }
}
