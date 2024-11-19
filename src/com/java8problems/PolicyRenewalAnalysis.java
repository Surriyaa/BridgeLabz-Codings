package com.java8problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class Policy {
    private String policyId;
    private String policyHolderId;
    private LocalDate expiryDate;
    private double premiumAmount;
    private String status;

    public Policy(String policyId, String policyHolderId, LocalDate expiryDate, double premiumAmount, String status) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
        this.status = status;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PolicyId: " + policyId + ", Status: " + status + ", ExpiryDate: " + expiryDate;
    }
}

class RenewalReminder {
    private String policyId;
    private String policyHolderId;
    private long remainingDaysUntilExpiry;

    public RenewalReminder(String policyId, String policyHolderId, long remainingDaysUntilExpiry) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.remainingDaysUntilExpiry = remainingDaysUntilExpiry;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public long getRemainingDaysUntilExpiry() {
        return remainingDaysUntilExpiry;
    }

    @Override
    public String toString() {
        return "PolicyId: " + policyId + ", HolderId: " + policyHolderId + ", DaysRemaining: " + remainingDaysUntilExpiry;
    }
}

public class PolicyRenewalAnalysis {
    public static void main(String[] args) {
        // Sample data
        List<Policy> policies = Arrays.asList(
            new Policy("P101", "H001", LocalDate.now().plusDays(15), 1200.00, "Active"),
            new Policy("P102", "H002", LocalDate.now().plusDays(35), 1500.00, "Expired"),
            new Policy("P103", "H001", LocalDate.now().plusDays(20), 1300.00, "Active"),
            new Policy("P104", "H003", LocalDate.now().plusDays(5), 1100.00, "Active"),
            new Policy("P105", "H002", LocalDate.now().plusDays(25), 1400.00, "Active")
        );

        // Step 1: Filter policies due for renewal within the next 30 days and are Active
        LocalDate today = LocalDate.now();
        List<RenewalReminder> reminders = policies.stream()
            .filter(p -> p.getStatus().equals("Active") && ChronoUnit.DAYS.between(today, p.getExpiryDate()) <= 30)
            .map(p -> new RenewalReminder(p.getPolicyId(), p.getPolicyHolderId(), ChronoUnit.DAYS.between(today, p.getExpiryDate())))
            .collect(Collectors.toList());

        // Step 2: Sort reminders by the remaining days until expiry in ascending order
        reminders.sort(Comparator.comparingLong(RenewalReminder::getRemainingDaysUntilExpiry));

        // Step 3: Group the reminders by policyHolderId
        Map<String, List<RenewalReminder>> groupedByHolder = reminders.stream()
            .collect(Collectors.groupingBy(RenewalReminder::getPolicyHolderId));

        // Output the results
        System.out.println("Renewal Reminders (Grouped by Policy Holder):");
        groupedByHolder.forEach((holderId, reminderList) -> {
            System.out.println("Holder ID: " + holderId);
            reminderList.forEach(System.out::println);
        });
    }
}
