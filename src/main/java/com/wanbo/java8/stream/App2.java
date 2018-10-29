package com.wanbo.java8.stream;

import java.util.Arrays;
import java.util.List;

public class App2 {

  public static void main(String[] args) {
    
    List<Double> datas = Arrays.asList(1D,8D,3D,4D,6D, 1.0/3);
    
    boolean res = datas.stream().allMatch(Double::isFinite);
    System.out.println(res);
    
    boolean res1 = datas.stream().allMatch(e -> e < 0);
    System.out.println(res1);
  }
}
