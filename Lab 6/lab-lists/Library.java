import java.util.ArrayList;
import java.util.List;

public class Library {
	private Catalogue catalogue;
    private List<Patron> patrons;
    // write your solution below

    public static void main(String[] args) {
        new Library().use();
    }

    private char readChoice() {
        System.out.println ("Welcome to the Library! Please make a selection from the menu:");
        System.out.println ("1. Explore the catalogue.");
        System.out.println ("2. View your patron record.");
        System.out.println ("3. Show you favourite books.");
        System.out.println ("4. Enter Admin Mode.");
        System.out.println ("X. Exit the system.");
        System.out.print ("Enter a choice: ");

        return In.nextChar();
    }

    private void use() {
        char choice;
        while ((choice = readChoice())  != 'X') {
            switch (choice) {
                case '1' : getCatalogue(); break;
                case '2' : getPatron(); break;
                //case '3' : 
                //case '4' : 
            }
        }
    }
    
    public Library() {
        this.catalogue = new Catalogue(this);
        //this.patrons = 
    }

    public void addPatron (int id, String name) {
        this.patrons.add(new Patron(id, name));

    }

    public Patron getPatron(int id) {
        for (Patron p : this.patrons) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List getPatron() {
        return this.patrons;
    }

    public Patron setPatron () {
        System.out.println ("Adding a new patron.");
        
        System.out.print ("Enter a new ID: ");
        int inputID = In.nextInt();

        System.out.print ("Enter the patron's name: ");
        String inputName = In.nextLine();
        
        new Patron(inputID, inputName);
    }

    public Catalogue getCatalogue() {
        return this.catalogue;
    }
    
}