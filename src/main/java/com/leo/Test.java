package com.leo;

import java.lang.reflect.Method;

/**
 * Created on 2017/3/14 上午11:53
 * leo linxiaotao1993@vip.qq.com
 */
public class Test {

    private final boolean custom;

    public Test() {
        custom = false;
    }

    private String mPathName;
    private ITest mITest;
    private boolean mBoolean;

    public Test(String pathName,boolean aBoolean, ITest ITest) {
        custom = false;
        mPathName = pathName;
        mITest = ITest;
        mBoolean = aBoolean;
    }

    public void invoke(Object proxy, Method method, Object[] args) {

    }

    public abstract static interface ITest {

    }

    public boolean isCustom() {
        return custom;
    }
}
