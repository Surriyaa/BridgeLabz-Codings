package com.setproblems;
import java.util.Set;
import java.util.TreeSet;

public class RemoveElementsByCondition {

    public static TreeSet<Integer> filterByThreshold(TreeSet<Integer> set, int threshold) {
        set.removeIf(num -> num < threshold);
        return set;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(Set.of(1, 2, 3, 4, 5));
        int threshold = 3;

        System.out.println("Filtered Set: " + filterByThreshold(set, threshold));
    }
}
