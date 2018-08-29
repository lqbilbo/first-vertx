package org.vertx.sofa.event;

import org.vertx.sofa.dto.event.Event;
import org.vertx.sofa.exception.InfraException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 事件控制中枢
 * @author shawnzhan.zxy
 * @date 2017/11/20
 */
@SuppressWarnings("rawtypes")
@Component
public class EventHub {
    @Getter
    @Setter
    private Map<Class, EventHandlerI> eventRepository = new HashMap<>();
    
    @Getter
    private Map<Class, Class> responseRepository = new HashMap<>();
    
    public EventHandlerI getEventHandler(Class eventClass) {
        EventHandlerI eventHandlerI = findHandler(eventClass);
        if (eventHandlerI == null) {
            throw new InfraException(eventClass + "is not registered in eventHub, please register first");
        }
        return eventHandlerI;
    }

    /**
     * 注册事件
     * @param eventClz
     * @param executor
     */
    public void register(Class<? extends Event> eventClz, EventHandlerI executor){
        eventRepository.put(eventClz, executor);
    }

    private EventHandlerI findHandler(Class<? extends Event> eventClass){
        EventHandlerI eventHandlerI = null;
        Class cls = eventClass;
        eventHandlerI = eventRepository.get(cls);
        return eventHandlerI;
    }

}
