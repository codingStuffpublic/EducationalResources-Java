package java17;

public class SwitchPatternMatching {

	public static void main(String[] args) {

	}
	
	static double getDoubleUsingSwitch(Object o) {
	    return switch (o) {
	        case Integer i -> i.doubleValue();
	        case Float f -> f.doubleValue();
	        case String s -> Double.parseDouble(s);
	        default -> 0d;
	    };
	}
	
}
