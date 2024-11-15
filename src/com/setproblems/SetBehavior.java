package com.setproblems;

import java.util.*;

public class SetBehavior {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 5, 1, 2);

        // Create a HashSet from the list to print every time rendom order
        Set<Integer> hashSet = new HashSet<>(numbers);
        System.out.println("HashSet: " + hashSet);

        // Create a LinkedHashSet from the list
        Set<Integer> linkedHashSet = new LinkedHashSet<>(numbers);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Create a TreeSet from the list set is sorted
        Set<Integer> treeSet = new TreeSet<>(numbers);
        System.out.println("TreeSet: " + treeSet);
    }
}
