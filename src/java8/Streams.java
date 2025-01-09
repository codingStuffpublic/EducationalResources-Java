package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
	
	
	public static void main(String[] args) {
		avgOfInts();
		stringUppercase();
		
	}	
	
	//1. Write a Java program to calculate the average of a list of integers using streams.
	private static void avgOfInts() {
		List<Integer> nums = Arrays.asList(1, 3, 6, 8, 10, 18, 36);
		double avg = nums.stream().mapToDouble(x -> x.doubleValue()) //Integer::doubleValue
		.average().orElse(0.0);
		
	    System.out.println("Average value of the numbers: " + avg);
	} 
	
	//2, Write a Java program to convert a list of strings to uppercase using streams.
	private static void stringUppercase() {
		List<String> colors = Arrays.asList("RED", "grEEn", "white", "Orange", "pink");
//	    List<String> uppercaseStrings = 
	    	colors.stream().map(String::toUpperCase).forEach(System.out::println);
//	      .collect(Collectors.toList());
	
	}
	
	private static void initStreams() {
		Stream<Integer> stream1 = Stream.of(1,2,3,4);
		
		Stream<Integer> stream2 = Stream.of(new Integer[]{1,2,3,4}); 
		
		List<Integer> myList = new ArrayList<>() {{ for(int i=0; i<100; i++) myList.add(i); }};
				
		Stream<Integer> sequentialStream = myList.stream();
				
		Stream<Integer> parallelStream = myList.parallelStream();
		
		Stream<String> stream3 = Stream.generate(() -> {return "abc";});
		
		Stream<String> stream4 = Stream.iterate("abc", (i) -> i);
		
		LongStream stream5 = Arrays.stream(new long[]{1,2,3,4});
		
		IntStream stream6 = "abc".chars();
	}
}
