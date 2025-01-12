package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

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
		
		functionOnMap();
		
		stringUppercaseUnaryOperator();
		
		squareUnaryOperator();
		
		biFunction();
		
		binaryOperator();
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
		System.out.println(stringLength.andThen(square).apply("Hello")); // Outputs: 25
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
	
	static void functionOnMap() {
//		Map<String, Integer> map = new HashMap<String, Integer>() {{ 
//            put("John", null); 
//            put("Tom", 3); 
//            put("TJ", 2); 
//        }}; 
        
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", null);
        map.put("Bob", 0);
        map.put("Charlie", 0);

        map.keySet().forEach(key -> map.computeIfAbsent(key, k -> k.length()));
        map.forEach((key, value) -> System.out.println(key + ": " + value));
	}
	
	//Function vs. UnaryOperator
	private static void stringUppercaseUnaryOperator() {
//		Function<String, String> toUppercase = x -> x.toUpperCase();
		UnaryOperator<String> toUppercase = x -> x.toUpperCase();
		System.out.println(toUppercase.apply("Hello Bello"));
	}
	
	static void squareUnaryOperator() {
		UnaryOperator<Integer> square = i -> i * i;
		System.out.println(square.apply(5)); // Outputs: 25
	}
	
	private static void biFunction() {
		BiFunction<Integer, Integer, String> sumAndFormat = (a, b) -> "Sum: " + (a + b);
		System.out.println(sumAndFormat.apply(3, 4)); // Outputs: Sum: 7
	}
	
	static void binaryOperator() {
		BinaryOperator<Integer> add = (a, b) -> a + b;
		System.out.println(add.apply(3, 4)); // Outputs: 7
	}


}
