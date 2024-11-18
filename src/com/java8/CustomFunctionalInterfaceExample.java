package com.java8;


@FunctionalInterface
interface SquareCalculator {
    // Abstract method to calculate square
    int calculateSquare(int number);

    // Default method to print the result
    default void printSquare(int number) {
        System.out.println("The square of " + number + " is: " + calculateSquare(number));
    }
}

public class CustomFunctionalInterfaceExample {
    public static void main(String[] args) {
        // Implement the calculateSquare method using a lambda expression
        SquareCalculator squareCalculator = number -> number * number;

        // Test the default method
        int num = 5;
        squareCalculator.printSquare(num);  // Calls the default method which calculates and prints the square
    }
}
