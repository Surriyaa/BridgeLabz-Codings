package com.java8;
import java.util.*;
import java.util.Optional;

public class OptionalMaxExample {
    public static void main(String[] args) {
        // Example list of integers
        List<Integer> numbers = Arrays.asList(10, 20, 5, 15, 30);

        // Find the maximum value using Optional
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        // Handle the case where the list is empty
        int maxValue = max.orElse(-1);  // Use -1 as a default value if the list is empty
        System.out.println("The maximum value is: " + maxValue);

        // Example with an empty list
        List<Integer> emptyList = new ArrayList<>();
        Optional<Integer> emptyMax = emptyList.stream().max(Integer::compareTo);

        // Handle the empty case with a message
        emptyMax.ifPresentOrElse(
            value -> System.out.println("The maximum value in empty list is: " + value),
            () -> System.out.println("The list is empty, no maximum value found.")
        );
    }
}
