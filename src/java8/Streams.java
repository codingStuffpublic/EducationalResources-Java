package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

	//double bracket init
	List<Integer> myList = new ArrayList<>() {{ for(int i=0; i<100; i++) myList.add(i); }};
	Stream<Integer> sequentialStream = myList.stream();
	Stream<Integer> parallelStream = myList.parallelStream();
	
	public static void main(String[] args) {
		avgOfInts();
		stringUppercase();
		maxInteger();
		secondSmallest();
	}	
	
	//1. Write a Java program to calculate the average of a list of integers using streams.
	private static void avgOfInts() {
		List<Integer> nums = Arrays.asList(1, 3, 6, 8, 10, 18, 36);
		double avg = nums.stream().mapToDouble(x -> x.doubleValue()) //Integer::doubleValue
		.average().orElse(0.0);
		
	    System.out.println("Average value of the numbers: " + avg);
	} 
	
	//2. Write a Java program to convert a list of strings to uppercase using streams.
	private static void stringUppercase() {
		List<String> colors = Arrays.asList("RED", "grEEn", "white", "Orange", "pink");
//	    List<String> uppercaseStrings = 
	    	colors.stream().map(String::toUpperCase).forEach(System.out::println);
//	      .collect(Collectors.toList());
	}

	//3. Output the max of a list of Integers
	private static void maxInteger() {
		List<Integer> nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
		System.out.println("Original list of numbers: " + nums);
		System.out.println(nums.stream().max(Integer::compare).orElse(null));
	}
	
	//4. Output the second largest and second smallest out of the list of Integers
	private static void secondSmallest() {
		List<Integer> nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
		System.out.println("List of numbers: " + nums);
		Integer secondSmallest = nums.stream().distinct().sorted().skip(1).findFirst().orElse(null);

		// Find the second largest element: reverse order!
		Integer secondLargest = nums.stream().distinct().sorted((a, b) -> Integer.compare(b, a)).skip(1).findFirst()
				.orElse(null);

		System.out.println("\nSecond smallest element: " + secondSmallest);
		System.out.println("\nSecond largest element: " + secondLargest);
	}
	
	//Ways to create streams
	private static void initStreams() {
		Stream<Integer> stream1 = Stream.of(1,2,3,4);
		
		Stream<Integer> stream2 = Stream.of(new Integer[]{1,2,3,4}); 
						
		Stream<String> stream3 = Stream.generate(() -> {return "abc";});
		
		Stream<String> stream4 = Stream.iterate("abc", (i) -> i);
		
		LongStream stream5 = Arrays.stream(new long[]{1,2,3,4});
		
		IntStream stream6 = "abc".chars();
	}
}
