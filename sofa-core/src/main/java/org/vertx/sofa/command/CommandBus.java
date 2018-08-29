package org.vertx.sofa.command;

import org.vertx.sofa.exception.BasicErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.vertx.sofa.context.TenantContext;
import org.vertx.sofa.dto.Command;
import org.vertx.sofa.dto.Response;
import org.vertx.sofa.exception.CrmException;
import org.vertx.sofa.exception.ErrorCodeI;
import org.vertx.sofa.exception.InfraException;
import org.vertx.sofa.logger.Logger;
import org.vertx.sofa.logger.LoggerFactory;
/**
 * Just send Command to CommandBus, 
 * 
 * @author fulan.zjf 2017年10月24日 上午12:47:18
 */
@Component
public class CommandBus implements CommandBusI{
    
    Logger logger = LoggerFactory.getLogger(CommandBus.class);
    
    @Autowired
    private CommandHub commandHub;

    @SuppressWarnings("unchecked")
    @Override
    public Response send(Command cmd) {
        Response response = null;
        try {
            response = commandHub.getCommandInvocation(cmd.getClass()).invoke(cmd);
        }
        catch (Exception exception) {
            response = handleException(cmd, response, exception);
        }
        finally {
            TenantContext.remove();//Clean up context
        }
        return response;
    }

    private Response handleException(Command cmd, Response response, Exception exception) {
        logger.error(exception.getMessage(), exception);
        Class responseClz = commandHub.getResponseRepository().get(cmd.getClass());
        try {
            response = (Response) responseClz.newInstance();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InfraException(e.getMessage());
        }
        if (exception instanceof CrmException) {
            ErrorCodeI errCode = ((CrmException) exception).getErrCode();
            response.setErrCode(errCode.getErrCode());
        }
        else {
            response.setErrCode(BasicErrorCode.SYS_ERROR.getErrCode());
        }
        response.setErrMessage(exception.getMessage());
        return response;
    }
}
