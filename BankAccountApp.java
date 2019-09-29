package Labs;

public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	BankAccount acc1 = new BankAccount("45567831", 1000.50);
	
	acc1.setName("Test Account");
	System.out.println(acc1.getName());
	
	acc1.deposit(1000);
	acc1.withdraw(30);
	acc1.accrue();
	System.out.println(acc1.toString());
	
	
	}

}

class BankAccount implements Interest{
	private static int id = 1000;
	private String accountNumber;
	private static final String routingNumber = "004540067";
	private String name;
	private String ssn;
	private double balance;
	
	public BankAccount(String SSN, double initDeposit) {
		System.out.println("New Account Created !");
		balance = initDeposit;
		this.ssn = SSN;
		id++;
		setAccountNumber();
	}

	private void setAccountNumber() {
		int random = (int) Math.random() * 10;
		
		accountNumber = (id +  "" + random + ssn.substring(0, 1));
		
		System.out.println("Your Account Number: " + accountNumber);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void withdraw(double amount) {
		if(balance >= amount) {
		System.out.println("Withdraw successful");
		balance -= amount; 
		showBalance();
		}
		else {
			System.out.println("Insufficient funds ");
			showBalance();
		}
	}
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposit successful");
		showBalance();
	}
	public void showBalance() {
		System.out.println("Current Balance: " + balance);
	}
	
	public void accrue() {
		balance = balance * (1 + rate/ 100);
		showBalance();
	}
	
	@Override
	public String toString() {
		return "[Name: " + name + " ] \n[Account Number: " + accountNumber
				+ " ]\n" + " [Routing Number: " + routingNumber + " ]\n" 
				+ " [Balance: " + balance;
	}
	
}
