package com.policy;

import java.util.*;

public class PolicyManager {
    // Map to store policies by policy ID (HashMap)
    private Map<String, Policy> policyById = new HashMap<>();
    // Map to store policies sorted by expiry date (TreeMap)
    private Map<String, Policy> policyByExpiryDate = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String policyId1, String policyId2) {
            Policy policy1 = policyById.get(policyId1);
            Policy policy2 = policyById.get(policyId2);
            return policy1.getExpiryDate().compareTo(policy2.getExpiryDate());
        }
    });
    // Map to store policies maintaining insertion order (LinkedHashMap)
    private Map<String, Policy> policyByInsertionOrder = new LinkedHashMap<>();

    // Add policy
    public void addPolicy(Policy policy) {
        policyById.put(policy.getPolicyId(), policy);
        policyByExpiryDate.put(policy.getPolicyId(), policy);
        policyByInsertionOrder.put(policy.getPolicyId(), policy);
    }

    // Get policy by ID
    public Policy getPolicyById(String policyId) {
        return policyById.get(policyId);
    }

    // Get all policies sorted by expiry date
    public void getPoliciesByExpiryDate() {
        System.out.println("Policies sorted by Expiry Date:");
        for (Policy policy : policyByExpiryDate.values()) {
            System.out.println(policy);
        }
    }

    // Get all policies maintaining insertion order
    public void getPoliciesByInsertionOrder() {
        System.out.println("Policies in Insertion Order:");
        for (Policy policy : policyByInsertionOrder.values()) {
            System.out.println(policy);
        }
    }

    // Print all policies by ID (HashMap order)
    public void printPoliciesById() {
        System.out.println("Policies stored by Policy ID:");
        for (Policy policy : policyById.values()) {
            System.out.println(policy);
        }
    }
}
