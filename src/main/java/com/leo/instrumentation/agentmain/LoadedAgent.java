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
        instrumentation.addTransformer(new HookProcessBuilder());
        for (Class clazz : instrumentation.getAllLoadedClasses())
            if (clazz.getName().endsWith("ProcessBuilder"))
                System.out.println(clazz.getName());
    }
}
