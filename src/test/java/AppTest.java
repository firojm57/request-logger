import com.greenboard.logger.RequestLogger;
import com.greenboard.logger.context.RequestLoggerContext;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    private static final RequestLogger logger = RequestLogger.create(AppTest.class);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        logger.error(ANSI_BLACK + "Without context" + ANSI_RESET);
        logger.error(ANSI_RED + "Without context" + ANSI_RESET);
        logger.error(ANSI_GREEN + "Without context" + ANSI_RESET);
        logger.error(ANSI_YELLOW + "Without context" + ANSI_RESET);
        logger.error(ANSI_BLUE + "Without context" + ANSI_RESET);
        logger.error(ANSI_PURPLE + "Without context" + ANSI_RESET);
        logger.error(ANSI_WHITE + "Without context" + ANSI_RESET);
        logger.error(ANSI_CYAN + "Without context" + ANSI_RESET);
        Map<String, String> data = new HashMap<>();
        data.put("RID", "1234");
        RequestLoggerContext.setContextData(data);
        RequestLoggerContext.getContextString();
        RequestLoggerContext.add("UID", "32223");
        logger.error(ANSI_CYAN + "With context" + ANSI_RESET);
        RequestLoggerContext.clear();
        logger.error("Checking after clear");
    }
}
