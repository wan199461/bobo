package com.wanbo.vertx.vert1;

import io.vertx.core.AbstractVerticle;

public class MyVertCycle extends AbstractVerticle {

	@Override
	public void start() throws Exception {
		System.out.println("MyVertCycle started");
	}

	@Override
	public void stop() throws Exception {
		System.out.println("MyVertCycle stopped");
	}

}
