package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateStudy {

	//1. Write a Java program to implement a lambda expression to check if a given string is empty.
	//2. Write a Java program to implement a lambda expression to check if the 2 given strings are both empty
	//3. Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
	
	public static void main(String[] args) {

		// 1. Task
		StringChecker checker = str -> str.isEmpty();
		System.out.println(checker.isStringEmpty("this string is not empty"));
		System.out.println(checker.isStringEmpty(""));
		System.out.println(checker.isStringEmpty("   "));

		// 1. Task with Predicate
		Predicate<String> checker2 = str -> str.isEmpty();
		System.out.println(checker2.test("this string is not empty"));
		System.out.println(checker2.test(""));
		System.out.println(checker2.test("   "));

		// 2. Task
		BiPredicate<String, String> checkerForTwo = (str1, str2) -> str1.isEmpty() && str2.isEmpty();
		System.out.println(checkerForTwo.test("this string is not empty", "not empty"));
		System.out.println(checkerForTwo.test("", ""));
		
		//3. Task
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(filterEven(list));
		
		//4 default methods
		filter();
	}

	//	Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
	static List<Integer> filterEven(List<Integer> list){
		List<Integer> collect = list.stream().filter(x -> x % 2 == 0 ).collect(Collectors.toList());
		return collect;
	}
	
	static void filter() {
		Predicate<Integer> isEven = i -> i % 2 == 0;
		Predicate<Integer> isPositive = i -> i > 0;

		System.out.println("-------- filter ----------");
		System.out.println(isEven.test(4)); // Outputs: true
		System.out.println(isEven.and(isPositive).test(-4)); // Outputs: false
		System.out.println(isEven.or(isPositive).test(-3)); // Outputs: true
		System.out.println(isEven.negate().test(4)); // Outputs: true
	}
}

//1. Write a Java program to implement a lambda expression to check if a given string is empty.
interface StringChecker {
	boolean isStringEmpty(String text);
}

