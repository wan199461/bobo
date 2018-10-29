package com.wanbo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TheDynaticProxy implements InvocationHandler{

	private Speaker speaker;
	
	public Object instance(Speaker proxy){
		speaker = proxy;
		Class<? extends Speaker> clazz = proxy.getClass();
		Object object = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
		return object;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Begin Invoke");
		Object obj = method.invoke(speaker, args);
		System.out.println("After Invoke");
		return obj;
	}

}
