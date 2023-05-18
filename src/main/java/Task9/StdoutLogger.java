package Task9;

public class StdoutLogger {
    private StdoutLoggerConfiguration configuration;

    public StdoutLogger(StdoutLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    private void log(LogLevel level, String message) {
        if (level.ordinal() > configuration.getLevel().ordinal()) {
            return;
        }

        String logMessage = String.format("[%s][%s] Повідомлення: %s",
                getCurrentTime(), level, message);
        System.out.println(logMessage);
    }

    private String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }
}
