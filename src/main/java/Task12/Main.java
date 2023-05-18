package Task12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("grape");

        String searchString = "apple";
        int occurrenceCount = countOccurrence(stringList, searchString);
        System.out.println("Occurrence count of \"" + searchString + "\": " + occurrenceCount);

        int[] intArray = {1, 2, 3};
        List<Integer> integerList = toList(intArray);
        System.out.println(integerList);

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(2);
        numberList.add(3);
        numberList.add(3);
        numberList.add(4);

        List<Integer> uniqueNumbers = findUnique(numberList);
        System.out.println(uniqueNumbers);

        List<String> wordList = new ArrayList<>();
        wordList.add("bird");
        wordList.add("bird");
        wordList.add("fox");
        wordList.add("cat");
        wordList.add("bird");
        wordList.add("cat");

        calcOccurrence(wordList);

        List<String> wordList2 = new ArrayList<>();
        wordList2.add("bird");
        wordList2.add("bird");
        wordList2.add("fox");
        wordList2.add("cat");
        wordList2.add("bird");
        wordList2.add("cat");

        List<Occurrence> occurrences = findOccurrence(wordList2);
        for (Occurrence occurrence : occurrences) {
            System.out.println("name: " + occurrence.getName() + ", occurrence: " + occurrence.getOccurrence());
        }
    }

    public static int countOccurrence(List<String> stringList, String searchString) {
        int count = 0;
        for (String str : stringList) {
            if (str.equals(searchString)) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> toList(int[] intArray) {
        List<Integer> integerList = new ArrayList<>();
        for (int num : intArray) {
            integerList.add(num);
        }
        return integerList;
    }

    public static List<Integer> findUnique(List<Integer> numberList) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (int num : numberList) {
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
            }
        }
        return uniqueNumbers;
    }

    public static void calcOccurrence(List<String> wordList) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : wordList) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<Occurrence> findOccurrence(List<String> wordList) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : wordList) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }

        List<Occurrence> occurrences = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            Occurrence occurrence = new Occurrence(word, count);
            occurrences.add(occurrence);
        }

        return occurrences;
    }
}

class Occurrence {
    private String name;
    private int occurrence;

    public Occurrence(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public String getName() {
        return name;
    }

    public int getOccurrence() {
        return occurrence;
    }
}