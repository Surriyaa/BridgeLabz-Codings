package com.java8;
import java.util.function.BiFunction;

public class StringConcatenation {
    public static void main(String[] args) {
        // Define a BiFunction that concatenates two strings with a space
        BiFunction<String, String, String> concatenateWithSpace = (str1, str2) -> str1 + " " + str2;

        // Input strings
        String string1 = "Hello";
        String string2 = "World";

        // Concatenate and print the result
        String result = concatenateWithSpace.apply(string1, string2);
        System.out.println("Concatenated string: " + result);
    }
}
