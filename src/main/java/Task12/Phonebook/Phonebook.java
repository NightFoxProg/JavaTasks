package Task12.Phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Entry> entries;

    public Phonebook() {
        entries = new ArrayList<>();
    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    public Entry find(String name) {
        for (Entry entry : entries) {
            if (entry.getName().equals(name)) {
                return entry;
            }
        }
        return null;
    }

    public List<Entry> findAll(String name) {
        List<Entry> foundEntries = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getName().equals(name)) {
                foundEntries.add(entry);
            }
        }
        return foundEntries.isEmpty() ? null : foundEntries;
    }
}

class Entry {
    private String name;
    private String phone;

    public Entry(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add(new Entry("John Doe", "123456789"));
        phonebook.add(new Entry("Jane Smith", "987654321"));
        phonebook.add(new Entry("John Doe", "987654321"));

        String searchName = "John Doe";
        Entry foundEntry = phonebook.find(searchName);
        if (foundEntry != null) {
            System.out.println("Запис знайдено:");
            System.out.println("Ім'я: " + foundEntry.getName());
            System.out.println("Телефон: " + foundEntry.getPhone());
        } else {
            System.out.println("Запис не знайдено за ім'ям: " + searchName);
        }

        String searchNameAll = "John Doe";
        List<Entry> foundEntries = phonebook.findAll(searchNameAll);
        if (foundEntries != null) {
            System.out.println("Записи знайдено за ім'ям: " + searchNameAll);
            for (Entry entry : foundEntries) {
                System.out.println("Ім'я: " + entry.getName());
                System.out.println("Телефон: " + entry.getPhone());
            }
        } else {
            System.out.println("Записи не знайдено за ім'ям: " + searchNameAll);
        }
    }
}