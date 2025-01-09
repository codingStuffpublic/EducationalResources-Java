package general;

public class NestedClassPizza {
	
	public class Pizza {
	    private PizzaStatus status = PizzaStatus.READY;
	   
	    public enum PizzaStatus {
	        ORDERED,
	        READY,
	        DELIVERED;
	    }

	    public boolean isDeliverable() {
	        return getStatus() == PizzaStatus.READY;
	    }
	    
	    public PizzaStatus getStatus() {
	    		return status;
	    	}
	}
	
	public static void main(String[] args) {
//		Pizza pizza = new Pizza(); // No enclosing instance of type NestedClassPizza is accessible
		NestedClassPizza outer = new NestedClassPizza();
		Pizza pizza = outer.new Pizza();
		System.out.println(pizza.getStatus());
	}
}
