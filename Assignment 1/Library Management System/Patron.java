import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patron {
	private int ID;
	private String name;
	private List<Book> currentlyBorrowed;
	private List<Book> borrowingHistory;
	// write your solution below
	private List<Favourite> favoriteBooks;

	public Patron (int ID, String name) {
		this.ID = ID;
		this.name = name;
		this.currentlyBorrowed = new ArrayList<Book>();
		this.borrowingHistory = new ArrayList<Book>();
		this.favoriteBooks = new ArrayList<Favourite>();
	}

	@Override
	public String toString() {
		return ID + " " + name;
	}

	public void borrowBook (Book book) {
		currentlyBorrowed.add(book);
		borrowingHistory.add(book);
		Favourite favourite = findFavourite(book);
		if (favourite != null) {
			favourite.incrementCount();
		}
		else {
			favoriteBooks.add(new Favourite(book, 1));
		}
	}

	public Favourite findFavourite(Book book) {
		for (Favourite favourite : favoriteBooks) {
			if (favourite.getBook().equals(book)) {
				return favourite;
			}
		}
		return null;
	}

	public void returnBook (Book book) {
		if (currentlyBorrowed.contains (book)) {
			currentlyBorrowed.remove(book);
		}
	}

	public int getId() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public List<Book> currentlyBorrowed() {
		return this.currentlyBorrowed;
	}

	public List<Book> borrowingHistory() {
		return this.borrowingHistory;
	}

	public void listCurrentlyBorrowed() {
		for (Book book : currentlyBorrowed) {
			System.out.println(book.getAuthor()+", "+book.getTitle());
		}
	}

	public void listBorrowingHistory() {
		for (Book book : borrowingHistory) {
			System.out.println(book.getAuthor()+", "+book.getTitle());
		}
	}

	public void favoriteBooks() {
		Collections.sort(favoriteBooks, Collections.reverseOrder((o1, o2) -> o1.getCount() - o2.getCount()));
		if (0 < favoriteBooks.size()) {
			System.out.println(favoriteBooks.get(0));
		}
		if (1 < favoriteBooks.size()) {
			System.out.println(favoriteBooks.get(1));
		}
		if (2 < favoriteBooks.size()) {
			System.out.println(favoriteBooks.get(2));
		}
	}		
}