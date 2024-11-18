package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person{
	private String name;
	private int age;
	private int salary;
	
	Person(String name,int age,int salary){
		this.name=name;
		this.age=age;
		this.salary=salary;
	}

	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}

	public int getSalary() {
		return salary;
	}
	public String toString() {
        return "Person{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }

}
public class SortPersonList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people=Arrays.asList(
				new Person("Surriyaa",21,20000),
				new Person("Mohit",20,25000),
				new Person("Raja",33,26000)
				);
		
		people.sort(Comparator.comparingInt(Person::getAge));
		people.forEach(System.out::println);

	}

}
