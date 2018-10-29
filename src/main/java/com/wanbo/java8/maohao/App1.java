package com.wanbo.java8.maohao;

public class App1 {
  
  public static void main(String...strings) {
    
    IDelegate<String, String> delegate1 = Car::getMsg;  //  1.访问静态方法
    String res1 = delegate1.delegate("2333");
    
    Car car = new Car();
    IDelegate<String, String> delegate2 = car::getMsg0;  // 2.访问对象方法
    String res2 = delegate2.delegate("2333");
    
    IDelegate<Car, String> delegate3 = Car::new;     //     3.访问构造方法
    Car res3 = delegate3.delegate("car");  //执行构造方法得到一个对象
    
    // 用于函数接口
    new Func4().doWork();
    
  }
  
  

}
