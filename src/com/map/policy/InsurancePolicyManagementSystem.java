package com.map.policy;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsurancePolicyManagementSystem {

	public static void main(String[] args) throws ParseException {
		PolicyManager policyManager = new PolicyManager();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Policy policy1 = new Policy("P1001", "Alice", 500.0, 10000.0, sdf.parse("2024-12-01"));
        Policy policy2 = new Policy("P1002", "Bob", 600.0, 15000.0, sdf.parse("2024-11-20"));
        Policy policy3 = new Policy("P1003", "Alice", 700.0, 20000.0, sdf.parse("2024-11-25"));
        Policy policy4 = new Policy("P1004", "Charlie", 800.0, 25000.0, sdf.parse("2025-01-10"));

        policyManager.addPolicy(policy1);
        policyManager.addPolicy(policy2);
        policyManager.addPolicy(policy3);
        policyManager.addPolicy(policy4);
        
        System.out.println("\nRetrieve Policy by Number:");
        System.out.println(policyManager.getPolicyByNumber("P1002"));
    
       System.out.println("Listing policies by name");
       for (Policy policy : policyManager.listPoliciesByPolicyholder("Alice")) {
           System.out.println(policy);
       }
       
       
        System.out.println("\nPolicies Expiring Within 30 Days:");
        for(Policy policy:policyManager.listExpiredPoliciesByDate(30)){
    	   System.out.println(policy);
       }
       
       policyManager.removeExpiredPolicies();
       policyManager.displayAllPolicies();
       
	}

}
