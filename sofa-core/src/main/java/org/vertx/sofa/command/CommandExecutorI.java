package org.vertx.sofa.command;

import org.vertx.sofa.dto.Command;
import org.vertx.sofa.dto.Response;

/**
 * 
 * CommandExecutorI
 * 
 * @author fulan.zjf 2017年10月21日 下午11:01:05
 */
public interface CommandExecutorI<R extends Response, C extends Command> {

    public R execute(C cmd);
}
