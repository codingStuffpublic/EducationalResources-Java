package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

	//double bracket init
	List<Integer> myList = new ArrayList<>() {{ for(int i=0; i<100; i++) myList.add(i); }};
	Stream<Integer> sequentialStream = myList.stream();
	Stream<Integer> parallelStream = myList.parallelStream();
	
	public static void main(String[] args) {
//		avgOfInts();
//		stringUppercase();
//		maxInteger();
//		secondSmallest();
//		intermedateOperations();
		terminalOperations();
	}	
	
	private static void terminalOperations() {
		List<String> names = Arrays.asList(
	            "Reflection", "Collection", "Stream",
	            "Structure", "Sorting", "State"
	        );

	        System.out.println("\nforEach:");
	        names.stream().forEach(System.out::println);

	        List<String> sNames = names.stream()
	                                   .filter(name -> name.startsWith("S"))
	                                   .collect(Collectors.toList());
	        System.out.println("\ncollect (names starting with 'S'):");
	        sNames.forEach(System.out::println);

	        String concatenatedNames = 
	        		names.stream().reduce( "", (partialString, element) -> partialString + " " + element);
	        System.out.println("\nreduce (concatenated names):");
	        System.out.println(concatenatedNames.trim());

	        long count = names.stream().count();
	        System.out.println("\ncount:" + count);

	        Optional<String> firstName = names.stream().findFirst();
	        System.out.println("\nfindFirst:");
	        firstName.ifPresent(System.out::println);

	        boolean allStartWithS = names.stream().allMatch(name -> name.startsWith("S"));
	        System.out.println("\nallMatch (all start with 'S'):");
	        System.out.println(allStartWithS);

	        boolean anyStartWithS = names.stream().anyMatch(name -> name.startsWith("S"));
	        System.out.println();
	        System.out.println("\nanyMatch (any start with 'S'):" + anyStartWithS);
		
	}

	private static void intermedateOperations() {
		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("Reflection", "Collection", "Stream"),
				Arrays.asList("Structure", "State", "Flow"),
				Arrays.asList("Sorting", "Mapping", "Reduction", "Stream"));

		Set<String> intermediateResults = new HashSet<>();

		// Flatten the list of lists into a single stream
		List<String> result = listOfLists.stream().flatMap(List::stream) 
				.filter(s -> s.startsWith("S"))
				.map(String::toUpperCase)
				.distinct()
				.sorted()
				.peek(s -> intermediateResults.add(s)) //Perform action(add to set) on each element
				.collect(Collectors.toList());

		System.out.println("Intermediate Results:");
		intermediateResults.forEach(System.out::println);

		System.out.println("Final Result:");
		result.forEach(System.out::println);
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
