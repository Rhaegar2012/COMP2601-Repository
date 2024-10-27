package Default;
import java.util.HashMap;


public class Bank {
	
	private static  HashMap<String,Customer> theBank;
	public Bank() {
		theBank = new HashMap<String,Customer>();
	}
	
	public void addCustomer(final Customer customer) {
		theBank.put(customer.getAccount().getAccountNumber(),customer);
	}
	
	public void closeAccount(final  String accountNumber) {
		theBank.remove(accountNumber);
	}
	
	public static void displayAllCustomers() {
		for(String key: theBank.keySet()) {
			System.out.println(theBank.get(key).toString());
		}
	}

}
