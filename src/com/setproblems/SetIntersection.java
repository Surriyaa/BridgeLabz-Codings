package com.setproblems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetIntersection {

    public static Set<Integer> findIntersection(List<Set<Integer>> sets) {
        if (sets == null || sets.isEmpty()) return new HashSet<>();

        Set<Integer> intersection = new HashSet<>(sets.get(0));

        for (Set<Integer> set : sets) {
            intersection.retainAll(set);
        }

        return intersection;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(2, 3, 4);
        Set<Integer> set3 = Set.of(3, 4, 5);

        List<Set<Integer>> sets = List.of(set1, set2, set3);

        System.out.println("Intersection: " + findIntersection(sets));
    }
}
