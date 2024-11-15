package com.setproblems;
import java.util.*;

public class SubsetChecker {

    public static boolean isSubset(Set<Integer> setA, Set<Integer> setB) {
        return setB.containsAll(setA);
    }

    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> setB = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        
        System.out.println("Is setA a subset of setB? " + isSubset(setA, setB));  // Output: true
    }
}
//isSubset checks if setB contains all elements of setA using the containsAll method, which works for any Set type.
//If all elements of setA are in setB, it returns true, indicating that setA is a subset of setB.
