package homework3;

import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {
    private TreeMap<String, TreeSet<String>> book = new TreeMap<>();

    public void add(String surname, String phoneNumber){
        book.putIfAbsent(surname, new TreeSet<>());
        book.get(surname).add(phoneNumber);
    }

    public void get(String surname) {
        System.out.println(book.get(surname));
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        String s1 = "Popov";
        String s2 = "Leonov";
        pb.add(s1, "+7-999-797-45-22");
        pb.get(s1);
        pb.add(s2, "88005553535");
        pb.add(s2, "88005553535");
        pb.add(s2, "8 499 800 40 20");
        pb.get(s2);
    }
}
