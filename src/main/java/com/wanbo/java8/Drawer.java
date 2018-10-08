package com.wanbo.java8;

public interface Drawer {
  
  static String drawPoint(QingWind wind) {
    wind.wind("23333");
    return "point";
  }

}
