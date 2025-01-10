package java9;

public interface SendNotificationInterface {
	
	static void sendNotifications() {
		establishConnection();
	}
	
	default void sendNotification() {
		establishConnection();
		
	}

	private static void establishConnection() {
		
	}

}
