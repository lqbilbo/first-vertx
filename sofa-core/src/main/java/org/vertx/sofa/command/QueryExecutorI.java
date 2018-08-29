package org.vertx.sofa.command;

import org.vertx.sofa.dto.Command;
import org.vertx.sofa.dto.Response;

public interface QueryExecutorI<R extends Response, C extends Command> extends CommandExecutorI<R,C>{

}
