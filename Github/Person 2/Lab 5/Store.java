import java.util.*;

public class Store {

    public static void main(String[] args)  //main function called
    {
       new Store().use(); //creates a new store and calls the use() method.
    }
    private Product product;
    private CashRegister cashRegister;

    public Store() //constructor that creates the product and cashRegister.
    {
        product = new Product("Sticky tape", 200, 2.99);
        cashRegister = new CashRegister();
    }

    public void use()
    {
        char choice;
        while ((choice = readOption()) != 'x') //simple read 'pattern'
        {
            switch (choice) {
            case 's': sell(); break;
            case 'r': restock(); break;
            case 'v': viewStock(); break;
            case 'c': viewCash(); break;
            default: help(); break;
            }
        }
    }

    private void sell()
    {
        int numberOfItems = readNumber(); //reads the number of objects to sell from the user.
        double salePrice = product.sell(numberOfItems); //calls product.sell(), stores the profit to check that items were actually sold.
        if (salePrice != 0.0) //if the products were accepted and sold, add the cash to the cash register.
        {
            cashRegister.add(salePrice);
        } else { //if products are not sold. Inform the user.
            System.out.println("Not enough stock");
        }
    }

    private char readOption (){
        System.out.print("Choice (s/r/v/c/x): ");
        return In.nextChar();
    }

    private void restock() {
        product.restock(readNumber()); //calls product restock passing in the number read from user with readNumber()
    }
    private int readNumber () {
        System.out.print("Number: ");
        return In.nextInt();
    }

    private void viewStock() {
        System.out.println(product); //calls the product.toString()
    }

    private void viewCash() {
        System.out.println(cashRegister); //calls the cashRegister.toString()
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("x = exit");
    }
}
