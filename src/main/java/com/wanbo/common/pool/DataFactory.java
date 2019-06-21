package com.wanbo.common.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;


// apache提供的工厂方法，实际是BasePooledObjectFactory中已经实现了工厂接口定义的makeObject方法
// makeObject实际上调用wrap方法，warp方法中调用create方法创建对象
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
