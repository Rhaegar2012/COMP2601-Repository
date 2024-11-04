import java.util.HashMap;

public class Customer {
	
	private String 	 firstName;
	private String   lastName;
	private String 	 streetAddress;
	private String 	 city;
	private String 	 postalCode;
	private String   phoneNumber;
	private String 	 email;
	
	private HashMap<String,String> customerDataMap = new HashMap <String,String>();
	
	public Customer(final String firstName, final String lastName, 
					final String streetAddress, final String city, 
					final String postalCode, final String phoneNumber , final String email) 
	{
		if(!isValidStringValue(firstName)||
		   !isValidStringValue(lastName) ||
		   !isValidStringValue(streetAddress)||
		   !isValidStringValue(city)||
		   !isValidStringValue(postalCode)||
		   !isValidStringValue(email)||
		   !isValidStringValue(phoneNumber)) {
			throw new IllegalArgumentException();
		}
		this.firstName 		= firstName;
		this.lastName 		= lastName;
		this.streetAddress 	= streetAddress;
		this.city 			= city;
		this.postalCode 	= postalCode;
		this.phoneNumber	= phoneNumber;
		this.email			= email;
		setCustomerDataMap();
	}
	
	
	private boolean isValidStringValue(final String stringValue) {
		if(stringValue.isBlank() || stringValue.isEmpty()) 
		{
			return false;
		}
		return true;		
	}
	
	private void setCustomerDataMap() {
		customerDataMap.put("First Name",this.firstName);
		customerDataMap.put("Last Name", this.lastName);
		customerDataMap.put("Street"    , this.streetAddress);
		customerDataMap.put("City", this.city);
		customerDataMap.put("Postal Code", this.postalCode);
		customerDataMap.put("Phone", String.valueOf(this.phoneNumber));
		customerDataMap.put("Email",this.email);
		
	}
	
	//Getters and Setters 
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getStreetAddress() {
		return this.streetAddress;
	}
	public String getCity() {
		return this.city;
	}
	public String getPostalCode() {
		return this.postalCode;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getEmail() {
		return this.email;
	}
	
	public HashMap<String, String> getCustomerDataMap(){
		return this.customerDataMap;
	}
	
	public void setFirstName(final String firstName) {
		if(!isValidStringValue(firstName)) {
			throw new IllegalArgumentException();
		}
		this.firstName = firstName;
	}
	
	public void setLastName(final String lastName) {
		if(!isValidStringValue(lastName)){
			throw new IllegalArgumentException();
		}
		this.lastName = lastName;
	}
	
	public void setStreetAddress(final String streetAddress) {
		if(!isValidStringValue(streetAddress)) {
			throw new IllegalArgumentException();
		}
		this.streetAddress=streetAddress;
	}
	
	public void setCity(final String city) {
		if(!isValidStringValue(city)) {
			throw new IllegalArgumentException();
		}
		this.city=city;
	}
	public void setPostalCode(final String postalCode) {
		if(!isValidStringValue(postalCode)) {
			throw new IllegalArgumentException();
		}
		this.postalCode=postalCode;
	}
	
	public void setPhoneNumber (final String phoneNumber) {
		if(!isValidStringValue(phoneNumber)) {
			throw new IllegalArgumentException();
		}
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmail (final String email) {
		if(!isValidStringValue(email)) {
			throw new IllegalArgumentException();
		}
		this.email = email;
	}
	
}
