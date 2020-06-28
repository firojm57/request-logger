package com.greenboard.logger.context;

import java.util.HashMap;
import java.util.Map;

public class RequestLoggerContext {
    private static final RequestLoggerContextData contextData;

    static {
        contextData = new RequestLoggerContextData(new HashMap<>());
    }

    public static String getContextString() {
        Map<String, String> dataMap = contextData.getData();
        StringBuilder builder = new StringBuilder("");
        try {
            for (String key : dataMap.keySet()) {
                builder.append("[").append(key).append("]: ").append(dataMap.get(key)).append(" ");
            }
        } catch (Exception ex) {
            System.out.println("[RequestLogger] WARNING: Log context data not found");
        }
        return builder.toString();
    }

    public static void add(String key, String value) {
        Map<String, String> data = contextData.getData();
        if (data == null) {
            data = new HashMap<>();
            data.put(key, value);
            contextData.add(data);
        } else {
            contextData.add(key, value);
        }
    }

    public static void setContextData(Map<String, String> data) {
        contextData.add(data);
    }

    public static void remove(String key) {
        contextData.remove(key);
    }

    public static void clear() {
        contextData.clear();
    }
}
