package challenges;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		int[] arr = { 2, 3, 7, 4, 8};
		twoSum(arr, 9);
	}
	
	static void twoSum(int[] array, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			int delta = target - number; //positive integer
			System.out.println("number" + number + "delta " + delta );
			if(map.containsKey(number)) {
				System.out.println(map.get(number) + ", " + i);
				break;
			}
			else 
				map.put(delta, i);
		}
	}
}
