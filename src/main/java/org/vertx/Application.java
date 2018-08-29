package org.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * @author luoqi04
 * @version $Id: Application.java, v 0.1 2018/8/29 下午2:44 luoqi Exp $
 */
public class Application extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) throws Exception {
      vertx.createHttpServer()
              .requestHandler(req -> {
                  req.response().end("Hello Vert.x");
              })
              .listen(8080, result -> {
                  if (result.succeeded()) {
                      startFuture.complete();
                  } else {
                    startFuture.fail(result.cause());
                  }
              });
  }
}
