package general;

public class SwitchStudy {
	
//	switch works only with these: byte, Byte, short, Short, int, Integer
//	char, Character, enum, String
	
//	 public enum Animal {
//	        DOG,
//	        CAT,
//	        TIGER;
//	 }

	public static void main(String[] args) {
//		Animal animal = Animal.CAT;
		String animal = "CAT";
		String result;
		switch (animal) {
		case "DOG":
			result = "domestic animal"; 
			break;
		case "CAT":
			result = "domestic animal";
			break;
		case "TIGER":
			result = "wild animal";
			break;
		default:
			result = "unknown animal";
			break;
		}
		System.out.println(result);
	}

}
