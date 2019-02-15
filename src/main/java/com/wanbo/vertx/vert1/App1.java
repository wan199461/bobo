package com.wanbo.vertx.vert1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;

public class App1 {

    static final int UPPER = 0x00000010; // 0x 开头16进制

    static final int UP1 = 0b000010; // 0b 开头二进制

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(App1.UPPER);
        System.out.println(App1.UP1);

        Map<String, Double> map = new HashMap<>();
        map.put("1", 1D);
        map.put("2", 2.1);
        map.put("3", 3.0);
        map.put("4", 4.33);
        map.put("5", 5.88);

        for (Entry<String, Double> enty : map.entrySet()) {
            if (Integer.valueOf(enty.getKey()) % 2 == 0) {
                Integer k = Integer.valueOf(enty.getKey());
                map.put(enty.getKey(), enty.getValue() + 10);
                map.put(String.valueOf(k * 3), enty.getValue() + 50);
            }
        }
        System.out.println(JSON.toJSONString(map));
    }

}
