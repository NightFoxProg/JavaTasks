package Task9;

public class FileMaxSizeReachedException extends RuntimeException {
    private String filePath;
    private long maxFileSize;
    private long currentFileSize;

    public FileMaxSizeReachedException(String filePath, long maxFileSize, long currentFileSize) {
        this.filePath = filePath;
        this.maxFileSize = maxFileSize;
        this.currentFileSize = currentFileSize;
    }

    @Override
    public String getMessage() {
        return String.format("Перевищено максимальний розмір файлу: %s. " +
                        "Максимальний розмір: %d байт. Поточний розмір: %d байт.",
                filePath, maxFileSize, currentFileSize);
    }
}
