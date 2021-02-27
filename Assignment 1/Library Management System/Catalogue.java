import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    //private Library library;
	private List<Book> booksOnShelf;
	private List<Book> booksOnLoan;
	private List<Genre> genres;
	private List<Author> authors;
	// write your solution below

	public Catalogue () {
		//this.library = library;
		booksOnShelf = new ArrayList<Book>();
		booksOnLoan = new ArrayList<Book>();
		genres = new ArrayList<Genre>();
		authors = new ArrayList<Author>();
	}

	public void addBook() {
        System.out.println();
        System.out.println("Adding a new book.");
        System.out.print("Enter the title of the book: ");
        String inputTitle = In.nextLine();
        
        System.out.print("Enter the author's name: ");
		Author inputAuthor = new Author(In.nextLine());
		addAuthor(inputAuthor);
        
		System.out.print("Enter the genre: ");
		Genre inputGenre = new Genre (In.nextLine());
		addGenre(inputGenre);
		                       
		booksOnShelf.add(new Book(inputTitle, inputAuthor, inputGenre));
		System.out.println("Added "+inputTitle+" to catalogue.");
        System.out.println();
	}

	private void addGenre(Genre genre) {
		boolean found = false;
		for (Genre g : genres) {
			if (g.getName().equals(genre.getName())) {
				found = true;
			}
		}
		if(found == false) {
			genres.add(genre);
		}
	}

	private void addAuthor(Author author) {
		boolean found = false;
		for (Author a : authors) {
			if (a.getName().equals(author.getName())) {
				found = true;
			}
		}
		if (found == false) {
			authors.add(author);
		}
	}

	public void removeBook() {
		System.out.println();
		System.out.println("Removing a book.");
		System.out.print("Enter the title of the book: ");
		String inputTitle = In.nextLine();
		System.out.print("Enter the author's name: ");
		String inputAuthor = In.nextLine();

		Book book = getBook(inputTitle);
		if (book != null && book.getAuthorName().equals(inputAuthor)) {
			booksOnShelf.remove(book);
			System.out.println(book.getAuthor()+", "+book.getTitle()+" removed from catalogue.");
		}
		else {
			System.out.println("No such book found.");
		}
		System.out.println();
	}
	
	public void getAllBooks() {
		System.out.println();
		System.out.println("The Library has the following books:");
		for (Book book : booksOnShelf) {
			System.out.println(book.getAuthor()+", "+ book.getTitle());
		}
		for (Book book : booksOnLoan) {
			System.out.println(book.getAuthor()+", "+ book.getTitle());
		}
		System.out.println();
	}

	public void getAvalableBooks() {
		System.out.println();
		System.out.println("The following books are on the shelf:");
		for (Book book : booksOnShelf) {
			System.out.println(book.getAuthor()+", "+ book.getTitle());
		}
		System.out.println();
	}

	public void getAllGenre() {
		System.out.println();
		System.out.println("The Library has books in the following genres:");
		for (Genre genre : genres) {
			System.out.println(genre);
		}
		System.out.println();
	
	}

	public void displayAllBooksInGenre() {
		System.out.println();
		System.out.print("Enter a genre: ");
		String genre = In.nextLine();
		System.out.println("The library has the following books in that genre:");
		for (Book book : booksOnShelf) {
			if (genre.equals(book.getGenreName())) {
				System.out.println(book);
			}
		}
		System.out.println();
	}

	public void getAllAuthor() {
		System.out.println();
		System.out.println("The following authors have books in this Library:");
		for (Author author : authors) {
			System.out.println(author);
		}
		System.out.println();
	
	}

	public void getAllBooksInAuthor() {
		System.out.println();
		System.out.print("Enter the name of an author: ");
		String author = In.nextLine();
		System.out.println("The library has the following books by that author:");
		for (Book book : booksOnShelf) {
			if (author.equals(book.getAuthorName())) {
				System.out.println(book);
			}
		}
		System.out.println();
	}

	public Book getBook(String bookName) {
		for (Book book : booksOnShelf) {
			if (book.getTitle().equals(bookName)) {
				return book;
			}
		}
		for (Book book : booksOnLoan) {
			if (book.getTitle().equals(bookName)) {
				return book;
			}
		}
		return null;
	}

	public boolean checkbooksOnShelf(Book book) {
		for (Book b : booksOnShelf) {
			if (b.equals(book)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkbookExists(Book book) {
		for (Book b : booksOnShelf) {
			if (b.equals(book)) {
				return true;
			}
		}
		for (Book b : booksOnLoan) {
			if (b.equals(book)) {
				return true;
			}
		}
		return false;
	}

	public void borrowBook(Book book) {
		booksOnShelf.remove(book);
		booksOnLoan.add(book);	
	}

	public void returnBook (Book book) {
		booksOnShelf.add(book);
		booksOnLoan.remove(book);
	}

	public void removeBook (Book book) {
		booksOnShelf.remove(book);
		booksOnLoan.remove(book);
	}

	public void holdBook(Patron patron) {
		System.out.print("Enter book title: ");
		String inputTitle = In.nextLine();

		Book book = getBook(inputTitle);
		if (checkbookExists(book) == true) {
			book.holdBook(patron);
		}
	}
}