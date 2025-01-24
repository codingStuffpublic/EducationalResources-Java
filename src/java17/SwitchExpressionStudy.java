package java17;

public class SwitchExpressionStudy {

	public static void main(String[] args) {
		
	}
	
	public static String getDayOfWeekSwitchExpression(int dayNum) {
	    return switch (dayNum) {
	        case 1 -> "Monday";
	        case 2 -> "Tuesday";
	        case 3 -> "Wednesday";
	        case 4 -> "Thursday";
	        case 5 -> "Friday";
	        case 6 -> "Saturday";
	        case 7 -> "Sunday";
	        default -> "Invalid day";
	    };
	}
	
	public static String getDayOfWeek(int dayNum) {
	    String day;
	    switch (dayNum) {
	        case 1:
	            day = "Monday";
	            break;
	        case 2:
	            day = "Tuesday";
	            break;
	        case 3:
	            day = "Wednesday";
	            break;
	        case 4:
	            day = "Thursday";
	            break;
	        case 5:
	            day = "Friday";
	            break;
	        case 6:
	            day = "Saturday";
	            break;
	        case 7:
	            day = "Sunday";
	            break;
	        default:
	            day = "Invalid day";
	    }
	    return day;
	}
	
}

//Another example
record CreditCardPayment(String cardNumber) {}

record PayPalPayment(String email) {}

class PaymentProcessing {

//  private static void processPayment(Object payment) {
//      String result = switch (payment) {
//          case CreditCardPayment cc -> "Processing Credit Card payment with card number: " + cc.cardNumber();
//          case PayPalPayment pp -> "Processing PayPal payment with email: " + pp.email();
//          case Integer amount -> "Processing Cash payment of $" + amount;
//          case null -> "Invalid payment method: null";
//          default -> "Unknown payment method.";
//      };
//      System.out.println(result);
//  }
//
//  public static void main(String[] args) {
//      processPayment(new CreditCardPayment("1234-5678-9876-5432"));
//  }
}
