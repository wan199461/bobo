package com.wanbo.jetty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import com.alibaba.fastjson.JSONObject;

public class App {

    public static void main(String... strings) throws Exception {
        System.out.println("------ jetty begin   -----");
        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(HelloServlet.class, "/hello");
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
