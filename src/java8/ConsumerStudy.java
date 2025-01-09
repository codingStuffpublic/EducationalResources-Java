package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public class ConsumerStudy {
	
	public static void main(String[] args) {
		consumer();
		combineConsumers();
	}
	
	static void consumer(){
		List<String> names = Arrays.asList("John", "Freddy", "Samuel");
		names.forEach(name -> System.out.println("Hello, " + name));
	}


	static void consumerOnMap(){
		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);
		
		// BiConsumer as foreach param
		ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
	}
	
	static void combineConsumers(){
		Consumer<String> printFunction = System.out::println;
        Consumer<String> toUpperCaseAndPrint = s -> System.out.println(s.toUpperCase());
        printFunction.andThen(toUpperCaseAndPrint).accept("Java");

        Consumer<String> first = t -> System.out.println(t.toUpperCase());
        Consumer<String> second = t -> System.out.println(t.toLowerCase());
        first.andThen(second).accept("Hello world");
	}
	
	

	
}
