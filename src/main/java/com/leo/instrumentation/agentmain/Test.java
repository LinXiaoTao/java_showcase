package com.leo.instrumentation.agentmain;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * 通过动态加载代理，来实现对字节码操作
 * Created on 2017/2/27 下午7:47
 * leo linxiaotao1993@vip.qq.com
 */
public class Test {
    public static void main(String[] args) throws IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
        //连接到目标Java虚拟机
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        //动态加载代理
        vm.loadAgent("/Users/linxiaotao/Documents/work/Personal/java_showcase/loadagent.jar");
    }
}
