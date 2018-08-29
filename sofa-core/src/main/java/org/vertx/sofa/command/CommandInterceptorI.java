package org.vertx.sofa.command;

import org.vertx.sofa.dto.Command;
import org.vertx.sofa.dto.Response;

/**
 * Interceptor will do AOP processing before or after Command Execution
 * 
 * @author fulan.zjf 2017年10月25日 下午4:04:43
 */
public interface CommandInterceptorI {
   
   /**
    * Pre-processing before command execution
    * @param command
    */
   default public void preIntercept(Command command){};
   
   /**
    * Post-processing after command execution
    * @param command
    * @param response, Note that response could be null, check it before use
    */
   default public void postIntercept(Command command, Response response){};

}
