package com.wanbo.java8.maohao;

public class Func4 {
  
  public void doWork() {
      
    new Thread(this::execRun, "Thread -1 ");   // 4.用于实现接口只有一个方法的接口(函数接口/功能接口)
         
  }
  
  
  public void execRun() {
      System.out.println("Start Work");
      
      System.out.println("End Work");
  }

}
