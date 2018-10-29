package com.wanbo.utils;

public class VMUtils {
  
  private static Runtime rt = Runtime.getRuntime();
  
  private static final int byteToMb = 1024 * 1024;
  
  private static final int byteToKb = 1024;
  
  
  
  public static long totalMemory(TYPE type) {
    long total = rt.totalMemory();
    switch (type) {
      case B:
        return total;
      case KB:
        return total/byteToKb;
      case MB:
        return total/byteToMb;
      default:
        return total;
    }
  }
  
  
  
  
  
  
  
  

  public static enum TYPE {

    B("byte"), KB("1024 byte"), MB("1024*1024 byte");

    private TYPE(String size) {
      this.size = size;
    }

    private String size;
  }

  

  // private
  //
  // long vmFree = 0;
  // long vmUse = 0;
  // long vmTotal = 0;
  // long vmMax = 0;
  //
  // Runtime rt = Runtime.getRuntime();
  // vmTotal = rt.totalMemory() / byteToMb;
  // vmFree = rt.freeMemory() / byteToMb;
  // vmMax = rt.maxMemory() / byteToMb;
  // vmUse = vmTotal - vmFree;
  // System.out.println("JVM内存已用的空间为：" + vmUse + " MB");
  // System.out.println("JVM内存的空闲空间为：" + vmFree + " MB");
  // System.out.println("JVM总内存空间为：" + vmTotal + " MB");
  // System.out.println("JVM总内存空间为：" + vmMax + " MB");

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
