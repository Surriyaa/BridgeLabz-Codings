package com.java8problems;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class CustomerTransaction {
    private String customerId;
    private LocalDate transactionDate;
    private double transactionAmount;

    public CustomerTransaction(String customerId, LocalDate transactionDate, double transactionAmount) {
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
}

class CustomerLifetimeValue {
    private String customerId;
    private double totalAmount;
    private double averageAmount;

    public CustomerLifetimeValue(String customerId, double totalAmount, double averageAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getAverageAmount() {
        return averageAmount;
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %s, Total Amount: %.2f, Average Amount: %.2f", 
                customerId, totalAmount, averageAmount);
    }
}

public class CustomerLifetimeValueCalculation {

    public static void main(String[] args) {
        List<CustomerTransaction> transactions = Arrays.asList(
                new CustomerTransaction("C001", LocalDate.now().minusMonths(1), 200),
                new CustomerTransaction("C001", LocalDate.now().minusMonths(2), 300),
                new CustomerTransaction("C002", LocalDate.now().minusMonths(4), 500),
                new CustomerTransaction("C002", LocalDate.now().minusMonths(5), 700),
                new CustomerTransaction("C003", LocalDate.now().minusMonths(10), 1000),
                new CustomerTransaction("C003", LocalDate.now().minusMonths(11), 1500)
        );

        LocalDate twelveMonthsAgo = LocalDate.now().minusMonths(12);

        // Step 1: Filter transactions within the last 12 months
        List<CustomerTransaction> recentTransactions = transactions.stream()
               .filter(tran -> tran.getTransactionDate()
            		   .isAfter(twelveMonthsAgo)).toList();    		   

        // Step 2: Aggregate to calculate total and average transaction amount for each customer
        

        
        Map<String, CustomerLifetimeValue> customerSummary=recentTransactions.stream()
        		.collect(Collectors.groupingBy(
        				CustomerTransaction::getCustomerId,
        				Collectors.collectingAndThen(
        						Collectors.toList(), 
        						list-> {
        							double totalAmount = list.stream().mapToDouble(CustomerTransaction::getTransactionAmount).sum();
                                    double averageAmount = list.stream().mapToDouble(CustomerTransaction::getTransactionAmount).average().orElse(0);
                                    return new CustomerLifetimeValue(list.get(0).getCustomerId(), totalAmount, averageAmount);        						}
        						)
        				));
        
        
        

        // Step 3: Sort customers by total transaction amount in descending order
        List<CustomerLifetimeValue> sortedCustomers = customerSummary.values().stream()
                .sorted((c1, c2) -> Double.compare(c2.getTotalAmount(), c1.getTotalAmount()))
                .collect(Collectors.toList());

        // Step 4: Retrieve top 10 customers by total transaction amount
        List<CustomerLifetimeValue> top10Customers = sortedCustomers.stream()
                .limit(10)
                .collect(Collectors.toList());

        // Print the top 10 customers
        System.out.println("Top 10 Customers by Total Transaction Amount:");
        top10Customers.forEach(System.out::println);
    }
}

