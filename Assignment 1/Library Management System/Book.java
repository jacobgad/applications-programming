import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private Author author;
    private Genre genre;
    private List<Patron> holds;
    // write your solution below

    public Book (String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.holds = new ArrayList<>();
    }

    public Genre getGenre() {
        return this.genre;
    }

    public String getGenreName() {
        return genre.getName();
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getAuthorName() {
        return this.author.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public void holdBook (Patron patron) {
        holds.add(patron);
        System.out.println("Book held.");
        System.out.println();
    }

    public void removeHold (Patron patron) {
        holds.remove(patron);
    }

    public boolean isAvalable (Patron patron) {
        boolean avalable = false;
        if (holds.isEmpty() == true) {
            avalable = true;
        }
        for (Patron p : holds) {
            if (patron == p) {
                avalable = true;
            }
        }
        return avalable;
    }

    @Override
    public String toString() {
        return getAuthor() +", "+getTitle();
    }

}