import java.util.ArrayList;
import java.util.List;

public class Library {
    private Catalogue catalogue = new Catalogue();
    private List<Patron> patrons = new ArrayList<Patron>();
    // write your solution below

    public static void main(String[] args) {
        new Library().use();
    }
    
    private void use() {
        char choice;
        while ((choice = readChoice())  != 'X') {
            switch (choice) {
                case '1' : useCatalogue(); break;
                case '2' : getPatron(); break;
                case '3' : getFavourite(); break;
                case '4' : useAdmin(); break;
            }
        }
        
    }
    
    private char readChoice() {
        System.out.println ("Welcome to the Library! Please make a selection from the menu:");
        System.out.println ("1. Explore the catalogue.");
        System.out.println ("2. View your patron record.");
        System.out.println ("3. Show you favourite books.");
        System.out.println ("4. Enter Admin Mode.");
        System.out.println ("X. Exit the system.");
        System.out.print   ("Enter a choice: ");

        char c = In.nextChar();
        if ((c!='1')&&(c!='2')&&(c!='3')&&(c!='4')&&(c!='X')) {
            System.out.println("Please enter a number between 1 and 4, or press X to exit.");
        }
        return c;
    }
    
    private void getPatron() {
        System.out.println();
        System.out.print("Enter a patron ID: ");
        int i = In.nextInt();
        boolean found = false;
        for (Patron patron : patrons) {
            if (i == patron.getId()) {
                found = true;
                System.out.println(patron.getId()+" "+patron.getName());
                System.out.println("Books currently borrowed by "+patron.getName()+":");
                patron.listCurrentlyBorrowed();
                System.out.println(patron.getName()+"'s borrowing history:");
                patron.listBorrowingHistory();
            }
        }
        if (found == false) {
            System.out.println("That patron does not exist.");
        }
        System.out.println();
    }

    private void getFavourite() {
        System.out.println();
        System.out.print("Enter a patron ID: ");
        Patron patron = patron(In.nextInt());
        System.out.println(patron.getName()+"'s favourite books are:");
        patron.favoriteBooks();
        System.out.println();
    }
    
    private void useCatalogue() {
        char choice;
        while ((choice = readCatalogue()) !='R') {
            switch (choice) {
                case '1' : catalogue.getAllBooks(); break;
                case '2' : catalogue.getAvalableBooks(); break;
                case '3' : catalogue.getAllGenre(); break;
                case '4' : catalogue.displayAllBooksInGenre(); break;
                case '5' : catalogue.getAllAuthor(); break;
                case '6' : catalogue.getAllBooksInAuthor(); break;
                case '7' : borrowBook(); break;
                case '8' : returnBook(); break;
                case '9' : holdBook(); break;
            }
        }
    }

    private char readCatalogue() {
        System.out.println("Welcome to the Catalogue! Please make a selection from the menu:");
        System.out.println("1. Display all books.");
        System.out.println("2. Display all available books.");
        System.out.println("3. Display all genres.");
        System.out.println("4. Display books in a genre.");
        System.out.println("5. Display all authors.");
        System.out.println("6. Display all books by an author.");
        System.out.println("7. Borrow a book.");
        System.out.println("8. Return a book.");
        System.out.println("9. Place a hold.");
        System.out.println("R. Return to previous menu.");
        System.out.print("Enter a choice: ");
        
        char c = In.nextChar();
        if ((c!='1')&&(c!='2')&&(c!='3')&&(c!='4')&&(c!='5')&&(c!='6')&&(c!='7')&&(c!='8')&&(c!='9')&&(c!='R')) {
            System.out.println("Please enter a number between 1 and 9 or press R to return to the previous menu.");
        }
        return c;
    }

    private void borrowBook() {
        System.out.println();
        System.out.print("Enter a valid patron ID: ");
        int i = In.nextInt();
        boolean found = false;
        for (Patron patron : patrons) {
            if (i == patron.getId()) {
                found = true;
                System.out.print("Enter the title of the book you wish to borrow: ");
                Book book = catalogue.getBook(In.nextLine());
                if (catalogue.checkbooksOnShelf(book) == true && book.isAvalable(patron) == true) {
                    catalogue.borrowBook(book);
                    patron.borrowBook(book);
                    book.removeHold(patron);

                    System.out.println("Book loaned.");
                }
                else {
                    System.out.println("That book is not available or doesn't exist.");
                } 
            }
        }
        if (found == false) {
            System.out.println("That patron does not exist.");
        }
        System.out.println();
    }

    private void returnBook() {
        System.out.println();
        System.out.print("Enter a valid patron ID: ");
        int i = In.nextInt();
        boolean found = false;
        for (Patron patron : patrons) {
            if (i == patron.getId()) {
                found = true;
                System.out.println(patron.getName()+" has the following books:");
                System.out.println("Books currently borrowed by "+patron.getName()+":");
                patron.listCurrentlyBorrowed();
                System.out.print("Enter the title of the book you wish to return: ");
                String inputTitle = In.nextLine();
                Book returnedBook = catalogue.getBook(inputTitle);
                catalogue.returnBook(returnedBook);
                patron.returnBook(returnedBook);
                System.out.println(inputTitle+" has been returned.");
            }
        }
        if (found == false) {
            System.out.println("That patron does not exist.");
        }
        System.out.println();
    }

    private void holdBook() {
        System.out.println();
        System.out.print("Enter a patron ID: ");
        Patron patron = patron(In.nextInt());
        catalogue.holdBook(patron);
    }
         
    private void useAdmin() {
        char choice;
        while ((choice = readAdmin()) !='R') {
            switch (choice) {
                case '1' : addPatron(); break;
                case '2' : removePatron(); break;
                case '3' : catalogue.addBook(); break;
                case '4' : catalogue.removeBook(); break;
            }
        }
    }
    
    private char readAdmin() {
        System.out.println ("Welcome to the administration menu:");
        System.out.println ("1. Add a patron.");
        System.out.println ("2. Remove a patron.");
        System.out.println ("3. Add a book to the catalogue.");
        System.out.println ("4. Remove a book from the catalogue.");
        System.out.println ("R. Return to the previous menu.");
        System.out.print   ("Enter a choice: ");

        char c = In.nextChar();
        if ((c!='1')&&(c!='2')&&(c!='3')&&(c!='4')&&(c!='R')) {
            System.out.println("Please enter a number between 1 and 4 or press R to return to the previous menu.");
        }
        return c;
    }

    private void addPatron () {
        System.out.println();
        System.out.println ("Adding a new patron.");
        System.out.print ("Enter a new ID: ");
        int inputID = In.nextInt();
        
        System.out.print ("Enter the patron's name: ");
        String inputName = In.nextLine();
        
        patrons.add(new Patron(inputID, inputName));

        System.out.println ("Patron added.");
        System.out.println();
    }

    private void removePatron() {
        System.out.println();
        System.out.println("Removing a patron.");
        System.out.print("Enter a patron ID: ");
        Patron patron = patron(In.nextInt());
        if (patron != null) {
            patrons.remove(patron);
            System.out.println("Patron removed."); 
        }
        else {
            System.out.println("That patron does not exist.");
        }
        System.out.println();
    }

    private Patron patron(int id) {
        for (Patron patron : patrons) {
            if (patron.getId()==id) {
                return patron;
            }
        }
        return null;
    }

}