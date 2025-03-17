package Task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private static Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phoneNumber);
    }

    public void get(String lastName) {
        List<String> phones = phoneBook.get(lastName);
        if (phones == null || phones.isEmpty()) {
            System.out.println("NO phone number in Phone Book for '" + lastName + "'");
            return;
        }
        System.out.println("Phone numbers for '" + lastName + "': " + phones);
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("AAAAA", "11111111");
        phoneBook.add("CCCCC", "44444444");
        phoneBook.add("BBBBB", "22222222");
        phoneBook.add("AAAAA", "33333333");
        phoneBook.get("AAAAA");
        phoneBook.get("BBBBB");
        phoneBook.get("DDDDD");
    }
}
