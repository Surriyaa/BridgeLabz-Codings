package com.java8;

import java.util.ArrayList;
import java.util.List;

public class Filtering {

	public static void main(String[] args) {
		
		List<String> list= new ArrayList<>();
		list.add("Arun");		list.add("Surriyaa");
		list.add("Arunachalam");
		list.add("KumarArun");
		list.add("Varun");

		List<String> list2=list.stream().filter(li->!li.startsWith("A")).toList();
		System.out.println(list2);
	}

}
