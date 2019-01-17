package com.wanbo.common.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class DataFactory extends BasePooledObjectFactory<DataModel> {

    @Override
    public DataModel create() throws Exception {
        DataModel model = new DataModel(App1.version++);
        return model;
    }

    @Override
    public PooledObject<DataModel> wrap(DataModel obj) {
        // TODO Auto-generated method stub
        return new DefaultPooledObject<DataModel>(obj);
    }

}
