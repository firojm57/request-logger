package com.greenboard.logger.context;

import java.util.HashMap;
import java.util.Map;

public class RequestLoggerContext {
    private static final RequestLoggerContextData contextData;

    static {
        contextData = new RequestLoggerContextData(new HashMap<>());
    }

    /**
     * Creates string representation of log context data
     * Format = [key]: value
     * @return String representation of context data
     */
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
        if (dataMap != null && !dataMap.isEmpty()) {
            builder.append("- ");
        }
        return builder.toString();
    }

    /**
     * Adds context data which will be printed in below format <br><br>
     * <p>[key 1]: value 1 [key 2]: value 2 ... [key n]: value n - ACTUAL LOG MESSAGE</p> <br>
     * Note: Actual log message will be appended at the end of the log context data, its better to keep key short <br>
     * For Example, to print Request id before every log message<br>
     * key = RID, value = some_unique_id <br>
     * With above values message will get printed as below <br><br>
     * [RID]: some_unique_id - Actual log message
     *
     * @param key The log context data key
     * @param value The log context data value
     */
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

    /**
     * Adds context data which will be printed in below format <br><br>
     * <p>[key 1]: value 1 [key 2]: value 2 ... [key n]: value n - ACTUAL LOG MESSAGE</p> <br>
     * Note: Actual log message will be appended at the end of the log context data, its better to keep key short <br>
     * For Example, to print Request id before every log message<br>
     * key = RID, value = some_unique_id <br>
     * With above values message will get printed as below <br><br>
     * [RID]: some_unique_id - Actual log message
     *
     * @param data The log context data map
     */
    public static void setContextData(Map<String, String> data) {
        contextData.add(data);
    }

    /**
     * Removes the log context data associated with key
     *
     * @param key The key to remove from the log context data
     */
    public static void remove(String key) {
        contextData.remove(key);
    }

    /**
     * Clears the log context data
     *
     */
    public static void clear() {
        contextData.clear();
    }
}
