package com.java8problems;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction{
		private String transactionId;
		private String policyNumber;
		private double amount;
		private Date transactionDate;
		private boolean isFraudulent;
		public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate,
				boolean isFraudulent) {
			this.transactionId = transactionId;
			this.policyNumber = policyNumber;
			this.amount = amount;
			this.transactionDate = transactionDate;
			this.isFraudulent = isFraudulent;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public String getPolicyNumber() {
			return policyNumber;
		}
		public double getAmount() {
			return amount;
		}
		public Date getTransactionDate() {
			return transactionDate;
		}
		public boolean isFraudulent() {
			return isFraudulent;
		}
		@Override
		public String toString() {
			return String.format("Transaction ID: %s, Policy Number: %s, Amount: %.2f, Date: %s, Fraudulent: %b",
                    transactionId, policyNumber, amount, transactionDate, isFraudulent);
		}
	}
	
	public class FraudDetection {
	
		public static void main(String[] args) {
			
			List<Transaction> transaction=Arrays.asList(new Transaction("T001", "P001", 12000, new Date(), true),
		            new Transaction("T002", "P002", 15000, new Date(), false),
		            new Transaction("T003", "P001", 20000, new Date(), true),
		            new Transaction("T004", "P003", 11000, new Date(), true),
		            new Transaction("T005", "P001", 30000, new Date(), true),
		            new Transaction("T006", "P001", 25000, new Date(), true),
		            new Transaction("T007", "P003", 18000, new Date(), true),
		            new Transaction("T008", "P003", 8000, new Date(), true),
		            new Transaction("T009", "P001", 6000, new Date(), true),
		            new Transaction("T010", "P003", 55000, new Date(), true));
			
			// 1. Filter: Select fraudulent transactions with amount > $10,000
			List<Transaction> filterExceed10k=transaction.stream()
					.filter(b->b.isFraudulent()==true)
					.filter(amt->amt.getAmount()>10000)
					.toList();
			
			System.out.println("isFraudulent is true and where the\n amount exceeds $10,000");
			System.out.println(filterExceed10k);
			
			// 2. Group: Group these transactions by policyNumber
			System.out.println(" Group these transactions by policyNumber\n");
			
			Map<String, List<Transaction>> groupByPNo=filterExceed10k.stream()
					.collect(Collectors.groupingBy(Transaction::getPolicyNumber));
			
			groupByPNo.forEach((polnum,data)->{
			System.out.println("Policy Number: "+polnum);
			data.forEach(System.out::println );
			
			});
			// 3. Aggregate: Calculate total number and total amount of fraudulent transactions per policy
	        Map<String, Map<String, Object>> aggregatedData = groupByPNo.entrySet().stream()
	                .collect(Collectors.toMap(
	                        Map.Entry::getKey,
	                        entry -> {
	                            Map<String, Object> stats = new HashMap<>();
	                            List<Transaction> transList = entry.getValue();

	                            // Count of fraudulent transactions
	                            long fraudCount = transList.size();

	                            // Total fraud amount
	                            double totalFraudAmount = transList.stream()
	                                    .mapToDouble(Transaction::getAmount)
	                                    .sum();

	                            stats.put("Fraud Count", fraudCount);
	                            stats.put("Total Fraud Amount", totalFraudAmount);
	                            return stats;
	                        }
	                ));

	        System.out.println("\nAggregated Data (Fraud Count and Total Fraud Amount per Policy):");
	        aggregatedData.forEach((policy, stats) -> 
	                System.out.println("Policy: " + policy + ", " + stats));

	        // 4. Alert: Generate alerts for policies with more than 5 fraudulent transactions or total fraud > $50,000
	        System.out.println("\nAlerts for High-Risk Policies:");
	        aggregatedData.forEach((policy, stats) -> {
	            long fraudCount = (long) stats.get("Fraud Count");
	            double totalFraudAmount = (double) stats.get("Total Fraud Amount");

	            if (fraudCount > 5 || totalFraudAmount > 50000) {
	                System.out.println("ALERT: Policy " + policy +
	                        " has " + fraudCount + " fraudulent transactions and a total fraud amount of $" + totalFraudAmount);
	            }
	        });
	    }
			

		}
	
	
