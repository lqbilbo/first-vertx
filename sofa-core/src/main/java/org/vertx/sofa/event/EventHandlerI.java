package org.vertx.sofa.event;

import org.vertx.sofa.dto.event.Event;
import org.vertx.sofa.dto.Response;

/**
 * event handler
 *
 * @author shawnzhan.zxy
 * @date 2017/11/20
 */
public interface EventHandlerI<R extends Response, E extends Event> {

    public R execute(E e);
}
