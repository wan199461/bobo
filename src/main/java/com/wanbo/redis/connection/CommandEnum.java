package com.wanbo.redis.connection;

public enum CommandEnum {

    PING("PING", 0), SET("SET", 2), AUTH("AUTH", 1), GET("GET", 1);

    private String command;

    private int paramnum;

    private CommandEnum(String command, int num) {
        this.command = command;
        this.paramnum = num;
    }

    public String getCommand() {
        return command;
    }

    public int getParamnum() {
        return paramnum;
    }
}
