package com.wanbo.common.pool2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;

import com.wanbo.common.pool.DataModel;

public class ModelDataPooledFactory extends BasePooledObjectFactory<DataModel> {
    
    private static int cnt = 1;

    @Override
    public DataModel create() throws Exception {
        
        return new DataModel(cnt++);
    }

    @Override
    public PooledObject<DataModel> wrap(DataModel obj) {
        
        return new PooledModelData(obj);
    }
    
    @Override
    public boolean validateObject(final PooledObject<DataModel> p) {
        DataModel model = p.getObject();
        if(Integer.valueOf(model.getVersion())%2 == 1) {
            System.out.println(String.format("Version=%s should drop", model.getVersion()));
            return false;
        }
        
        System.out.println(String.format("Version=%s should not", model.getVersion()));
        return true;
    }
}
