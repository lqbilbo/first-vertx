package org.vertx.sofa.event;

import org.vertx.sofa.dto.Response;
import org.vertx.sofa.dto.event.Event;
import org.vertx.sofa.exception.BasicErrorCode;
import org.vertx.sofa.exception.CrmException;
import org.vertx.sofa.exception.ErrorCodeI;
import org.vertx.sofa.exception.InfraException;
import org.vertx.sofa.logger.Logger;
import org.vertx.sofa.logger.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Event Bus
 *
 * @author shawnzhan.zxy
 * @date 2017/11/20
 */
@Component
public class EventBus implements EventBusI{
    Logger logger = LoggerFactory.getLogger(EventBus.class);

    @Autowired
    private EventHub eventHub;

    @SuppressWarnings("unchecked")
    @Override
    public Response fire(Event event) {
        Response response = null;
        try {
            response = eventHub.getEventHandler(event.getClass()).execute(event);
        }catch (Exception exception) {
            response = handleException(event, response, exception);
        }
        return response;
    }

    private Response handleException(Event cmd, Response response, Exception exception) {
        Class responseClz = eventHub.getResponseRepository().get(cmd.getClass());
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
        logger.error(exception.getMessage(), exception);
        return response;
    }
}
