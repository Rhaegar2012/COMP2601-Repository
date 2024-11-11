/**
 * User interface class
 * */

import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
public class UserInterface {
	
	private MusicController controller;
	private JFrame 			appFrame;
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//Constants
	private final static String ABOUT_MESSAGE ="Assignment 2\n"+"Jose Tellez\n"+"A01415384";
	private final static int 	FRAME_RESIZE_RATIO 	=2;
	private final static int 	FRAME_DIALOG_WIDTH	=400;
	private final static int 	FRAME_DIALOG_HEIGHT	=400;
	
	public UserInterface(final MusicLibrary musicLibrary) {
		if(musicLibrary == null || musicLibrary.getLibrarySize()<=0) {
			throw new IllegalArgumentException("Empty or null Music Library");
		}
		
		this.controller = new MusicController(musicLibrary);
		
	}
	
	
	public void displayFrame() {
		windowFrameSetUp();
		barMenuSetUp();
		appFrame.setVisible(true);
	}
	
	private void windowFrameSetUp() {
		
		appFrame = new JFrame("Assignment 2 Music Library viewer");
		appFrame.setSize(screenSize.width/FRAME_RESIZE_RATIO,screenSize.height/FRAME_RESIZE_RATIO);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setResizable(false);
	}
	
	private void barMenuSetUp() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		
		JMenu sortingMenu = new JMenu("Sort");
		JMenuItem sortByType = new JMenuItem("By Type");
		JMenuItem sortByArtist= new JMenuItem("By Artist");
		JMenuItem sortByTitle = new JMenuItem("By Title");
		JMenuItem sortByYear = new JMenuItem("By Year");
		
		sortByType.addActionListener(e->displaySortedLibrary("Type"));
		sortByArtist.addActionListener(e->displaySortedLibrary("Artist"));
		sortByTitle.addActionListener(e->displaySortedLibrary("Title"));
		sortByYear.addActionListener(e->displaySortedLibrary("Year"));
		
		sortingMenu.add(sortByType);
		sortingMenu.add(sortByArtist);
		sortingMenu.add(sortByTitle);
		sortingMenu.add(sortByYear);
	
		JMenu helpMenu = new JMenu("Help");
		
		menuBar.add(fileMenu);
		menuBar.add(sortingMenu);
		menuBar.add(helpMenu);
		
		appFrame.setJMenuBar(menuBar);
	}
	
	
	private void displaySortedLibrary(String sortColumn) {
		//call controller for the appropriate sorting type 
		//get a list of sorted values 
		//display JDialog panel with list and JScroll bar and okay button
		String[] listData = null;
		JDialog dialog = new JDialog();
		dialog.setTitle("Library sorted by "+sortColumn);
		dialog.setSize(FRAME_DIALOG_WIDTH, FRAME_DIALOG_HEIGHT);
		switch(sortColumn) 
		{
			case "Type":
				listData = controller.sortEntriesByType();
				break;
			case "Artist":
				listData = controller.sortEntriesByArtist();
				break;
			case "Title":
				listData = controller.sortEntriesByTitle();
				break;
			case "Year":
				listData = controller.sortEntriesByYear();
				break;	
		}
		JList<String> dialogList = new JList<>(listData);
		JScrollPane scrollPane = new JScrollPane(dialogList);
		//Panel button 
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton okButton = new JButton("OK");
		buttonPanel.add(okButton);
		okButton.addActionListener(e->dialog.dispose());
		
		dialog.add(scrollPane,BorderLayout.CENTER);
		dialog.add(buttonPanel,BorderLayout.SOUTH);
		dialog.setVisible(true);

	}

}
