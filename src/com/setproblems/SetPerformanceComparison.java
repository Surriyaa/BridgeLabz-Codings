package com.setproblems;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

public class SetPerformanceComparison {

    public static void main(String[] args) {
        int elements = 1_000_000;
        
        comparePerformance(new HashSet<>(), "HashSet", elements);
        comparePerformance(new LinkedHashSet<>(), "LinkedHashSet", elements);
        comparePerformance(new TreeSet<>(), "TreeSet", elements);
    }

    private static void comparePerformance(Set<Integer> set, String setType, int elements) {
        long startTime, endTime;

        // Measure add performance
        startTime = System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            set.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println(setType + " Add: " + (endTime - startTime) + " ms");

        // Measure contains performance
        startTime = System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            set.contains(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println(setType + " Contains: " + (endTime - startTime) + " ms");

        // Measure remove performance
        startTime = System.currentTimeMillis();
        for (int i = 0; i < elements; i++) {
            set.remove(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println(setType + " Remove: " + (endTime - startTime) + " ms");

        System.out.println();
    }
}
