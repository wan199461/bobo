package com.wanbo;

import com.alibaba.fastjson.JSON;

public class App2 {
	
	private static int data;

	public static void main(String[] args) {
	
//		testFinally();
//		testData();
		testInteger();
		
	}
	
	
	private static void testInteger() {
		Integer data = new Integer(2048);
		Integer data1 = 2048;
		System.out.println(2048 == data);
		System.out.println("2:" + data.equals(2048));
		
		System.out.println(data1 == data);   // 此处需要注意
		System.out.println("6" + data.equals(2048));
		
		Integer data3 = 127;
		Integer data4 = 127;
		System.out.println(data3 == data4); // 此处如果是128则不相等
		System.out.println("8:" + data3.equals(data4));
	}
	
	
	private static void testFinally() {
		DataBean db = new DataBean();
		db.age = 20;
		db.len = 11;
		db.name = "Wf";
		db = changeDataBean(db);
		System.out.println("result:" + JSON.toJSONString(db));
	}
	
	
	public static DataBean changeDataBean(DataBean db) {

		try{	
			System.out.println("try" + JSON.toJSONString(db));
			return db;
			
		}finally {
			db.age = 23;
			System.out.println("finally:" + JSON.toJSONString(db));
		}

	}
	
	
	public static void testData() {
		
		Integer i = 10;
		System.out.println("i1:" + i);
		changeData(i);
		System.out.println("i2:" + i);
		
	}
	
	
	public static void changeData(Integer i) {
		
		i++;
		System.out.println("I:" + i);
		
	}
	

}
