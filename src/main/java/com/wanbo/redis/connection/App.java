package com.wanbo.redis.connection;

import java.io.IOException;
import java.net.UnknownHostException;

public class App {

    public static void main(String[] args) throws UnknownHostException, IOException {
        RedisConnect con = new RedisConnect();
        con.open();

        System.out.println(con.auth("root"));
//        System.out.println(con.ping());
        
        System.out.println(con.commonCall(CommandEnum.PING, null));
    }

}
