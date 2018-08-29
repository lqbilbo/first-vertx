package org.vertx.sofa.boot;

import org.vertx.sofa.logger.Logger;
import org.vertx.sofa.logger.LoggerFactory;

import java.util.function.Function;

/**
 * @author fulan.zjf
 * @date 2017/12/21
 */
public abstract class ComponentExecutor {

    public <R, C> R execute(Class<C> targetClz, Function<C, R> exeFunction) {
        C component = locateComponent(targetClz);
        return exeFunction.apply(component);
    }

    protected abstract <C> C locateComponent(Class<C> targetClz);
}
