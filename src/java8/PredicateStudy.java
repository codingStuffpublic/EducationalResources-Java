package java8;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateStudy {

	//1. Write a Java program to implement a lambda expression to check if a given string is empty.
	//2. Write a Java program to implement a lambda expression to check if the 2 given strings are both empty
	
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
	}
}

//1. Write a Java program to implement a lambda expression to check if a given string is empty.
interface StringChecker {
	boolean isStringEmpty(String text);
}

