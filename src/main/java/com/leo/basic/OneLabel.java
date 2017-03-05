package com.leo.basic;

/**
 * Created on 2017/3/5 下午3:19
 * leo linxiaotao1993@vip.qq.com
 */
public class OneLabel extends BaseLabel {
    final String mOneName;


    public OneLabel(String oneName) {
        mOneName = oneName;
    }

    @Override
    void show() {
        System.out.println(mOneName);
    }
}
