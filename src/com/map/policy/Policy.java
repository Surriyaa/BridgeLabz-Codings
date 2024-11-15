package com.map.policy;

import java.util.Date;

public class Policy {
	
	private String policyHolderName;
	private String policyNumber;
	private double premium;
	private double coverageAmount;
	private Date expiryDate;
	
	public Policy(String policyNumber,String policyHolderName,double premium,double coverageAmount,Date expiryDate) {
		this.policyHolderName=policyHolderName;
		this.policyNumber=policyNumber;
		this.premium=premium;
		this.coverageAmount=coverageAmount;
		this.expiryDate=expiryDate;
	}
	
	public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyHolderName; }
    public double getPremium() { return premium; }
    public double getCoverageAmount() { return coverageAmount; }
    public Date getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyHolderName + '\'' +
                ", premium=" + premium +
                ", coverageAmount=" + coverageAmount +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
