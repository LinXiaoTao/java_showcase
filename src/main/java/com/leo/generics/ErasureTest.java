package com.leo.generics;

/**
 * Created on 2017/3/23 下午4:34
 * leo linxiaotao1993@vip.qq.com
 */
public class ErasureTest {

    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node n = mn;
        n.setData("Hello");
        Integer x = mn.data;
    }

    public static class Node<T> {

        T data;

        Node(T data) {
            this.data = data;
        }

        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }

    public static class MyNode extends Node<Integer> {
        MyNode(Integer data) {
            super(data);
        }

        @Override
        public void setData(Integer data) {
            System.out.println("MyNode.setData");
        }
    }
}
