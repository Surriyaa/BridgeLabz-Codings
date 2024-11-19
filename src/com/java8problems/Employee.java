package com.java8problems;

public class Employee {
	private int id;
	private String name;
	private String dept;
	private int salary;
	public Employee(int id, String name, String dept, int salary) {
		
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public int getSalary() {
		return salary;
	}
	
	public String toString(){
		return String.format("ID: %d, Name: %s, Department: %s, Salary: %d",
				id, name, dept, salary);
		
	}
}
