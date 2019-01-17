package com.wanbo.redis.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisConnect {

    private static Logger logger = LoggerFactory.getLogger(RedisConnect.class);

    private final int BUFF_SIZE = 1024;

    private final String LINE_FEED = "\r\n";

    private final String COMMAND_LEN_BEGIN = "*";

    private final String PARAM_LEN_BEGIN = "$";

    private OutputStream os;

    private InputStream is;

    public void open() throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 6379);
        this.os = socket.getOutputStream();
        this.is = socket.getInputStream();
    }

    public String ping() throws IOException {
        StringBuilder command = new StringBuilder();
        command.append("*1\r\n");
        command.append("$").append(CommandEnum.PING.getCommand().length()).append(LINE_FEED);
        command.append(CommandEnum.PING.getCommand()).append(LINE_FEED);
        logger.debug("ping command={}", command.toString());

        os.write(command.toString().getBytes());
        byte[] bytes = new byte[BUFF_SIZE];
        is.read(bytes);
        return new String(bytes);
    }

    public String auth(String pass) throws IOException {
        StringBuilder command = new StringBuilder();
        command.append("*2\r\n");
        command.append("$").append(CommandEnum.AUTH.getCommand().length()).append(LINE_FEED);
        command.append(CommandEnum.AUTH.getCommand()).append(LINE_FEED);
        command.append("$").append(pass.length()).append(LINE_FEED);
        command.append(pass).append(LINE_FEED);
        logger.debug("auth command={}", command.toString());

        os.write(command.toString().getBytes());
        byte[] bytes = new byte[BUFF_SIZE];
        is.read(bytes);
        return new String(bytes);
    }

}
