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
    
    private static final int RETRY_TIMES = 5;

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
        byte[] bytes = new byte[is.available()];
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

    /**
     * 
     * @param order
     * @param param
     * @return
     * @throws Exception 
     */
    public String commonCall(CommandEnum order, String... param) throws Exception {
        synchronized (this) {
            int paramnum = order.getParamnum(); // 参数的个数
            String cmd = order.getCommand();

            StringBuilder commands = new StringBuilder();
            commands.append(COMMAND_LEN_BEGIN).append(paramnum + 1).append(LINE_FEED); // 总的命令个数位参数数量加上命令(1个)
            commands.append(PARAM_LEN_BEGIN).append(cmd.length()).append(LINE_FEED);
            commands.append(cmd).append(LINE_FEED);
            for (int i = 0; i < paramnum; i++) {
                String cmdi = param[i];
                commands.append(PARAM_LEN_BEGIN).append(cmdi.length()).append(LINE_FEED);
                commands.append(cmdi).append(LINE_FEED);
            }
            System.out.println(commands.toString());
            os.write(commands.toString().getBytes());
            byte[] bytes = new byte[BUFF_SIZE];
            int count = 0;
            while(count < RETRY_TIMES) {
                if(is.available() > 0) {
                    is.read(bytes);
                    return new String(bytes);
                }
                wait(100);
            }
            throw new RedisWaitOutOfTimeException();           
        }
    }

}
