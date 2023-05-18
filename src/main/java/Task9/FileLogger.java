package Task9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileLogger {
    private FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
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

        String logMessage = String.format("[%s][%s] Повідомлення: %s%n",
                getCurrentTime(), level, message);

        try {
            FileWriter fileWriter = new FileWriter(configuration.getFile(), true);
            fileWriter.write(logMessage);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Помилка при записі в файл: " + e.getMessage());
        }

        if (configuration.getFile().length() > configuration.getMaxFileSize()) {
            throw new FileMaxSizeReachedException(configuration.getFile().getPath(),
                    configuration.getMaxFileSize(), configuration.getFile().length());
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(configuration.getFormat());
        return dateFormat.format(new Date());
    }
}
class FileLoggerConfiguration {
    private File file;
    private LogLevel level;
    private long maxFileSize;
    private String format;

    public FileLoggerConfiguration(File file, LogLevel level, long maxFileSize, String format) {
        this.file = file;
        this.level = level;
        this.maxFileSize = maxFileSize;
        this.format = format;
    }

    public File getFile() {
        return file;
    }

    public LogLevel getLevel() {
        return level;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getFormat() {
        return format;
    }
}

class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(String filePath) {
        File file = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileLine;
            String format = null;
            LogLevel level = null;
            long maxFileSize = 0;

            while ((fileLine = reader.readLine()) != null) {
                String[] parts = fileLine.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    switch (key) {
                        case "FILE":
                            file = new File(value);
                            break;
                        case "LEVEL":
                            level = LogLevel.valueOf(value);
                            break;
                        case "MAX-SIZE":
                            maxFileSize = Long.parseLong(value);
                            break;
                        case "FORMAT":
                            format = value;
                            break;
                    }
                }
            }

            if (format != null && level != null && maxFileSize > 0) {
                return new FileLoggerConfiguration(file, level, maxFileSize, format);
            }
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні конфігурації: " + e.getMessage());
        }

        return null;
    }
    public static void main(String[] args) {
        // Завдання 1-4
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(
                new File("log.txt"), LogLevel.DEBUG, 1024, "yyyy-MM-dd HH:mm:ss");
        FileLogger fileLogger = new FileLogger(fileLoggerConfiguration);

        fileLogger.debug("Debug message 1");
        fileLogger.info("Info message 1");

        // Завдання 5
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration loadedConfig = loader.load("config.txt");
        if (loadedConfig != null) {
            FileLogger loadedFileLogger = new FileLogger(loadedConfig);
            loadedFileLogger.debug("Debug message 2");
            loadedFileLogger.info("Info message 2");
        }

        // Завдання 6
        LogFileManager logFileManager = new LogFileManager("logs", 1024);
        File currentLogFile = logFileManager.getCurrentLogFile();
        System.out.println("Current Log File: " + currentLogFile.getAbsolutePath());
        logFileManager.checkLogFileSize();

        // Завдання 7
        StdoutLoggerConfiguration stdoutLoggerConfiguration = new StdoutLoggerConfiguration(LogLevel.INFO);
        StdoutLogger stdoutLogger = new StdoutLogger(stdoutLoggerConfiguration);

        stdoutLogger.debug("Debug message 3");
        stdoutLogger.info("Info message 3");
    }

}

