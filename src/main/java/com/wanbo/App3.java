package com.wanbo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class App3 {

  public static void main(String[] args) throws UnknownHostException {
     
   InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
   String ip = inetAddress.getHostAddress();
   System.out.println(ip);
   
  }

}
