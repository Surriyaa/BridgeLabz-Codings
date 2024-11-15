package com.insurance;
import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    // Add policy to each type of set
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hashSetPolicies);
    }

    // Retrieve policies expiring within the next 30 days
    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new TreeSet<>();
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);

        for (Policy policy : treeSetPolicies) {
            if (policy.getExpiryDate().isBefore(thresholdDate)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    // Retrieve policies with a specific coverage type
    public Set<Policy> getPoliciesByCoverage(String coverageType) {
        Set<Policy> coveragePolicies = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                coveragePolicies.add(policy);
            }
        }
        return coveragePolicies;
    }

    // Find duplicate policies based on policy number
    public Set<Policy> findDuplicatePolicies() {
        Set<String> seenPolicyNumbers = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();
        
        for (Policy policy : linkedHashSetPolicies) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    // Compare performance of HashSet, LinkedHashSet, and TreeSet
    public void comparePerformance(List<Policy> policies) {
        System.out.println("Performance Comparison:");
        measurePerformance(new HashSet<>(), policies, "HashSet");
        measurePerformance(new LinkedHashSet<>(), policies, "LinkedHashSet");
        measurePerformance(new TreeSet<>(), policies, "TreeSet");
    }

    private void measurePerformance(Set<Policy> set, List<Policy> policies, String setType) {
        long startTime = System.currentTimeMillis();
        
        for (Policy policy : policies) {
            set.add(policy);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(setType + " Add: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (Policy policy : policies) {
            set.contains(policy);
        }
        endTime = System.currentTimeMillis();
        System.out.println(setType + " Contains: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (Policy policy : policies) {
            set.remove(policy);
        }
        endTime = System.currentTimeMillis();
        System.out.println(setType + " Remove: " + (endTime - startTime) + " ms");

        System.out.println();
    }
}
