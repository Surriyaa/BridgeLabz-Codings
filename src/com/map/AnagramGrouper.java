package com.map;

import java.util.*;

public class AnagramGrouper {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(words);

        // Print each group of anagrams
        System.out.println("Anagram Groups:");
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            // Sort the characters of the word to form the key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // Add the word to the corresponding list in the map
            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }

        // Return all anagram groups as a list of lists
        return new ArrayList<>(map.values());
    }
}
