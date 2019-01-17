package com.wanbo.common.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class CommonObjectPool extends GenericObjectPool<DataModel> {

    public CommonObjectPool(PooledObjectFactory<DataModel> factory, GenericObjectPoolConfig config,
            AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
