package general;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryAndLinearSearchExample {
    
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 3, 5, 7, 9, 11, 13, 15);

        int target = 7;
//        int result = binarySearch(numbers, target);
        int result = linearSearch(numbers, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
	
    public static int linearSearch(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) == target)
                return i;
        return -1;
    }
	
	public static int binarySearch(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) 
                return mid;
            else if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}

