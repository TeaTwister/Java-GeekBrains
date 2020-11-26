package homework3;

import java.util.*;

public class Words {
    public static void main(String[] args) {
        String[] words = {
                "ab", "ac", "ab", "acc", "a", "aa", "aaa", "aa", "a", "aa"
        };
        Set<String> set = new TreeSet<>(Arrays.asList(words));
        System.out.println(set);

        TreeMap<String, Integer> hm = new TreeMap<>();
        for (String word : words) {
            hm.putIfAbsent(word, 0);
            hm.put(word, hm.get(word) + 1);
        }
        System.out.println(hm);
        System.out.println(Integer.MAX_VALUE);
    }
}
