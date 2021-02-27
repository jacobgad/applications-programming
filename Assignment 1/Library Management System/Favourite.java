public class Favourite {
    private Book book;
    private int count;


    public Favourite(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        this.count++;
    }


    @Override
    public String toString() {
        Book book = getBook();
        return book.toString();
    }
}