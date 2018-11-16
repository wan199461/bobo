package com.wanbo.rocketmq;

import com.alibaba.fastjson.JSONObject;

public class Config {
    
    public static String data = "{\"reqData\":{\"phone\":\"846fbf4a43aa1e1cfb52962e1ea5cb81\"},\"institutionId\":\"jmeter_test\",\"requestId\":\"20170921164605547-8349BEEEE5C543AF\",\"responseData\":{\"matchScore\":1,\"multiScore\":7.0,\"matchTag\":1},\"prodList\":[\"MUL\"]}";

    public static void main(String...strings) {
        JSONObject obj = JSONObject.parseObject(data);
        System.out.println(obj.get("reqData"));
    }
    
}
