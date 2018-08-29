package org.vertx.sofa.command;

import org.vertx.sofa.dto.Command;
import org.vertx.sofa.dto.Response;

/**
 * 
 * CommandBus
 * 
 * @author fulan.zjf 2017年10月21日 下午11:00:58
 */
public interface CommandBusI {

    /**
     * Send command to CommandBus, then the command will be executed by CommandExecutor
     * 
     * @param Command or Query
     * @return Response
     */
    public Response send(Command cmd);
}
