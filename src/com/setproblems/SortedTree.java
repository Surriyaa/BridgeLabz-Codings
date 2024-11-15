package com.setproblems;

import java.util.*;

public class SortedTree {

    public static TreeSet<Integer> getSortedUniqueElements(List<Integer> numbers) {
        return new TreeSet<>(numbers);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 2, 9, 1, 2, 9);
        System.out.println("TreeSet: " + getSortedUniqueElements(numbers));  // Output: [1, 2, 7, 9]
    }
}


/*Explanation
A TreeSet is created from the list, which removes duplicates and sorts the elements in ascending order.
*/