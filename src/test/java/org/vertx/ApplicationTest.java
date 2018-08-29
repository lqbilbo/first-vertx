package org.vertx;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author luoqi04
 * @version $Id: ApplicationTest.java, v 0.1 2018/8/29 下午2:57 luoqi Exp $
 */
@RunWith(VertxUnitRunner.class)
public class ApplicationTest {

    //
    private Vertx vertx;

    @Before
    public void setUp(TestContext context) {
        vertx = Vertx.vertx();
        vertx.deployVerticle(Application.class.getName(),
                context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void testApplication(TestContext context) {
      final Async async = context.async();

      vertx.createHttpClient().getNow(8080, "localhost", "/", response -> {
          response.handler(body -> {
              context.assertTrue(body.toString().contains("Hello"));
              async.complete();
          });
      });
    }

}
