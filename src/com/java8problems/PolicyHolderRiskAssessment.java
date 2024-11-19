package com.java8problems;
import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    private String holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return String.format("Holder ID: %s, Name: %s, Age: %d, Policy Type: %s, Premium Amount: %.2f", 
                             holderId, name, age, policyType, premiumAmount);
    }
}

class RiskAssessment {
    private String holderId;
    private String name;
    private double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public double getRiskScore() {
        return riskScore;
    }

    @Override
    public String toString() {
        return String.format("Holder ID: %s, Name: %s, Risk Score: %.2f", holderId, name, riskScore);
    }
}

public class PolicyHolderRiskAssessment {

    public static void main(String[] args) {
        // Sample policy holder data
        List<PolicyHolder> policyHolders = Arrays.asList(
            new PolicyHolder("H001", "Alice", 65, "Life", 10000),
            new PolicyHolder("H002", "Bob", 72, "Life", 15000),
            new PolicyHolder("H003", "Charlie", 68, "Health", 8000),
            new PolicyHolder("H004", "David", 75, "Life", 12000),
            new PolicyHolder("H005", "Eve", 59, "Life", 14000)
        );

        // 1. Filter: Select policyholders with a policyType of "Life" and age greater than 60
        List<PolicyHolder> lifePolicyHoldersOver60 = policyHolders.stream()
                .filter(holder -> "Life".equalsIgnoreCase(holder.getPolicyType()))
                .filter(holder -> holder.getAge() > 60)
                .toList();

        System.out.println("Policy holders with Life policy and age > 60:");
        lifePolicyHoldersOver60.forEach(System.out::println);

        // 2. Transform: Create a list of RiskAssessment objects with risk score = premiumAmount / age
        List<RiskAssessment> riskAssessments = lifePolicyHoldersOver60.stream()
                .map(holder -> new RiskAssessment(
                        holder.getHolderId(),
                        holder.getName(),
                        holder.getPremiumAmount() / holder.getAge()))
                .toList();

        System.out.println("\nRisk Assessments:");
        riskAssessments.forEach(System.out::println);

        // 3. Sort: Sort these risk assessments by risk score in descending order
        List<RiskAssessment> sortedRiskAssessments = riskAssessments.stream()
                .sorted((r1, r2) -> Double.compare(r2.getRiskScore(), r1.getRiskScore()))
                .toList();

        System.out.println("\nSorted Risk Assessments by Risk Score (Descending):");
        sortedRiskAssessments.forEach(System.out::println);

        // 4. Categorize: Group into "High Risk" and "Low Risk" based on risk score > 0.5
        Map<String, List<RiskAssessment>> categorizedRiskAssessments = sortedRiskAssessments.stream()
                .collect(Collectors.groupingBy(
                        assessment -> assessment.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"
                ));

        System.out.println("\nCategorized Risk Assessments:");
        categorizedRiskAssessments.forEach((category, assessments) -> {
            System.out.println("\n" + category + ":");
            assessments.forEach(System.out::println);
        });
    }
}
