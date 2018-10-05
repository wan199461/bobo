package com.wanbo;

public class MyDefaultException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 946155032142621105L;
   
	MyDefaultException(){
		super("自定义异常");
	}
	
	MyDefaultException(String msg){	
		super(msg);
	}

}
