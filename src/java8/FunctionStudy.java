package java8;

import java.util.Arrays;
import java.util.List;

public class FunctionStudy {

	//1. Convert list of strings to uppercase using Lambda expression in Java
	
	public static void main(String[] args) {
		//1. 
		List<String> list = Arrays.asList("Red", "green", "bLUe");
		System.out.println(toUpperCaseList(list)); //[RED, GREEN, BLUE]
	}
	
	//1. Convert list of strings to uppercase using Lambda expression in Java
	static List<String> toUpperCaseList(List<String> list){
		list.replaceAll(s -> s.toUpperCase()); //UnaryOperator
		return list;
	}

}
