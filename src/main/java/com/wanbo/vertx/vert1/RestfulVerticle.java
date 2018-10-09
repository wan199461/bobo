package com.wanbo.vertx.vert1;

import java.util.Set;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.Cookie;
import io.vertx.ext.web.Router;


/**
 * vert web get请求测试
 *
 */
public class RestfulVerticle extends AbstractVerticle { 

  @Override
  public void start(Future<Void> startFuture) throws Exception {

    System.err.println("RestfulVerticle start");
    // 路由器: 路由不同的rest接口
    Router router = Router.router(vertx);
    // 处理器: 将请求上下文信息放入RoutingContext中
    router.route().handler(BodyHandler.create());

    // 带参数Get请求
    router.get("/:param1").handler(this::handleFile);

    // 一个处理Get方法的rest接口
    router.get().handler(this::handleGet);

    // 一个处理Post方法的rest接口
    router.post().handler(this::handlePost);

    vertx.createHttpServer().requestHandler(router::accept).listen(8080);

  }

  // Get 请求处理handler
  private void handleGet(RoutingContext context) {
    ReqControl.acquire();

    String bodyType = context.getAcceptableContentType();
//    System.err.println(bodyType);
    
    String uri = context.request().uri();
//    System.out.println("Uri:" + uri);

    context.response().putHeader("content-type", "application/json");

    JsonObject obj = new JsonObject();
    obj.put("name", "Lily");

    context.response().end(obj.encodePrettily());
    
    ReqControl.release();
  }


  // Post 请求处理handler
  private void handlePost(RoutingContext context) {
    
    String name = context.request().headers().get("User-Name");
    System.out.println("name:" + name);
    
    String absUri = context.request().absoluteURI();
    System.out.println("AbsUri:" + absUri);
    
    JsonObject bodyJson = context.getBodyAsJson();
    System.out.println("Body:" + bodyJson.encode());

    context.response().putHeader("content-type", "application/json");

    JsonObject obj = new JsonObject();
    obj.put("name", "malei");
    context.response().end(obj.encodePrettily());
  }


  private void handleFile(RoutingContext context) {
    ReqControl.acquire();
//    String param1 = context.request().getParam("param1");
//    System.err.println("Req Param1:" + param1);

    JsonObject obj = new JsonObject();
    JsonObject body = new JsonObject();
    obj.put("Body", body);
    body.put("score", 23);
    body.put("message", "success");
    body.put("status", 0);
    String bodyMsg = obj.encodePrettily();
//    System.out.println(bodyMsg);

    try {
      Thread.sleep(1800);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    context.response().putHeader("Content-Length", String.valueOf(bodyMsg.length()));
    context.response().write(bodyMsg).close();
    
    ReqControl.release();
  }
}

















