package com.policy;

import java.util.Date;

public class Policy {
    private String policyId;
    private String policyType;
    private double premium;
    private double coverageAmount;
    private Date expiryDate;

    // Constructor
    public Policy(String policyId, String policyType, double premium, double coverageAmount, Date expiryDate) {
        this.policyId = policyId;
        this.policyType = policyType;
        this.premium = premium;
        this.coverageAmount = coverageAmount;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyID: " + policyId + ", Type: " + policyType + ", Premium: " + premium + 
               ", Coverage: " + coverageAmount + ", Expiry Date: " + expiryDate;
    }
}
