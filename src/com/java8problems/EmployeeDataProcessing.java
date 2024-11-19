package com.java8problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDataProcessing {

	public static void main(String[] args) {
		List<Employee> employee=Arrays.asList(
				new Employee(51,"Surriyaa","Engineering",90000),
				new Employee(25,"Priya","Engineering",300000),
				new Employee(14,"Gobika","Arts",25000));
		
		List<Employee> filter=employee.stream().filter(empl -> empl.getDept().equalsIgnoreCase("Engineering"))
				.filter(emp ->emp.getSalary()>80000).toList();
		
		System.out.println(filter);
		
		List<Employee> sortedDesc= employee.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
				.toList();
		
		System.out.println(sortedDesc);
		
		System.out.println("\n Employee Grouped by Dept........");
		Map<String, List<Employee>> groupByDept=employee.stream().
				collect(Collectors.groupingBy(Employee::getDept));
		
		groupByDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(System.out::println);
        });
		
		
	}

}
