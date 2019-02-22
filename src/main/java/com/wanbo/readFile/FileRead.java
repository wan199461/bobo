package com.wanbo.readFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FileRead {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\admin\\Desktop\\temp\\123.json";
        readFile(path);
    }

    public static void readFile(String path) throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[fis.available()];
        fis.read(b);

        String da = new String(b);

        JSONArray datas = JSONObject.parseArray(da);

        System.out.println(datas.size());

        List<Double> kk = new ArrayList<>();
        Set<Double> kh = new HashSet<>();
        for (int i = 0; i < datas.size(); i++) {
              JSONObject data = datas.getJSONObject(i);
              kk.add(data.getDouble("data"));
              kh.add(data.getDouble("data"));
        }
        
        System.out.println(kh.size());
        System.out.println(JSON.toJSONString(kh));
        
        
    }

}
