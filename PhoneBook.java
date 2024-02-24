// Задание:

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут
//  повторяющиеся имена с разными телефонами, их необходимо считать, 
//  как одного человека с разными телефонами. 
//  Вывод должен быть отсортирован по убыванию числа телефонов.


import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        
        addContact(phoneBook, "Терещенков", "+358 445699873");
        addContact(phoneBook, "Петров", "+358 453398181");
        addContact(phoneBook, "Терещенков", "+358 444965723");
        addContact(phoneBook, "Терещенков", "+358 996216574");
        addContact(phoneBook, "Соколов", "+358 699952746");
        addContact(phoneBook, "Попов", "+358 445988824");
        addContact(phoneBook, "Соколов", "+358 547771164");
        addContact(phoneBook, "Сидоров", "+358 542266687");
        addContact(phoneBook, "Попов", "+358 436884267");
        printAndSortBook(phoneBook);
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String lastName, String phone) {
        List<String> phones = phoneBook.getOrDefault(lastName, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(lastName, phones);
    }
    
    public static void printAndSortBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        for (Map.Entry<String, List<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}        


