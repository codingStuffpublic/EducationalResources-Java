package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Lambdas {

	public static void main(String[] args) {
		System.out.println(toUpperCase("hello"));
		
		List<String> list = Arrays.asList("Red", "green", "bLUe");
		System.out.println(toUpperCaseList(list));
	}

	//1, Convert a string to uppercase using Lambda expression in Java
	static String toUpperCase(String str){
		UnaryOperator<String> c = s -> s.toUpperCase();
		return c.apply(str);
	}
	
	//2, Convert list of strings to uppercase using Lambda expression in Java
	static List<String> toUpperCaseList(List<String> list){
		list.replaceAll(s -> s.toUpperCase());
		return list;
	}


}
