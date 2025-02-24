package challenges.library;

public class Main {
	
	public static void main(String[] args) {

		//create users
		User user1 = new User("Peter");
		User user2 = new User("Ann");
		User user3 = new User("Diane");
		
		Library library = new Library();
		library.printBooks();
		Book book = library.findBook("Book1");
		if (book != null)
			library.borrowBook(user3, book);
		
		library.printBooks();
		System.out.println("user: " + user3.getName());
		System.out.println("book : " + book.getTitle());
//		System.out.println("users books : " + user3.getBorrowedBooks().get(0).getTitle() + "status " + book.getStatus());
		
		library.retrieveBook(user3, book);
		library.printBooks();
				
		System.out.println("user: " + user3.getName());
		System.out.println("book : " + book.getTitle() + "status " + book.getStatus());
//		System.out.println("users books : " + user3.getBorrowedBooks().get(0).getTitle() + "status " + book.getStatus());
	}
}
