package com.wanbo.common.pool2;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.wanbo.common.pool.DataModel;

public class App1 {

    public static void main(String[] args) {

        PooledObjectFactory<DataModel> factory = new ModelDataPooledFactory();
        GenericObjectPoolConfig<DataModel> config = new GenericObjectPoolConfig<DataModel>();
        config.setMaxTotal(5);
        config.setTestOnBorrow(true);
        AbandonedConfig abandonedConfig = new AbandonedConfig();

        DataModelPools pools = new DataModelPools(factory, config, abandonedConfig);

        for (int i = 0; i <= 12; i++) {
            try {
                DataModel obj = pools.borrowObject(100*1000);
                System.out.print(String.format("i=%s 有效%s条",i, pools.getNumActive()));
            } catch (Exception e) {  
                e.printStackTrace();
            }
        }
    }
}
