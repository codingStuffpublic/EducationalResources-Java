package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionStudy {

	//1. Convert list of strings to uppercase using Lambda expression in Java
	//2. Write a function that represents the usage of the andThen() default method
	//3. Write a function that represents the usage of the compose() default method
	
	public static void main(String[] args) {
		//1. 
		List<String> list = Arrays.asList("Red", "green", "bLUe");
		System.out.println(toUpperCaseList(list)); //[RED, GREEN, BLUE]
		functionsAndThen();
		functionsCompose();
	
	}
	
	//1. Convert list of strings to uppercase using Lambda expression in Java
	static List<String> toUpperCaseList(List<String> list){
		list.replaceAll(s -> s.toUpperCase()); //UnaryOperator
		return list;
	}

	//2. Write a function that represents the usage of the andThen() default method
	static void functionsAndThen() {
		Function<String, Integer> stringLength = s -> s.length();
		Function<Integer, Integer> square = len -> len * len;
		Function<String, Integer> squaredLength = stringLength.andThen(square);
		System.out.println(squaredLength.apply("Hello")); // Outputs: 25
	}
	
	//3. Write a function that represents the usage of the compose() default method
	static void functionsCompose() {
		Function<Integer, Integer> addNums = i -> i + 3;
		Function<Integer, Integer> square = i -> i * i;
		Function<Integer, Integer> composedFunction = square.compose(addNums);
		Function<Integer, Integer> composedFunctionReversed = square.andThen(addNums);
		System.out.println(composedFunction.apply(1)); // Outputs: 16
		System.out.println(composedFunctionReversed.apply(1)); // Outputs: 4
	}

}
