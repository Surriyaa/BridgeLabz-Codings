package com.insurance;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Sample policies
        Policy policy1 = new Policy("P001", "John Doe", LocalDate.now().plusDays(10), "Health", 500.0);
        Policy policy2 = new Policy("P002", "Jane Doe", LocalDate.now().plusDays(20), "Auto", 300.0);
        Policy policy3 = new Policy("P003", "Alice Smith", LocalDate.now().plusDays(40), "Home", 700.0);
        Policy policy4 = new Policy("P001", "John Doe", LocalDate.now().plusDays(10), "Health", 500.0); // Duplicate policy

        // Add policies
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);
        manager.addPolicy(policy4);

        // Retrieve all unique policies
        System.out.println("All Unique Policies:");
        manager.getAllUniquePolicies().forEach(System.out::println);

        // Retrieve policies expiring soon
        System.out.println("\nPolicies Expiring Soon:");
        manager.getPoliciesExpiringSoon().forEach(System.out::println);

        // Retrieve policies by coverage type
        System.out.println("\nPolicies with Health Coverage:");
        manager.getPoliciesByCoverage("Health").forEach(System.out::println);

        // Find duplicate policies
        System.out.println("\nDuplicate Policies:");
        manager.findDuplicatePolicies().forEach(System.out::println);

        // Performance comparison
        List<Policy> policies = List.of(policy1, policy2, policy3, policy4);
        manager.comparePerformance(policies);
    }
}
