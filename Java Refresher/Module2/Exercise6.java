public class Exercise6 {
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        a.showBalance();

        if (a.getBalance() >= 20) {
            System.out.println("Purchasing movie ticket.");
            a.withdraw(20);
            a.showBalance();
        }
        else {
            System.out.println("You need more money to buy a movie ticket."); 
        }
    }
}
