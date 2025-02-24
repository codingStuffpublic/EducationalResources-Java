package challenges.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import challenges.library.Book.BookStatus;

public class Library {

	public Library() {}

	private Map<String, Book> books = new HashMap<>(); 
	private Map<String, User> users = new HashMap<>(); 
	
//	private Map<String, ArrayList<Book>> userBooks = new HashMap<String, ArrayList<Book>>();

	{
		books.put("Az Ajtó", new Book("Az Ajtó", "Szabó Magda", BookStatus.FREE));
		books.put("Book1", new Book("Book1", "Author1", BookStatus.FREE));
		books.put("Book2", new Book("Book2", "Author2", BookStatus.FREE));
		books.put("Book3", new Book("Book3", "Author3", BookStatus.BORROWED));
		books.put("Book4", new Book("Book4", "Author4", BookStatus.BORROWED));
		books.put("Book5", new Book("Book5", "Author5", BookStatus.BORROWED));
	}
	
	public Book findBook(String title) {
		if(books.containsKey(title))
			return books.values().stream().filter(x -> x.getTitle().equals(title)).findAny().orElseThrow();
		return null;
	}
	
	public Book searchBook(String title) {
		if(books.containsKey(title))
			return books.values().stream().filter(x -> x.getTitle().equals(title)).findAny().orElseThrow();
		return null;
	}
	
	public void borrowBook(User user, Book book) {
		if(users.containsKey(user.getName())) {
			user.addBook(book);
//			userBooks.get(user.getName()).add(book);
		}
		else 	{
			users.put(user.getName(), user);
			user.addBook(book);
//			userBooks.put(user.getName(), new ArrayList<Book>(Arrays.asList(book)));
		}
		book.setStatus(BookStatus.BORROWED);
	}
	
	public void retrieveBook(User user, Book book) {
		user.deleteBook(book);
//		userBooks.get(user.getName()).remove(book);
		book.setStatus(BookStatus.FREE);
	}
	
	public void printBooks()	{
		books.values().forEach(System.out::println);
	}

}
