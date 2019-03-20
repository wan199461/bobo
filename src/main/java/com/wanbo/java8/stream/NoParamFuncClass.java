package com.wanbo.java8.stream;

public class NoParamFuncClass {

    public NoParamFuncClass(OneParamFuncInterface of) {
        of.noParam();
    }

    public void print() {
        System.err.println("NoParamFuncClass");
    }

    public static void printStatic(OneParamFuncInterface of) {
        of.noParam();
    }

    public void printFunc() {
        System.out.println("Func method");
    }

    public void func1(OneParamFuncInterface np) {
        np.noParam();
    }

    public static void main(String[] args) {
        printStatic(() -> {
            System.out.println("hehe");
        });
        
        
        NoParamFuncClass nc = new NoParamFuncClass(()->{
            System.out.println("init method");
        });
        nc.func1(()-> {
            System.out.println("Func Data");
        });
    }

}
