package com.wanbo.vertx.vert1;

import io.vertx.core.Vertx;

public class Vert1Start {

	public static void main(String[] args) {
		System.err.println("vert begin");
		Vertx vertx = Vertx.vertx();
//		vertx.deployVerticle(new MyVertCycle());  // 测试用vertCycle
		
		vertx.deployVerticle(new RestfulVerticle());  // 处理Get请求web服务器
		
	}

}
