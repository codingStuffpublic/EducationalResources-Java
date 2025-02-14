package tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TripletsWithSum0 {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(-6, -2, 0, 2, 4, 7);
		sumOfList(list);
	}

	private static void sumOfList(List<Integer> list) {
		list.sort(Comparator.naturalOrder());
		System.out.println( list );
		int num_i, num_j, num_k, value = 0;
		for (int i = 0; i < list.size()-2; i++) {
			for (int j = i+1; j < list.size()-1; ) {
				for (int k = list.size()-1; k > 1; ) {
					num_i = list.get(i);
					num_j = list.get(j);
					num_k = list.get(k);
					System.out.println("i: " + num_i +  " j: " + num_j + " k: " + num_k);
					value = -1*num_i;
					if( num_j + num_k == value ) {
						System.out.println("triplet i: " + num_i + " j: " + num_j + " k: " + num_k);
						j++;
						k--;
						if( j >= k )
							break;
					}
					else if( (num_j + num_k) < value && j < k) 
						j++;
					else if( (num_j + num_k) > value && j < k) 
						k--;
					else
						break;
				}
				break;
			}
		}
	}
}
