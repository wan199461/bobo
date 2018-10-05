package com.wanbo.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloProxy implements  InvocationHandler{

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(proxy, args);
		return result;
	}

}
