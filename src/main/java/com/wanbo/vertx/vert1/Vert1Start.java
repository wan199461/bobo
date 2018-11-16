package com.wanbo.vertx.vert1;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class Vert1Start {

	public static void main(String[] args) {
		System.err.println("vert begin");
		VertxOptions options = new VertxOptions();
		options.setEventLoopPoolSize(10);

		DeploymentOptions  depOptions = new DeploymentOptions();
		depOptions.setWorker(true);
		depOptions.setMultiThreaded(true);
		
		Vertx vertx = Vertx.vertx(options);
        
//		vertx.deployVerticle(new MyVertCycle());  // 测试用vertCycle		
		vertx.deployVerticle(new RestfulVerticle(), depOptions);  // 处理Get请求web服务器
		
	}

}
