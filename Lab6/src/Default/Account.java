package Default;

public class Account {
	
	private String accountNumber;
	private double balance;
	private boolean isActive;
	
	public Account() {
		
	}
	
	public Account(final String accountNumber,final double balance) {
		this.accountNumber=accountNumber;
		this.balance	  =balance;
		
	}
	
	
	public void addToBalance(final double amount) {
		this.balance+=amount;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(final boolean active) {
		this.isActive = active;
	}
	
	
	public void setBalance(final double balance) {
		this.balance=balance;
	}
	
	public void subtractFromBalance(final double amount) {
		this.balance-=amount;
	}
	
	

}
