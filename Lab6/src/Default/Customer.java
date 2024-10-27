package Default;

public class Customer {
	private Account account;
	private String firstName;
	private String lastName;
	private String passcode;
	
	public Customer() {
		
	}
	
	public Customer(final String firstName, final String lastName, final String passcode) {
		this.firstName = firstName;
		this.lastName=lastName;
		this.passcode=passcode;
		
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(final Account account) {
		this.account = account;
	}
	
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	public void setPassword(final String password) {
		this.passcode=password;
	}
	
	@Override
	public String toString() {
		
		String customerInfo = String.format("Customer Name: %s Last Name: %s Account No: %s", firstName, lastName, account.getAccountNumber());
		return customerInfo;
	}
	
	
	
	

}
