import javax.swing.*;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

public class CustomerDialog extends JDialog {
	
	private int panelWidth;
	private int panelHeight;
	private JDialog customerPanel;
	private JFrame frame;
	private Customer customer;
	private HashMap<String,String> customerDataMap;
	
	private static final String[] labels = {"ID","First Name","Last Name","Street","City","Postal Code","Phone","Email"};
	
	private static final int TOP_PADDING		=5;
	private static final int BOTTOM_PADDING		=5;
	private static final int LEFT_PADDING		=5;
	private static final int RIGHT_PADDING		=5;
	private static final int TEXT_FIELD_WIDTH	=20;
	
	public CustomerDialog(final JFrame frame,final Customer customer,final int panelWidth,int panelHeight) {
		
		if(frame == null || panelWidth<=0||panelHeight<=0 || customer == null) {
			throw new IllegalArgumentException();
		}
		customerPanel 		 = new JDialog(frame,null,true);
		this.panelWidth		 = panelWidth;
		this.panelHeight	 = panelHeight;
		this.customer 		 = customer;
		this.customerDataMap = customer.getCustomerDataMap();
		
	}
	
	public JPanel setUpCustomerPanel(){
		customerPanel.setSize(panelWidth,panelHeight);
		JPanel panel 			= new JPanel ( new GridBagLayout());
		GridBagConstraints gbc 	= new GridBagConstraints();
		gbc.insets = new Insets(TOP_PADDING,BOTTOM_PADDING,LEFT_PADDING,RIGHT_PADDING);
		
		for (int i=0; i<labels.length;i++) {
			gbc.gridx=0;
			gbc.gridy=i;
			panel.add(new JLabel(labels[i]),gbc);			
		}
		
		for (int i =1; i<labels.length;i++) {
			gbc.gridx=1;
			gbc.gridy=i;
			JTextField textField = new JTextField(TEXT_FIELD_WIDTH);
			textField.setText(customerDataMap.get(labels[i]));
			panel.add(textField,gbc);
		}
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(e->panel.setVisible(false));
		panel.add(okButton);
		okButton.setBounds(50,100,100,30);
		
		
		return panel;	
	}
	

}
