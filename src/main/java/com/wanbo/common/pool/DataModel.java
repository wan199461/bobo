package com.wanbo.common.pool;

public class DataModel {

    private String version;

    private String data;

    public DataModel(int version) {
        this.version = String.valueOf(version);
    }

    public String getVersion() {
        return version;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
