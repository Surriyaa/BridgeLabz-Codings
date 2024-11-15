package com.setproblems;

import java.util.*;

public class FirstNonDuplicate{

    public static Integer findFirstNonDuplicate(List<Integer> numbers) {
        Set<Integer> allElements = new HashSet<>();
        LinkedHashSet<Integer> nonDuplicates = new LinkedHashSet<>();

        for (Integer number : numbers) {
            if (allElements.contains(number)) {
                nonDuplicates.remove(number);
            } else {
                allElements.add(number);
                nonDuplicates.add(number);
            }
        }

        // Return the first element in the LinkedHashSet, or null if it's empty
        return nonDuplicates.isEmpty() ? null : nonDuplicates.iterator().next();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 6, 4, 7, 8, 5);
        System.out.println("First non-duplicate: " + findFirstNonDuplicate(numbers));  // Output: 6
    }
}
