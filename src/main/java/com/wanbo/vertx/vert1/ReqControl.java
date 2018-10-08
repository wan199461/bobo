package com.wanbo.vertx.vert1;

import java.util.concurrent.Semaphore;

public class ReqControl {

  public static Semaphore semaphore = new Semaphore(1000);

  public static void acquire() {
    try {
      int availablePermits = semaphore.availablePermits();
      int queueLen = semaphore.getQueueLength();
      System.out.println("availablePermits:" + availablePermits);
      System.out.println("queueLen:" + queueLen);
      semaphore.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public static void release() {
    semaphore.release();
  }

}
