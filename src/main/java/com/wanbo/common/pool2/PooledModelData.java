package com.wanbo.common.pool2;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.wanbo.common.pool.DataModel;

public class PooledModelData extends DefaultPooledObject<DataModel>{

    public PooledModelData(DataModel object) {
        super(object);
    }

}
