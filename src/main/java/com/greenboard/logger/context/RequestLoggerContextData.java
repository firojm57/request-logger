package com.greenboard.logger.context;

import java.util.Map;

class RequestLoggerContextData {
    private final ThreadLocal<Map<String, String>> logContextData;

    RequestLoggerContextData(Map<String, String> dataMap) {
        logContextData = new ThreadLocal<>();
    }

    Map<String, String> getData() {
        return logContextData.get();
    }

    void add(Map<String, String> data) {
        logContextData.set(data);
    }

    void add(String key, String value) {
        logContextData.get().put(key, value);
    }

    void remove(String key) {
        logContextData.get().remove(key);
    }

    void clear() {
        logContextData.remove();
    }
}
