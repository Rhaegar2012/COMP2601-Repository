import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
public class MainFrame extends JFrame {
	
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	private ArrayList<Customer> customers;
	private CustomerDialog 		customerDialog;
	private JFrame 				frame;
	
	private final static String ABOUT_MESSAGE="Lab8\n"+"Jose Tellez\n"+"A01415384";
	private final static int 	FRAME_RESIZE_RATIO =2;
	private final static int    EMPLOYEE_DIALOG_WIDTH =400;
	private final static int 	EMPLOYEE_DIALOG_HEIGHT=400;
	
	public MainFrame(final ArrayList<Customer> customers) {
		if(!validateCustomerArray(customers)) {
			throw new IllegalArgumentException();
		}
		this.customers 		=customers;
		
	}
	
	private boolean validateCustomerArray(ArrayList<Customer> customers) 
	{
		if(customers == null || customers.size()==0) 
		{
			return false;
		}
		return true;
	}
	
	public void displayFrame() {
		setFrameProperties();
		setMenu();
		frame.setVisible(true);
		
	}

	private void setFrameProperties() {
		frame = new JFrame("Customers");
		frame.setSize(screenSize.width/FRAME_RESIZE_RATIO,screenSize.height/FRAME_RESIZE_RATIO);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
	}
	
	
	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu 	  fileMenu 		= new JMenu("File");
		JMenuItem customerItem 	= new JMenuItem("Customer");
		JMenuItem exitItem 		= new JMenuItem("Exit");
		fileMenu.add(customerItem);
		fileMenu.add(exitItem);
		customerItem.addActionListener(e->displayCustomerDialog(e));
		exitItem.addActionListener(e->{frame.dispose();});
		
		JMenu 	  helpMenu 	= new JMenu("Help");
		JMenuItem aboutItem = new JMenuItem("About");
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(e->{JOptionPane.showMessageDialog(null, ABOUT_MESSAGE);});
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		frame.setJMenuBar(menuBar);
	}
	
	
	
	private void displayCustomerDialog(final ActionEvent e){
		
		Customer selectedCustomer = getRandomCustomer();
		this.customerDialog = new CustomerDialog(this,selectedCustomer,EMPLOYEE_DIALOG_WIDTH,EMPLOYEE_DIALOG_HEIGHT);
		JPanel customerFrame = customerDialog.setUpCustomerPanel();
		frame.add(customerFrame);
		frame.setVisible(true);
	}
	
	private Customer getRandomCustomer() {
		
		Random random = new Random();
		return customers.get(random.nextInt(customers.size()));
		
	}
	
 
	

}
