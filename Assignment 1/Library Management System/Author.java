
public class Author {
    private String name;
    // write your solution below

    public Author (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override 
    public String toString() {
        return this.name;
    }

}