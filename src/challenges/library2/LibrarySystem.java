package challenges.library2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {
    
	public static void main(String[] args) {
        Library library = new Library();
        
        library.addBook(new Book("Java Basics", "John Doe"));
        library.addBook(new Book("Advanced Java", "Jane Smith"));
        
        library.registerUser(new User("Alice"));
        library.registerUser(new User("Bob"));
        
        library.displayBooks();
        
        library.borrowBook("Alice", "Java Basics");
        library.displayBooks();
        
        library.returnBook("Alice", "Java Basics");
        library.displayBooks();
    }
}

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public void borrowBook() { isAvailable = false; }
    public void returnBook() { isAvailable = true; }
    
    @Override
    public String toString() {
        return title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)");
    }
}

class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.borrowBook();
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }
}

class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    
    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }
    
    public void registerUser(User user) {
        users.put(user.getName(), user);
    }
    
    public void borrowBook(String userName, String bookTitle) {
        User user = users.get(userName);
        Book book = books.get(bookTitle);
        
        if (user == null || book == null || !book.isAvailable()) {
            System.out.println("Borrowing failed: User or book not found, or book unavailable.");
            return;
        }
        
        user.borrowBook(book);
        System.out.println(userName + " borrowed " + bookTitle);
    }
    
    public void returnBook(String userName, String bookTitle) {
        User user = users.get(userName);
        Book book = books.get(bookTitle);
        
        if (user == null || book == null || !user.getBorrowedBooks().contains(book)) {
            System.out.println("Return failed: User or book not found, or book not borrowed.");
            return;
        }
        
        user.returnBook(book);
        System.out.println(userName + " returned " + bookTitle);
    }
    
    public void searchBook(String keyword) {
        books.values().stream()
            .filter(b -> b.getTitle().contains(keyword) || b.getAuthor().contains(keyword))
            .forEach(System.out::println);
    }
    
    public void displayBooks() {
        books.values().forEach(System.out::println);
    }
}

