package org.vertx.sofa.command;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Inherited
@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PostInterceptor {

    Class<? extends org.vertx.sofa.dto.Command>[] commands() default {};

}
