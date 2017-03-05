package com.leo.basic;

/**
 * 测试嵌套类一些特性
 * Created on 2017/3/5 上午11:47
 * leo linxiaotao1993@vip.qq.com
 */
public class NestedTest {
    private String mOrdinaryFiled = "Hello";
    private static String mStaticFiled = "World";

    void testInterface(){
        //常量接口使用
        System.out.println(InterfaceB.HELLO_WORLD);
    }

    //    静态成员类
    static class StaticNested {
        private void privateMethod() {
//            不能访问外部类非静态域
//            System.out.println(mOrdinaryFiled);
            System.out.println(mStaticFiled);
        }
    }
}
