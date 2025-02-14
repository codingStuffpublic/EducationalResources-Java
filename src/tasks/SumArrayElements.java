package tasks;

import java.util.Arrays;
import java.util.List;

public class SumArrayElements {
	
	public static void main(String[] args) {
		
		sumOfList();
	}

	private static void sumOfList() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		System.out.println( sum );
	}

}
