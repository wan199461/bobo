package com.wanbo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class App5 {
 
   private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-HH mm:ss.SSS");
    
    public static void main(String[] args) {
          System.out.println("begin args= " + JSON.toJSONString(args));
          App5 app = new App5();
          for(int i=0; i <1;) {
              app.waiting();
              System.err.println("System Wait " + sdf.format(new Date()));
          }
    }
    
    
    private synchronized void waiting() {
        try {
            this.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
