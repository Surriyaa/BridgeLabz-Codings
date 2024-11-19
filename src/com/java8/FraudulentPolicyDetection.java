package com.java8;
//this is a com.java8coding package class
import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

	class Policy {
	    private String policyId;
	    private String policyHolderId;
	    private double premiumAmount;
	
	    // Constructor
	    public Policy(String policyId, String policyHolderId, double premiumAmount) {
	        this.policyId = policyId;
	        this.policyHolderId = policyHolderId;
	        this.premiumAmount = premiumAmount;
	    }
	
	    public String getPolicyId() {
	        return policyId;
	    }
	
	    public String getPolicyHolderId() {
	        return policyHolderId;
	    }
	
	    public double getPremiumAmount() {
	        return premiumAmount;
	    }
	}
	
	class Transaction {
	    private String transactionId;
	    private String policyId;
	    private double amount;
	    private LocalDate transactionDate;
	
	    // Constructor
	    public Transaction(String transactionId, String policyId, double amount, LocalDate transactionDate) {
	        this.transactionId = transactionId;
	        this.policyId = policyId;
	        this.amount = amount;
	        this.transactionDate = transactionDate;
	    }
	
	    public String getPolicyId() {
	        return policyId;
	    }
	
	    public double getAmount() {
	        return amount;
	    }
	
	    public LocalDate getTransactionDate() {
	        return transactionDate;
	    }
	}
	
	public class FraudulentPolicyDetection {
	
	    public static void main(String[] args) {
	        // Sample Policies
	        List<Policy> policies = Arrays.asList(
	                new Policy("P1", "H1", 10000),
	                new Policy("P2", "H2", 20000),
	                new Policy("P3", "H3", 15000)
	        );
	
	        // Sample Transactions
	        List<Transaction> transactions = Arrays.asList(
	                new Transaction("T1", "P1", 12000, LocalDate.now().minusMonths(3)),
	                new Transaction("T2", "P1", 15000, LocalDate.now().minusMonths(2)),
	                new Transaction("T3", "P1", 17000, LocalDate.now().minusMonths(1)),
	                new Transaction("T4", "P1", 5000, LocalDate.now().minusMonths(6)),
	                new Transaction("T5", "P2", 20000, LocalDate.now().minusMonths(4)),
	                new Transaction("T6", "P2", 25000, LocalDate.now().minusMonths(5))
	        );
	
	        // Step 1: Filter: Identify policies with more than 3 transactions exceeding $10,000 in the last 6 months.
	        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
	
	        Map<String, List<Transaction>> transactionsByPolicy = transactions.stream()
	                .filter(t -> t.getAmount() > 10000 && t.getTransactionDate().isAfter(sixMonthsAgo))
	                .collect(Collectors.groupingBy(Transaction::getPolicyId));
	
	        // Step 2: Group policies by policyHolderId
	        Map<String, List<Policy>> policiesByHolderId = policies.stream()
	                .collect(Collectors.groupingBy(Policy::getPolicyHolderId));
	
	        // Step 3: Aggregate: Calculate the total fraud amount for each policy
	        Map<String, Double> totalFraudAmountByPolicy = new HashMap<>();
	
	        for (Map.Entry<String, List<Transaction>> entry : transactionsByPolicy.entrySet()) {
	            String policyId = entry.getKey();
	            List<Transaction> policyTransactions = entry.getValue();
	
	            // Only consider policies with more than 3 transactions exceeding $10,000
	            if (policyTransactions.size() > 3) {
	                // Find the associated policy
	                Optional<Policy> policyOpt = policies.stream()
	                        .filter(p -> p.getPolicyId().equals(policyId))
	                        .findFirst();
	
	                if (policyOpt.isPresent()) {
	                    Policy policy = policyOpt.get();
	                    double totalAmount = policyTransactions.stream().mapToDouble(Transaction::getAmount).sum();
	
	                    // Step 4: Alert: Flag policies with total fraud amount > $50,000
	                    if (totalAmount > 50000) {
	                        totalFraudAmountByPolicy.put(policyId, totalAmount);
	                    }
	                }
	            }
	        }
	
	        // Step 5: Output flagged policies
	        System.out.println("Flagged Policies with Total Fraud Amount > $50,000:");
	        totalFraudAmountByPolicy.forEach((policyId, totalAmount) ->
	                System.out.println("Policy ID: " + policyId + " | Total Fraud Amount: " + totalAmount));
	    }
	}
