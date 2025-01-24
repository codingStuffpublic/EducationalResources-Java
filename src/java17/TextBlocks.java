package java17;

public class TextBlocks {
	
	public static void main(String[] args) {
		  String stringJSON = "{\r\n" 
			      + "   \"Name\" : \"Mahesh\",\r\n" 
			      + "   \"RollNO\" : \"32\"\r\n" 
			      + "}";  

			      System.out.println(stringJSON);
		
		String textBlockJSON = """
				   {
				      "name" : "Mahesh",
				      "RollNO" : "32"
				   }
				   """;
		
		String textBlockJSON2 = """
				   {
				      "name" : "Mahesh",
				      "RollNO" : "32"
				   }
				"""; //align the starting point of incidental spaces
		System.out.println(textBlockJSON);
		
		System.out.println(textBlockJSON2);
	}

}
