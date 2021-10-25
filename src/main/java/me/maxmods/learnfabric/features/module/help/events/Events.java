package me.maxmods.learnfabric.features.module.help.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events {
    static final Map<EventType, List<Handler>> HANDLERS = new HashMap<>();

    public static void registerEventHandler(EventType event, Handler handler) {
        if (!HANDLERS.containsKey(event)) HANDLERS.put(event, new ArrayList<>());
        HANDLERS.get(event).add(handler);
    }

    public static boolean fireEvent(EventType event, Events argument) {
        if (HANDLERS.containsKey(event)) {
            for (Handler handler : HANDLERS.get(event)) {
                handler.onFired(argument);
            }
        }
        return argument.isCancelled();
    }

    private boolean isCancelled() {
        return false;
    }

    public interface Handler {
        void onFired(Events event);
    }
}
