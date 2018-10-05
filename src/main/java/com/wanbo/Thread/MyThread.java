package com.wanbo.Thread;

import java.util.Map;

public class MyThread {
	
	public static void main(String[] args) {
		
		System.out.println("Begin");
		RunnableTest runnable = new RunnableTest();
		runnable.run();
		System.out.println("Main end");
	}

}


class RunnableTest implements Runnable {

	public void run() {
		   System.out.println("1");
		   try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println("2");
		   Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		   System.out.println(map);
	}
}
