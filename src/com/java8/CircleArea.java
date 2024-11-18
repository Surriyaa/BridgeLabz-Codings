package com.java8;
import java.util.function.Function;

public class CircleArea {
    public static void main(String[] args) {
        // Define a Function that calculates the area of a circle
        Function<Double, Double> calculateArea = radius -> Math.PI * radius * radius;

        // Input radius
        double radius = 5.0;

        // Calculate and print the area
        double area = calculateArea.apply(radius);
        System.out.println("The area of the circle with radius " + radius + " is: " + area);
    }
}

