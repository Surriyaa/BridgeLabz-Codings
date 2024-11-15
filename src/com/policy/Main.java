package com.policy;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create PolicyManager instance
        PolicyManager policyManager = new PolicyManager();

        // Create some sample policies
        Policy policy1 = new Policy("P001", "Health", 5000.0, 100000.0, new Date(2025-1900, 6, 15));  // Expiry Date: July 15, 2025
        Policy policy2 = new Policy("P002", "Life", 2000.0, 200000.0, new Date(2023-1900, 3, 25));  // Expiry Date: April 25, 2023
        Policy policy3 = new Policy("P003", "Car", 1500.0, 30000.0, new Date(2024-1900, 11, 5));   // Expiry Date: December 5, 2024

        // Add policies to PolicyManager
        policyManager.addPolicy(policy1);
        policyManager.addPolicy(policy2);
        policyManager.addPolicy(policy3);

        // Get policies by ID (HashMap)
        System.out.println("Testing: Get Policy by ID (HashMap)");
        Policy retrievedPolicy = policyManager.getPolicyById("P002");
        System.out.println("Retrieved Policy: " + retrievedPolicy);
        System.out.println();

        // Get policies sorted by expiry date (TreeMap)
        policyManager.getPoliciesByExpiryDate();
        System.out.println();

        // Get policies maintaining insertion order (LinkedHashMap)
        policyManager.getPoliciesByInsertionOrder();
        System.out.println();

        // Print all policies stored by ID (HashMap order)
        policyManager.printPoliciesById();
    }
}
