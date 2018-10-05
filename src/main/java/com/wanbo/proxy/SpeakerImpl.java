package com.wanbo.proxy;

public class SpeakerImpl implements Speaker{

	public String speak(String param) {
		System.out.println("Param:" + param);
		return "OK";
	}

	public Integer speak2() {
		System.out.println("Speak2:" + 2323);
		return 2323;
	}

}
