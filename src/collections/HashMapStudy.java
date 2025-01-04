package collections;

import java.util.HashMap;
import java.util.Map;

//use Lombok instead of getters and setters!
public class HashMapStudy {
//	search in list: time complexity is O(n), sorted list: O(log n) using binary search.
	
	static Map<String, Product> productsByName = new HashMap<>();

	public static void main(String[] args) {
		Product eBike = new Product("E-Bike", "A bike with a battery");
		Product roadBike = new Product("Road bike", "A bike for competition");
		productsByName.put(eBike.getName(), eBike);
		productsByName.put(roadBike.getName(), roadBike);
	}
	
	
	
	
	

}

class Product {
	private String name;
    private String description;
    
    public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}
    
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description;	}
}