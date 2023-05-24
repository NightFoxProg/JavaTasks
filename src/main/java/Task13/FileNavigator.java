package Task13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        fileMap = new HashMap<>();
    }

    public void add(FileData fileData) {
        String path = fileData.getPath();
        if (!path.equals(getKeyFromPath(path))) {
            System.out.println("Error: Path key and file path do not match");
            return;
        }

        if (fileMap.containsKey(path)) {
            fileMap.get(path).add(fileData);
        } else {
            List<FileData> fileList = new ArrayList<>();
            fileList.add(fileData);
            fileMap.put(path, fileList);
        }
    }

    public List<FileData> find(String path) {
        List<FileData> fileList = fileMap.getOrDefault(path, new ArrayList<>());
        return new ArrayList<>(fileList);
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> filteredFiles = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            for (FileData fileData : fileList) {
                if (fileData.getSize() <= maxSize) {
                    filteredFiles.add(fileData);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            allFiles.addAll(fileList);
        }
        allFiles.sort((file1, file2) -> Long.compare(file1.getSize(), file2.getSize()));
        return allFiles;
    }

    private String getKeyFromPath(String path) {
        int index = path.lastIndexOf('/');
        if (index >= 0 && index < path.length() - 1) {
            return path.substring(index + 1);
        }
        return path;
    }

    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();

        FileData file1 = new FileData("files.txt", 100, "/path/to/file");
        FileData file2 = new FileData("firstApp.java", 200, "/path/to/file");

        navigator.add(file1);
        navigator.add(file2);

        System.out.println("Files in '/path/to/file':");
        List<FileData> files = navigator.find("/path/to/file");
        for (FileData file : files) {
            System.out.println(file.getName());
        }

        System.out.println("\nFilter files by size (maxSize = 150):");
        List<FileData> filteredFiles = navigator.filterBySize(150);
        for (FileData file : filteredFiles) {
            System.out.println(file.getName());
        }

        System.out.println("\nRemove '/path/to/file':");
        navigator.remove("/path/to/file");

        System.out.println("\nFiles in '/path/to/file' after removal:");
        files = navigator.find("/path/to/file");
        for (FileData file : files) {
            System.out.println(file.getName());
        }

        System.out.println("\nSort files by size:");
        List<FileData> sortedFiles = navigator.sortBySize();
        for (FileData file : sortedFiles) {
            System.out.println(file.getName() + " - Size: " + file.getSize() + " bytes");
        }
    }
}
