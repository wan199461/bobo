package java.util;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;

public class App {

    public static void main(String[] args) {
        KMap kmap = new KMap();
        kmap.put("1", 1D);
        
        System.out.println(kmap.size);
        System.out.println(JSON.toJSONString(kmap));
    }

}
