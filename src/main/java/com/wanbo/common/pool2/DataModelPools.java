package com.wanbo.common.pool2;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.wanbo.common.pool.DataModel;

public class DataModelPools extends GenericObjectPool<DataModel>{

    public DataModelPools(PooledObjectFactory<DataModel> factory, GenericObjectPoolConfig<DataModel> config,
            AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }

}
