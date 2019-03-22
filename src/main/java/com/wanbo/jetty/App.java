package com.wanbo.jetty;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;

public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String... strings) throws Exception {
        System.out.println("------ jetty begin   -----");
        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(HelloServlet.class, "/");
        server.start();
        server.join();
    }

    public static class HelloServlet extends HttpServlet {

        private static final long serialVersionUID = 2694418844665126576L;

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) {
            JSONObject obj = new JSONObject();
            obj.put("Jetty", "Jetty Hello");
            try {
                Map map = req.getParameterMap();
                logger.info("ObjParameterData:{}", JSON.toJSONString(map));

                obj.put("Data", map);
                PrintWriter writer = resp.getWriter();
                writer.write(obj.toJSONString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
