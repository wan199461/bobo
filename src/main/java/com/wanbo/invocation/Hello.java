package com.wanbo.invocation;

public class Hello {
	
	public String printHello(String param1, Integer param2) {
		System.out.println("Hello  " + param1 + "  " + param2);
		return param1 + Integer.toString(param2);
	}

}
