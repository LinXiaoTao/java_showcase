package com.leo.basic;

/**
 * 标签类
 * Created on 2017/3/5 下午3:01
 * leo linxiaotao1993@vip.qq.com
 */
public class LabelTest {
    enum TAG {ONE, TWO}

    final TAG mTag;
    String mOneName;
    int mTwoName;

    public LabelTest(String oneName) {
        mTag = TAG.ONE;
        mOneName = oneName;
    }

    public LabelTest(int twoName) {
        mTag = TAG.TWO;
        mTwoName = twoName;
    }

    public void show() {
        switch (mTag) {
            case ONE:
                System.out.println(mOneName);
                break;
            case TWO:
                System.out.println(String.valueOf(mTwoName));
                break;
        }
    }
}
