package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateComposition {

	public static void main(String[] args) {
		List<String >words = Arrays.asList("Computer", "Java", "Predicate",
				"Lambda", "Stream", "Functional", "API");
		
		Predicate<String> largerthan5=word->word.length()>5;
		Predicate<String> containSubstr= word -> word.contains("a");;
		
		Predicate<String> combined = largerthan5.and(containSubstr);
		
		List<String> filwords =words.stream().filter(combined)
				.toList();
		
		System.out.println(filwords);
		
		Consumer<String> toUppercase = word-> System.out.println(word.toUpperCase());
		
		words.forEach(toUppercase);
		
	}

}
