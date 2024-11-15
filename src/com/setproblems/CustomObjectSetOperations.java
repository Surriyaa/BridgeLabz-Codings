package com.setproblems;

import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

class Persons implements Comparable<Persons> {
    String name;
    int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return age == persons.age && Objects.equals(name, persons.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Persons other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Person(" + name + ", " + age + ")";
    }
}

public class CustomObjectSetOperations {

    public static Set<Persons> union(Set<Persons> set1, Set<Persons> set2) {
        Set<Persons> result = new TreeSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Persons> difference(Set<Persons> set1, Set<Persons> set2) {
        Set<Persons> result = new TreeSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Persons> set1 = Set.of(new Persons("Alice", 30), new Persons("Bob", 25));
        Set<Persons> set2 = Set.of(new Persons("Bob", 25), new Persons("Charlie", 35));

        System.out.println("Union: " + union(set1, set2));
        System.out.println("Difference: " + difference(set1, set2));
    }
}
