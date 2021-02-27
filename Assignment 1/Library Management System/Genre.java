public class Genre {
    private String name;
    // write your solution below

    public Genre (String name) {
        this.name = name.trim().toLowerCase();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}