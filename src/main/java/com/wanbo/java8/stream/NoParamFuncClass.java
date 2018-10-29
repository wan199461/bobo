package com.wanbo.java8.stream;

public class NoParamFuncClass {
  
  public NoParamFuncClass() {
    System.out.println("Construct method");
  }
  
  public void print() {
    System.err.println("NoParamFuncClass");
  }
  
  public static void printStatic(){
     System.out.println("Static method");
  }
  
  public void printFunc() {
    System.out.println("Func method");
  }
  
  public void func1(OneParamFuncInterface np) {
      np.noParam();
  }

}
