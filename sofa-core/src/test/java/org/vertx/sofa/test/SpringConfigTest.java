package org.vertx.sofa.test;

import org.vertx.sofa.TestConfig;
import org.vertx.sofa.boot.Bootstrap;
import org.vertx.sofa.boot.RegisterFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        Bootstrap bootstrap = (Bootstrap)context.getBean("bootstrap");
        RegisterFactory registerFactory = (RegisterFactory)context.getBean("registerFactory");
        System.out.println(registerFactory);
        System.out.println(bootstrap.getPackages());
    }
}
