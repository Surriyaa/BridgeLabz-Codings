package com.java8problems;
import java.util.*;

	class Book {
	    private String title;
	    private String genre;
	    private double rating;
	
	    public Book(String title, String author, String genre, double rating) {
	        this.title = title;
	        this.genre = genre;
	        this.rating = rating;
	    }
	
	    public String getTitle() {
	        return title;
	    }
	
	    public String getGenre() {
	        return genre;
	    }
	
	    public double getRating() {
	        return rating;
	    }
	
	    @Override
	    public String toString() {
	        return String.format("Title: %s, Rating: %.1f", title, rating);
	    }
	}
	
	public class BookRecommendations {
		public static void main(String[] args) {

	        List<Book> books = Arrays.asList(
	                new Book("Dune", "Frank Herbert", "Science Fiction", 4.6),
	                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.5),
	                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
	                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 3.9),
	                new Book("The Martian", "Andy Weir", "Science Fiction", 4.7),
	                new Book("1984", "George Orwell", "Dystopian", 4.4),
	                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
	                new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian", 4.3),
	                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.3),
	                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.2)
	        );
	        //1
	        List<Book> filteredBooks=books.stream().filter(n->n.getGenre().equalsIgnoreCase("Science Fiction"))
	        		.filter(n->n.getRating()>4.0).toList();
	        
	        System.out.println(" books that are of genre \"Science Fiction\" with a rating greater than 4.0");
	        
	        System.out.println(filteredBooks);
	        
	     // 2. Transform: Create a list of title and rating pairs using Map.Entry
	        List<Map.Entry<String, Double>> bookRecommendations = filteredBooks.stream()
	                .map(book -> Map.entry(book.getTitle(), book.getRating()))
	                .toList();

	        System.out.println("Filtered and Transformed Book Recommendations:");
	        bookRecommendations.forEach(entry -> 
	            System.out.printf("Title: %s, Rating: %.1f%n", entry.getKey(), entry.getValue())
	        );
	        
	        // 3. Sort: Sort these books by their rating in descending order
	        List<Book> sortedByRatingDesc = filteredBooks.stream()
	                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
	                .toList();

	        System.out.println("\nBooks sorted by rating (descending):");
	        sortedByRatingDesc.forEach(System.out::println);
	        //4
	        List<Book> top10=sortedByRatingDesc.stream()
	        		.limit(10).toList();
	        System.out.println("\nPaginated Book Recommendations (Top 10, 5 per page):");
	        for(int i=0;i<top10.size();i+=5) {
	        	System.out.printf("Page %d:%n",(i/5)+1);
	        	top10.stream().skip(i)
	        	.limit(5)
	        	.forEach(System.out::println) ;
	        	System.out.println();
	        	
	        	
	        }
		
	        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}}
