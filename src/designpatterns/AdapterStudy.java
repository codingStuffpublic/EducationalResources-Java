package designpatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdapterStudy {
    public static void main(String[] args) {
    		arraysAsList();
    		unmodifiableList();
    }
    
    static void arraysAsList(){
        String[] array = {"Apple", "Banana", "Cherry"};
        List<String> list = Arrays.asList(array);

        System.out.println("List elements: " + list);
        list.set(1, "Blueberry");
        System.out.println("Modified array: " + Arrays.toString(array));
    }
    
    static void unmodifiableList() {
    		List<String> originalList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
    		List<String> unmodifiableList = Collections.unmodifiableList(originalList);

    		System.out.println("Original List: " + originalList);
    		System.out.println("Unmodifiable List: " + unmodifiableList);

    		unmodifiableList.add("Blueberry");  // Throws UnsupportedOperationException
    }
}
