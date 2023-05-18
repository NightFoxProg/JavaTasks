package Task9;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFileManager {
    private static final String LOG_FILE_PREFIX = "Log_";
    private static final String LOG_FILE_EXTENSION = ".txt";

    private File currentLogFile;
    private long maxFileSize;
    private String logFilePath;

    public LogFileManager(String logFilePath, long maxFileSize) {
        this.logFilePath = logFilePath;
        this.maxFileSize = maxFileSize;
        createLogFile();
    }

    public File getCurrentLogFile() {
        return currentLogFile;
    }

    private void createLogFile() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm");
        String timestamp = dateFormat.format(new Date());
        String fileName = LOG_FILE_PREFIX + timestamp + LOG_FILE_EXTENSION;
        currentLogFile = new File(logFilePath, fileName);

        try {
            currentLogFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Помилка при створенні файлу логу: " + e.getMessage());
        }
    }

    public void checkLogFileSize() {
        if (currentLogFile.length() >= maxFileSize) {
            createLogFile();
        }
    }
}
