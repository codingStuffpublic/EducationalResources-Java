package challenges.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	
	private String name;
	private List<Book> borrowedBooks = new ArrayList<Book>(); 
	
	public User(String name) { this.name = name; }
	
	public void addBook(Book book) { borrowedBooks.add(book); }
	public void deleteBook(Book book) { 	borrowedBooks.remove(book); 	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; 	}
	public List<Book> getBorrowedBooks() { return borrowedBooks; }
	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(borrowedBooks, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(borrowedBooks, other.borrowedBooks) && Objects.equals(name, other.name);
	}
	
}
