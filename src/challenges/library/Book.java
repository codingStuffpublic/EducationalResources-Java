package challenges.library;

import java.util.Objects;

public class Book {
	
	private String title;
	private String author;
	private BookStatus status;
	
	public Book(String title, String author, BookStatus status) {
		this.title = title;
		this.author = author;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return title + " by " + author + "status " + status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, status, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && status == other.status && Objects.equals(title, other.title);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookStatus getStatus() {
		return status;
	}
	public void setStatus(BookStatus status) {
		this.status = status;
	}
	public enum BookStatus {
        FREE,
        BORROWED,
    }
}
