package com.wanbo.rocketmq;

import java.util.Random;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

public class Config {

	public static String data = "{" + "  " + "  \"requestId\": \"20170921164605547-8349BEEEE5C543AF\","
			+ "    \"responseData\": {" + "  " + "      \"creditScore\": 0.000002358,"
			+ "        \"matchTag\": 1" + "    }," + "    \"sourceCode\": \"fintell\","
			+ "    \"apiCode\": \"FinTell_FinTell_C4CFP\"" + "}";

	public static String data() {
//		return generateEnumData().toJSONString();
	    String datad = generateDoubleData().toJSONString();
//	    String datad = generateLBSV1Data().toJSONString();
	    System.err.println(datad);
		return datad;
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

	
	public static JSONObject generateLBSV1Data() {
		JSONObject obj = new JSONObject();
		obj.put("requestId", UUID.randomUUID());
		obj.put("sourceCode", "fintell");
		obj.put("apiCode", "FinTell_FinTell_LBS");
		obj.put("requestTime", System.currentTimeMillis());
			
		String qqq = "{" + 
				"		\"scoreApplyRange\": -999.0," + 
				"		\"scoreApply\": -999.0," + 
				"		\"scoreWork\": 0.0," + 
				"		\"matchTag\": 1," + 
				"		\"scoreImage\": 0.0," + 
				"		\"scoreDeliverRange\": -999.0," + 
				"		\"scoreWorkRange\": 0," + 
				"		\"scoreOtherRange\": -999.0," + 
				"		\"matchScore\": 1," + 
				"		\"scoreHome\": 0.0," + 
				"		\"scoreIns\": -999.0," + 
				"		\"scoreHomeRange\": 0," + 
				"		\"scoreOther\": -999.0," + 
				"		\"scoreDeliver\": -999.0," + 
				"		\"scoreInsRange\": -999.0" + 
				"	}";
		JSONObject dataObj = JSONObject.parseObject(qqq);
		
		Random random = new Random();
		if(random.nextInt()%3 == 0) {
			dataObj.put("scoreImage", null);
			System.out.println("-------------------------");
		}
		
		obj.put("responseData", dataObj);
		return obj;
	}
	
	
	public static void main(String... strings) {
//        JSONObject obj = JSONObject.parseObject(data);
//        System.out.println(obj.getJSONObject("responseData").get("creditScore"));
//		JSONObject obj = generateEnumData();
//		System.out.println(obj.toJSONString());

		int i =5;
		while(--i >= 0) {
			JSONObject dat = generateLBSV1Data();
			System.out.println(dat);
		}
	}

}
