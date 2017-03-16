package com.leo.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 泛型测试
 * Created on 2017/3/12 下午2:37
 * leo linxiaotao1993@vip.qq.com
 */
@SuppressWarnings("unused")
public class GenericTest {

    public static void main(String[] args) {
        List<String> stringList = Collections.singletonList("Hello");
        test(stringList);
        List<OneLabel> oneLabels = Collections.singletonList(new OneLabel("1"));
        test1(oneLabels);
        //不能创建泛型数组
        //List<String>[] lists = new List<String>[10];
        //可以创建通配符数组
        List<?>[] lists = new List<?>[10];

        //数组是协变，这段代码在运行时候会抛出异常
        Object[] strings = new String[10];
        strings[0] = "Hello";
        //strings[1] = 1;
        //泛型不是协变的，所以下面这种写法，会报错。
        //List<Object> objectList = new ArrayList<String>();
        //泛型这种写法虽然可以通过编译，但会有个警告
        List objectList = new ArrayList<String>();
        objectList.add("Hello");
        objectList.add(10);
        System.out.println(objectList.get(1) instanceof String);
        //这里会抛异常
        //String result = (String) objectList.get(1);
        int result = (int) objectList.get(1);
        System.out.println(objectList);
    }

    /**
     * 通配符
     */
    private static void test(List<?> one) {
        for (Object object : one) {
            System.out.println(object);
        }
    }

    /**
     * 泛型方法
     */
    private static <T extends BaseLabel> void test1(List<T> one) {
        for (Object s : one) {
            System.out.println(s);
        }
    }


}
