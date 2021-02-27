public class Exercise7 {
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		
		account1.showBalance();
		account2.showBalance();
		
		account1.transfer(10.0, account2);
		
		account1.showBalance();
		account2.showBalance();
	}
}
