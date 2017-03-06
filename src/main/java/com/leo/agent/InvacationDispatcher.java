package com.leo.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2017/3/6 下午5:33
 * leo linxiaotao1993@vip.qq.com
 */
public class InvacationDispatcher implements InvocationHandler {

    final Map<String, InvocationHandler> mInvactionHandlerFactory;

    public InvacationDispatcher() {
        mInvactionHandlerFactory = new HashMap<>();
        mInvactionHandlerFactory.put(Constans.PROCESSBUILDER, new ProcessBuilderInvocationHandler());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        InvocationHandler invocationHandler = mInvactionHandlerFactory.get(proxy);
        if (invocationHandler == null)
            return null;
        else
            return invocationHandler.invoke(proxy, method, args);
    }
}
