package com.leo.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created on 2017/3/6 下午5:17
 * leo linxiaotao1993@vip.qq.com
 */
public class AgentMain {

    public static void agentmain(String args, Instrumentation instrumentation){
        instrumentation.addTransformer(new HookTransformer());
    }
}
