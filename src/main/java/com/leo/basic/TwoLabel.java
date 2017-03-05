package com.leo.basic;

/**
 * Created on 2017/3/5 下午3:20
 * leo linxiaotao1993@vip.qq.com
 */
public class TwoLabel extends BaseLabel {

    int mTwoName;

    public TwoLabel(int twoName) {
        mTwoName = twoName;
    }

    @Override
    void show() {
        System.out.println(String.valueOf(mTwoName));
    }
}
