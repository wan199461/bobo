package com.wanbo.rocketmq;

import java.util.Random;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

public class Config {

	public static String data = "{\r\n" + "  " + "  \"requestId\": \"20170921164605547-8349BEEEE5C543AF\",\r\n"
			+ "    \"responseData\": {\r\n" + "  " + "      \"creditScore\": 0.000002358,\r\n"
			+ "        \"matchTag\": 1\r\n" + "    },\r\n" + "    \"sourceCode\": \"fintell\",\r\n"
			+ "    \"apiCode\": \"FinTell_FinTell_C4CFP\"\r\n" + "}";

	public static String data() {
		return generateEnumData().toJSONString();
//    	return generateDoubleData().toJSONString();
	}

	public static JSONObject generateEnumData() {

		JSONObject obj = new JSONObject();
		obj.put("requestId", "20181126164605547-8349BEEEE5C543AF");
		JSONObject responseData = new JSONObject();
		long time = System.currentTimeMillis();
		if (time % 4 == 0) {
			responseData.put("riskTag", "md000");
		} else if (time % 4 == 1) {
			responseData.put("riskTag", "md010");
		} else if (time % 4 == 2) {
			responseData.put("riskTag", "md020");
		} else if (time % 4 == 3) {
			responseData.put("riskTag", "md030");
		}
//    	responseData.put("responseData", responseData);
		obj.put("responseData", responseData);
		obj.put("sourceCode", "fintell");
		obj.put("apiCode", "FinTell_FinTell_AMUL");
		return obj;
	}

	public static JSONObject generateDoubleData() {
		JSONObject obj = new JSONObject();
		obj.put("requestId", UUID.randomUUID());
		obj.put("sourceCode", "fintell");
		obj.put("apiCode", "FinTell_FinTell_C4CFP");
		obj.put("requestTime", System.currentTimeMillis());
		
		Random random = new Random();

		JSONObject data = new JSONObject();
		long millis = System.currentTimeMillis();
		if (millis % 7 == 0) {
			data.put("creditScore", -999);
			data.put("matchTag", 0);
		} else {			
			data.put("creditScore", random.nextDouble());
			data.put("matchTag", 1);
		}
		obj.put("responseData", data);
		try {
			long d = (long)random.nextDouble()*1000;
			Thread.sleep(d);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static void main(String... strings) {
//        JSONObject obj = JSONObject.parseObject(data);
//        System.out.println(obj.getJSONObject("responseData").get("creditScore"));
//		JSONObject obj = generateEnumData();
//		System.out.println(obj.toJSONString());

		JSONObject dat = generateDoubleData();
		System.out.println(dat);
	}

}
