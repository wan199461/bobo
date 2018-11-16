package com.wanbo.java8;

import java.util.Optional;

public class OptionalApp {
  
  public static void main(String...strings) {
    
//    optional();
    
    
  }

  
  public static void optional() {
    Optional< String > fullName = Optional.ofNullable(null);
    System.out.println(fullName.isPresent());
    System.out.println(fullName.empty());
  }
  
  
}
