package com.wanbo.invocation;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.security.auth.Subject;

public class App {

	public static void main(String[] args) throws Throwable {
		
		Hello hello = new Hello();
		Method method = hello.getClass().getMethod("printHello", String.class, Integer.class);
		HelloProxy handler = new HelloProxy();
		Object[] arg = new Object[2];
		arg[0] = "Lily";
		arg[1] = 23;
		
		Object result = handler.invoke(hello, method, arg);
		System.out.print("Result:" + result);

	}

}
