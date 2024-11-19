package com.java8problems;
import java.util.*;
import java.util.stream.Collectors;

class Claim {
    private String claimId;
    private String policyNumber;
    private double claimAmount;
    private Date claimDate;
    private String status;

    public Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getClaimId() {
        return claimId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Claim ID: %s, Policy Number: %s, Claim Amount: %.2f, Status: %s", 
                              claimId, policyNumber, claimAmount, status);
    }
}

public class ClaimsAnalysis {

    public static void main(String[] args) {
        // Sample claim data
        List<Claim> claims = Arrays.asList(
            new Claim("C001", "P123", 7000, new Date(), "Approved"),
            new Claim("C002", "P123", 3000, new Date(), "Denied"),
            new Claim("C003", "P456", 12000, new Date(), "Approved"),
            new Claim("C004", "P456", 8000, new Date(), "Approved"),
            new Claim("C005", "P789", 5500, new Date(), "Approved"),
            new Claim("C006", "P789", 2000, new Date(), "Pending")
        );

        // 1. Filter: Select claims that are in the "Approved" status and have a claimAmount > $5,000
        List<Claim> approvedHighValueClaims = claims.stream()
                .filter(claim -> "Approved".equalsIgnoreCase(claim.getStatus()))
                .filter(claim -> claim.getClaimAmount() > 5000)
                .toList();

        System.out.println("Approved claims with claim amount > $5,000:");
        approvedHighValueClaims.forEach(System.out::println);

        // 2. Group: Group these claims by policyNumber
        Map<String, List<Claim>> claimsGroupedByPolicy = approvedHighValueClaims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        System.out.println("\nClaims grouped by policy number:");
        claimsGroupedByPolicy.forEach((policyNumber, claimList) -> {
            System.out.println("Policy Number: " + policyNumber);
            claimList.forEach(System.out::println);
        });

        // 3. Aggregate: For each policy, calculate the total and average claimAmount
        Map<String, Double> totalClaimAmountByPolicy = claimsGroupedByPolicy.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Claim::getClaimAmount).sum()
                ));

        Map<String, Double> averageClaimAmountByPolicy = claimsGroupedByPolicy.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Claim::getClaimAmount).average().orElse(0)
                ));

        System.out.println("\nTotal and average claim amounts by policy:");
        totalClaimAmountByPolicy.forEach((policyNumber, totalAmount) -> {
            System.out.printf("Policy Number: %s, Total Claim Amount: %.2f, Average Claim Amount: %.2f%n",
                    policyNumber, totalAmount, averageClaimAmountByPolicy.get(policyNumber));
        });

        // 4. Top N: Identify the top 3 policies with the highest total claim amounts
        List<Map.Entry<String, Double>> top3PoliciesByTotalClaimAmount = totalClaimAmountByPolicy.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .toList();

        System.out.println("\nTop 3 policies with highest total claim amounts:");
        top3PoliciesByTotalClaimAmount.forEach(entry -> 
                System.out.printf("Policy Number: %s, Total Claim Amount: %.2f%n", entry.getKey(), entry.getValue()));
    }
}
