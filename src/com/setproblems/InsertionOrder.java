package com.setproblems;
import java.util.*;

public class InsertionOrder {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        LinkedHashSet<String> uniqueFruits = MaintainOrder(fruits);
        System.out.println("LinkedHashSet: " + uniqueFruits);
    }

    public static LinkedHashSet<String> MaintainOrder(List<String> list) {
        // Using LinkedHashSet to remove duplicates and maintain insertion order
        return new LinkedHashSet<>(list);
    }
}


