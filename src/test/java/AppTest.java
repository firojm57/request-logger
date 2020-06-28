import com.greenboard.logger.RequestLogger;
import com.greenboard.logger.context.RequestLoggerContext;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    private static final RequestLogger logger = RequestLogger.create(AppTest.class);

    public static void main(String[] args) {
        logger.error("Without context");
        Map<String, String> data = new HashMap<>();
        data.put("RID", "1234");
        RequestLoggerContext.setContextData(data);
        RequestLoggerContext.add("UID", "32223");
        logger.error("With context");
    }
}
