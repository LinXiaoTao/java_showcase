package com.leo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Hello world!
 */
public class App {
    private Test mTest = new Test();

    public static void main(String[] args) {
        Test test = new Test();
        try {
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            Field custom = test.getClass().getDeclaredField("custom");
            custom.setAccessible(true);

            System.out.println("设置前:" + custom.getModifiers());
            modifiers.setInt(custom, custom.getModifiers() & ~Modifier.FINAL);
            System.out.println("设置后:" + custom.getModifiers());

            custom.setBoolean(test, true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        System.out.println(test.isCustom());
    }

    private void test() {
        System.out.println("Hello");
    }


    private void test(String other, Test.ITest iTest) {
        mTest.invoke(iTest, null, null);
    }

    private void processOne(String other, Test.ITest iTest) {
        Test test = new Test(other, true, iTest);
        Object object = test;
    }

}
