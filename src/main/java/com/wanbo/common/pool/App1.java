package com.wanbo.common.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.alibaba.fastjson.JSON;

public class App1 {
    
    //1. 使用apache提供的

    public static int version = 1;

    public static void main(String[] args) {

        PooledObjectFactory<DataModel> factory = new DataFactory();
        GenericObjectPoolConfig<DataModel> genericConfig = new GenericObjectPoolConfig<DataModel>();
        genericConfig.setMaxTotal(10);
        
        AbandonedConfig abandonedConfig = new AbandonedConfig();

        CommonObjectPool pool = new CommonObjectPool(factory, genericConfig, abandonedConfig);

        for (int i = 0; i < 11; i++) {
            DataModel proj = null;
            try {
                proj = pool.borrowObject(1000L);
                System.out.println(JSON.toJSONString(proj));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pool.returnObject(proj);
            }
        }
    }

}
