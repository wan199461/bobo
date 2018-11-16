package com.wanbo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class App3 {
    
//  private static Map<String, String> map =  new ConcurrentHashMap<String, String>();
    
    private static Map<String, String> map =  new ConcurrentHashMap<String, String>();
  
  static {
      for(int i=0; i<9; i++) {
          map.put(String.valueOf(i), String.valueOf(i+3));
      }
  }

  public static void main(String[] args) {
   

      
      new Thread(new Runnable() {       
        @Override
        public void run() {
            while(1==1) {
                map.put("1", "1");
            }
            
        }
    }).start();
      
      while(1==1) {
          map.forEach((k,v)->{
              System.out.println(k);
          });
      }
    
  }

}
