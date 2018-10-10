package com.wanbo.java8.maohao;

public class Car {
  
  public Car() {
    
  }
  
  public Car(String msg) {
     System.out.println("Construct Msg:" + msg);
  }
  
  public static String getMsg(String msg) {
    System.out.println("Static Method Msg:" + msg);
     return msg;
  }

  public String getMsg0(String msg) {
    System.out.println("Method Msg:" + msg);
     return msg;
  }
  
}
