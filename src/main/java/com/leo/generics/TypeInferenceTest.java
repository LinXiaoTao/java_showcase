package com.leo.generics;

import org.junit.Test;

import java.util.*;

/**
 * 泛型中的类型推断
 * Created on 2017/3/23 上午9:25
 * leo linxiaotao1993@vip.qq.com
 */
public class TypeInferenceTest {

    public static <U> void addBox(U u, List<TypeInferenceTest.Bax<U>> boxes) {
        TypeInferenceTest.Bax<U> bax = new Bax<>();
        bax.setValue(u);
        boxes.add(bax);
    }

    public static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = l[0].get(0);       // ClassCastException thrown here
    }

    private void printList(List<?> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }


    private void printList(Object[] list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    private <U> void addBoxNotStatic(U u, List<TypeInferenceTest.Bax<U>> baxes) {

    }


    @Test
    public void testPrintList() {
        List<String> stringList = Arrays.asList("Hello", "Java");
        String[] stringArrays = {"Hello", "Java"};
        printList(stringArrays);
        printList(stringList);
    }

    @Test
    public void testAddBox() {
        List<TypeInferenceTest.Bax<Integer>> baxList = new ArrayList<>();
        addBox(Integer.valueOf(10), baxList);
        TypeInferenceTest.<Integer>addBox(Integer.valueOf(20), baxList);
        this.<Integer>addBoxNotStatic(Integer.valueOf(20), baxList);
    }

    @Test
    public void testWildcards() {
        List<? extends Integer> integets = new ArrayList<>();
        List<? extends Double> doubles = new ArrayList();
        List<? extends Number> numbers = integets;//ture
        Object object = integets.get(0);
        Integer integer = integets.get(0);
    }

    private <T> void testT(List<? extends T> list) {

    }


    private <T extends Integer> T providesInteger(T value) {
        return value;
    }

    private void testWildcard(List<?> src) {
        wildcardHelp(src);
    }

    private <T> void wildcardHelp(List<T> list) {
        list.set(0, list.get(0));
    }

    @Test
    public void testContext(){
        Context context = new Context();
    }

    private static class Bax<U> {
        private U value;

        public void setValue(U value) {
            this.value = value;
        }
    }

    public class Context {
        private final Map<Class<?>, Object> values = new HashMap<>();

        private <T> void putValue(Class<T> type, T instance) {
            values.put(type, instance);
        }

        private <T> T getValue(Class<T> type) {
            return type.cast(values.get(type));
        }

    }

}
