package com.wanbo;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class App4 {

    public static void main(String[] args) {
        Set<String> sets = new HashSet<String>();
        sets.add("233");
        sets.add("23");
        for(int i=0;i<5;i++) {
            sets.add(String.valueOf(Math.random()));
        }
        
        String[] datas = new  String[sets.size()];
        sets.toArray(datas);
        System.out.println(JSON.toJSONString(datas));
        
        
    }

}
