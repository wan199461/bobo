package com.wanbo.proxy;

import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

		
		TheDynaticProxy dynaticProxy = new TheDynaticProxy();
		Speaker speaker = (Speaker)dynaticProxy.instance(new SpeakerImpl());
//		String data = speaker.speak("Hello World");
		Integer data = speaker.speak2();
		System.out.println("Data:" + data);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("", "");
		map.remove("");
		
	}

}
