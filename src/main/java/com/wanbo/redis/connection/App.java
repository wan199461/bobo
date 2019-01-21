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
        
        String[] params = {"hehe", "eretr"};
        System.out.println(con.commonCall(CommandEnum.SET, params));
        
        String[] params1 = {"hehe"};
        System.out.println(con.commonCall(CommandEnum.GET, params1));
    }

}
