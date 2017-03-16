package com.leo.basic;

import org.junit.Test;

import java.util.List;

/**
 * 泛型数组测试
 * Created on 2017/3/14 下午11:10
 * leo linxiaotao1993@vip.qq.com
 */
public class GenericsArrayTest {

    @Test
    public <E extends BaseLabel> void testCreate(E e){
//        E[] values = (E[]) new OneLabel[10];
        List<String>[] lists = new List[10];
    }
}
