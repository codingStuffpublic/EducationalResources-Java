package collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		PriorityQueue<Integer> numbers = new PriorityQueue<>(new CustomComparator());
		numbers.add(4);
		numbers.add(2);
		numbers.add(1);
		numbers.add(3);
		System.out.print("PriorityQueue: " + numbers);
	}
}

class CustomComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer number1, Integer number2) {
		// elements are sorted in reverse order
		int value = number1.compareTo(number2);
		if (value > 0)
			return -1;
		else if (value < 0)
			return 1;
		else
			return 0;
	}
}
