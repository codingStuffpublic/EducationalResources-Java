package general;

//Class
//ExceptionThrown
class ExceptionHandlingStudy {

	
//	ArithmeticException inherits from the RuntimeException class which means it is an unchecked, runtime exception
	public static void main(String args[]) {
		int a = 1;
		int b = 1;

		try {
			divideByZero(a, b);
		}
		catch (ArithmeticException ex) {
			System.out.println(ex);
		}
	}
	
	static void divideByZero(int a, int b) {
		int i = a / b;
		System.out.println(i);
	}
}
