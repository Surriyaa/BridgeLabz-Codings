package com.java8;
	
import java.util.*;
	
import java.util.stream.Collectors;
	
	class InsurancePolicy {
	    private String policyNumber;
	    private String holderName;
	    private double premiumAmount;
	
	    // Constructor InsurancePolicy
	    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
	        this.policyNumber = policyNumber;
	        this.holderName = holderName;
	        this.premiumAmount = premiumAmount;
	    }
	
	    // Getters
	    public String getPolicyNumber() {
	        return policyNumber;
	    }
	
	    public String getHolderName() {
	        return holderName;
	    }
	
	    public double getPremiumAmount() {
	        return premiumAmount;
	    }
	
	    // Override toString for easy printing
	    @Override
	    public String toString() {
	        return String.format("Policy Number: %s, Holder Name: %s, Premium Amount: %.2f",
	                policyNumber, holderName, premiumAmount);
	    }
	}
	
	public class InsuranceApplication {
	
	    public static void main(String[] args) {
	        List<InsurancePolicy> policies = Arrays.asList(
	                new InsurancePolicy("P001", "Alice Smith", 1300),
	                new InsurancePolicy("P002", "Bob Brown", 1500),
	                new InsurancePolicy("P003", "Charles Johnson", 950),
	                new InsurancePolicy("P004", "Diana Evans", 2100),
	                new InsurancePolicy("P005", "Eve White", 1200)
	        );
	
	        // 1. Filter Policies by Premium Amount > $1200
	        List<InsurancePolicy> premiumAbove1200 = policies.stream()
	                .filter(policy -> policy.getPremiumAmount() > 1200)
	                .collect(Collectors.toList());
	        System.out.println("Policies with premium > 1200:");
	        premiumAbove1200.forEach(System.out::println);
	
	        // 2. Sort Policies by Holder Name
	        List<InsurancePolicy> sortedByName = policies.stream()
	                .sorted(Comparator.comparing(InsurancePolicy::getHolderName))
	                .collect(Collectors.toList());
	        System.out.println("\nPolicies sorted by holder name:");
	        sortedByName.forEach(System.out::println);
	
	        // 3. Compute Total Premium
	        double totalPremium = policies.stream()
	                .mapToDouble(InsurancePolicy::getPremiumAmount)
	                .sum();
	        System.out.println("\nTotal premium amount: " + totalPremium);
	
	        // 4. Print Policy Details
	        System.out.println("\nAll policy details:");
	        policies.forEach(System.out::println);
	
	        // 5. Filter Policies by Premium Range ($1000 - $2000)
	        List<InsurancePolicy> premiumRange1000To2000 = policies.stream()
	                .filter(policy -> policy.getPremiumAmount() >= 1000 && policy.getPremiumAmount() <= 2000)
	                .collect(Collectors.toList());
	        System.out.println("\nPolicies with premium between $1000 and $2000:");
	        premiumRange1000To2000.forEach(System.out::println);
	
	        // 6. Find Policy with Highest Premium
	        Optional<InsurancePolicy> highestPremiumPolicy = policies.stream()
	                .max(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount));
	        highestPremiumPolicy.ifPresent(policy -> System.out.println("\nPolicy with the highest premium: " + policy));
	
	        // 7. Group Policies by Holder Name Initial
	        Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream()
	                .collect(Collectors.groupingBy(policy -> policy.getHolderName().charAt(0)));
	        System.out.println("\nPolicies grouped by holder name initial:");
	        groupedByInitial.forEach((initial, group) -> {
	            System.out.println(initial + ": " + group);
	        });
	
	        // 8. Compute Average Premium
	        double averagePremium = policies.stream()
	                .mapToDouble(InsurancePolicy::getPremiumAmount)
	                .average().orElse(0);
	        System.out.println("\nAverage premium amount: " + averagePremium);
	
	        // 9. Sort Policies by Premium and Print
	        List<InsurancePolicy> sortedByPremium = policies.stream()
	                .sorted(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
	                .collect(Collectors.toList());
	        System.out.println("\nPolicies sorted by premium amount:");
	        sortedByPremium.forEach(System.out::println);
	
	        // 10. Check If Any Policy Exceeds $2000
	        boolean anyPolicyAbove2000 = policies.stream()
	                .anyMatch(policy -> policy.getPremiumAmount() > 2000);
	        System.out.println("\nIs there any policy with premium > 2000? " + anyPolicyAbove2000);
	
	        // 11. Count Policies for Each Premium Range
	        long countUnder1000 = policies.stream().filter(policy -> policy.getPremiumAmount() <= 1000).count();
	        long count1001To2000 = policies.stream().filter(policy -> policy.getPremiumAmount() > 1000 && policy.getPremiumAmount() <= 2000).count();
	        long countAbove2000 = policies.stream().filter(policy -> policy.getPremiumAmount() > 2000).count();
	        System.out.println("\nPolicy count by premium range:");
	        System.out.println("Under $1000: " + countUnder1000);
	        System.out.println("$1001 - $2000: " + count1001To2000);
	        System.out.println("Above $2000: " + countAbove2000);
	
	        // 12. Extract Unique Holder Names
	        Set<String> uniqueHolderNames = policies.stream()
	                .map(InsurancePolicy::getHolderName)
	                .collect(Collectors.toSet());
	        System.out.println("\nUnique holder names: " + uniqueHolderNames);
	
	        // 13. Find Policies by Holder Name Substring (e.g., "Smith")
	        String substring = "Smith";
	        List<InsurancePolicy> policiesWithSubstring = policies.stream()
	                .filter(policy -> policy.getHolderName().contains(substring))
	                .collect(Collectors.toList());
	        System.out.println("\nPolicies where holder name contains '" + substring + "':");
	        policiesWithSubstring.forEach(System.out::println);
	
	        // 14. Create a Map of Policy Numbers to Premium Amounts
	        Map<String, Double> policyNumberToPremiumMap = policies.stream()
	                .collect(Collectors.toMap(InsurancePolicy::getPolicyNumber, InsurancePolicy::getPremiumAmount));
	        System.out.println("\nMap of policy numbers to premium amounts: " + policyNumberToPremiumMap);
	
	        // 15. Find Most Frequent Words in Text Corpus
	        String text = "apple banana apple orange banana apple";
	        List<String> mostFrequentWords = findMostFrequentWords(text, 2);
	        System.out.println("\nTop N most frequent words: " + mostFrequentWords);
	
	        // 16. Find the Second Most Repeated Word
	        String secondMostRepeatedWord = findSecondMostFrequentWord(text);
	        System.out.println("\nSecond most repeated word: " + secondMostRepeatedWord);
	    }
	
	    // Method to find most frequent words
	    public static List<String> findMostFrequentWords(String text, int topN) {
	        return Arrays.stream(text.toLowerCase().split("\\W+"))
	                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
	                .entrySet().stream()
	                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
	                .limit(topN)
	                .map(Map.Entry::getKey)
	                .collect(Collectors.toList());
	    }
	
	    // Method to find the second most frequent word
	    public static String findSecondMostFrequentWord(String text) {
	        List<Map.Entry<String, Long>> frequencyList = Arrays.stream(text.toLowerCase().split("\\W+"))
	                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
	                .entrySet().stream()
	                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
	                .collect(Collectors.toList());
	        
	        return frequencyList.size() > 1 ? frequencyList.get(1).getKey() : null;
	    }
	}
