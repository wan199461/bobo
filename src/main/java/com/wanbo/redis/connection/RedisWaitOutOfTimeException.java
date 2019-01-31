package com.wanbo.redis.connection;

public class RedisWaitOutOfTimeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 8225905748019224550L;
    
    public RedisWaitOutOfTimeException(){
           super("Wait Out Of Time Range");
    }

}
