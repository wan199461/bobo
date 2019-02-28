package com.wanbo.jetty;

public class App2 {

    public static void main(String[] args) {

        ClassLoader c1l = App2.class.getClassLoader();
        print(c1l.toString());
        ClassLoader c2l = c1l.getParent();
        print(c2l.toString());
        ClassLoader c3l = c2l.getParent();
        print(c3l.toString());
    }

    private static void print(String x) {
        System.out.println(x);
    }

}
