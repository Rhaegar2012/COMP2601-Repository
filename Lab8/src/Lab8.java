import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Lab8 {
	
	private static ArrayList<Customer> customers= new ArrayList<Customer>();

	private static final int FIRST_NAME_INDEX	=1;
	private static final int LAST_NAME_INDEX	=2;
	private static final int STREET_INDEX 		=3;
	private static final int CITY_INDEX 		=4;
	private static final int POSTAL_CODE_INDEX	=5;
	private static final int PHONE_INDEX		=6;
	private static final int EMAIL_INDEX		=7;
	

	public static void main(String[] args) {
		FileLoader.loadData("customers.txt");
		MainFrame mainFrame = new MainFrame(customers);
		mainFrame.displayFrame();
	
	}
	
	
	private static class FileLoader{
		static FileReader reader= null;
		static Scanner 	scanner= null;
		
		public static void loadData(final String fileName) {
			File customerFile = new File(fileName);
			if(!customerFile.exists()) 
			{
				System.out.println("File was not found");
				System.exit(-1);
			}
			try {
				reader = new FileReader(customerFile);
				scanner = new Scanner(reader);
				while (scanner.hasNext()) {
					String fileLine= scanner.nextLine();
					String [] lineDataArray = fileLine.split("\\|");
					createCustomerObject(lineDataArray);
				}
				
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		
		private static void createCustomerObject(String[] lineData) {
			String firstName 		= lineData[FIRST_NAME_INDEX];
			String lastName  		= lineData[LAST_NAME_INDEX];
			String streetAddress 	= lineData[STREET_INDEX];
			String city 			= lineData[CITY_INDEX];
			String postalCode 		= lineData[POSTAL_CODE_INDEX];
			String phone 			= lineData[PHONE_INDEX];
			String email 			= lineData[EMAIL_INDEX];
			Customer newCustomer = new Customer(firstName,lastName,streetAddress,city,postalCode,phone,email);
			customers.add(newCustomer);
		}
		
	}

}
