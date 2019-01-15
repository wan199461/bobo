package com.wanbo.rocketmq;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alpData = AlpAppProducer.generateAlpData();
		JSONObject obj = JSONObject.parseObject(alpData);
		Date evnTime = obj.getDate("eventTime");
		System.out.println(obj.toJSONString());
		System.out.println(evnTime.getTime());
	}

}
