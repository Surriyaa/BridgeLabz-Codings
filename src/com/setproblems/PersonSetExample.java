package com.setproblems;
import java.util.*;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Override equals and hashCode to ensure uniqueness based on name and age
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class PersonSetExample {

    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        
        Person searchPerson = new Person("Alice", 30);
        System.out.println("Contains 'Alice (30)': " + people.contains(searchPerson));  // Output: true
    }
}
