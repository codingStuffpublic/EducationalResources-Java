package java8;

import java.util.function.Supplier;

public class SupplierStudy {

	public static void main(String[] args) {
		
//		Supplier<Double> randomValue2 = () -> Math.random();
		Supplier<Double> randomValue = Math::random;
		System.out.println(randomValue.get()); 
	}
}
