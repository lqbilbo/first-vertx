package org.vertx.sofa.event;

import org.vertx.sofa.dto.event.Event;
import org.vertx.sofa.dto.Response;


/**
 * EventBus interface
 * @author shawnzhan.zxy
 * @date 2017/11/20
 */
public interface EventBusI {

    /**
     * Send event to EventBus
     * 
     * @param event
     * @return Response
     */
    public Response fire(Event event);
}
