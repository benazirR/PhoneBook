import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PhoneBook {

    private Map<String, Set<String>> phoneMap;

    public PhoneBook() {
        phoneMap = new HashMap<>();
    }

    // Метод для добавления записи в телефонную книгу
    public void addEntry(String name, String phoneNumber) {
        phoneMap.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    // Метод для получения всех записей, отсортированных по количеству телефонов
    public List<Map.Entry<String, Set<String>>> getSortedEntries() {
        List<Map.Entry<String, Set<String>>> entryList = new ArrayList<>(phoneMap.entrySet());
        entryList.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        return entryList;
    }

    // Основной метод для демонстрации работы телефонной книги
    public static void main(String[] args) throws Exception {
        // Установка кодировки UTF-8 для вывода в консоль
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        PhoneBook phoneBook = new PhoneBook();

        // Пример добавления записей
        phoneBook.addEntry("Алиса", "+79261234567");
        phoneBook.addEntry("Алиса", "+79261234568");
        phoneBook.addEntry("Боб", "+79361234567");
        phoneBook.addEntry("Чарли", "+79461234567");
        phoneBook.addEntry("Боб", "+79361234568");
        phoneBook.addEntry("Алиса", "+79261234569");
        phoneBook.addEntry("Чарли", "+79461234568");

        // Получение и вывод всех записей
        List<Map.Entry<String, Set<String>>> sortedEntries = phoneBook.getSortedEntries();
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}