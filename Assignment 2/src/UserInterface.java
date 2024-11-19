/**
 * User interface class
 * */
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

public class UserInterface {
	interface Callback<T,R> extends Function<T,R>{
		
	}
	private MusicController controller;
	private JFrame 			appFrame;
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private ArrayList<JTextField> textFields;
	
	//Constants
	private final static String ABOUT_MESSAGE 				="Assignment 2\n"+"Jose Tellez\n"+"A01415384";
	private final static String DELETE_MESSAGE 				= "Are you sure you want to delete this record?";
	private final static String SAVE_CHANGES_MESSAGE		="Are you sure you want to save changes to file?";
	private final static int 	  FRAME_RESIZE_RATIO 		=2;
	private final static int 	  FRAME_DIALOG_WIDTH		=400;
	private final static int 	  FRAME_DIALOG_HEIGHT		=400;
	private final static int 	  ENTRY_DIALOG_WIDTH        =600;
	private final static int 	  ENTRY_DIALOG_HEIGHT		=600;
	private final static int 	  DIALOG_NUMBER_OF_COLUMNS	=2;
	private final static int 	  DIALOG_NUMBER_OF_ROWS	    =2;
	private final static int 	  DIALOG_VERTICAL_GAP		=5;
	private final static int	  DIALOG_HORIZONTAL_GAP		=5;
	private final static String[] AUDIO_FILE_LABELS			= {"SKU","Title","Artist","Year","File Name","File Resolution"};
	private final static String[] COMPACT_DISK_LABELS   	= {"SKU","Title","Artist","Year","Number of Tracks"};
	private final static String[] VINYL_RECORD_LABELS   	= {"SKU","Title","Artist","Year","Number of Tracks","Size in Inches","Weight in Grams"};
	private final List<Callback<MusicMedia,?>> AUDIO_FILE_CALLBACKS;
	private final List<Callback<MusicMedia,?>> COMPACT_DISK_CALLBACKS;
	private final List<Callback<MusicMedia,?>> VINYL_RECORD_CALLBACKS;
	
	private static final int TOP_PADDING 				=5;
	private static final int BOTTOM_PADDING				=5;
	private static final int LEFT_PADDING				=5;
	private static final int RIGHT_PADDING				=5;
	private static final int TEXT_FIELD_WIDTH			=20;
	
	
	{
		AUDIO_FILE_CALLBACKS = new ArrayList<>();
		AUDIO_FILE_CALLBACKS.add(MusicMedia::getSku);
		AUDIO_FILE_CALLBACKS.add(MusicMedia::getMusicTitle);
		AUDIO_FILE_CALLBACKS.add(MusicMedia::getArtist);
		AUDIO_FILE_CALLBACKS.add(MusicMedia::getYear);
		AUDIO_FILE_CALLBACKS.add(media-> {if(media instanceof AudioFile) {return ((AudioFile) media).getFileName();} return null;});
		AUDIO_FILE_CALLBACKS.add(media-> {if(media instanceof AudioFile) {return ((AudioFile) media).getFileResolution();}return null;});
		COMPACT_DISK_CALLBACKS= new ArrayList<>();
		COMPACT_DISK_CALLBACKS.add(MusicMedia:: getSku);
		COMPACT_DISK_CALLBACKS.add(MusicMedia::getMusicTitle);
		COMPACT_DISK_CALLBACKS.add(MusicMedia::getArtist);
		COMPACT_DISK_CALLBACKS.add(MusicMedia::getYear);
		COMPACT_DISK_CALLBACKS.add(media-> {if(media instanceof CompactDisk) {return ((CompactDisk) media).getNumberOfTracks();}return null;});
		
		
		VINYL_RECORD_CALLBACKS = new ArrayList<>();
		VINYL_RECORD_CALLBACKS.add(MusicMedia::getSku);
		VINYL_RECORD_CALLBACKS.add(MusicMedia::getMusicTitle);
		VINYL_RECORD_CALLBACKS.add(MusicMedia::getArtist);
		VINYL_RECORD_CALLBACKS.add(MusicMedia::getYear);
		VINYL_RECORD_CALLBACKS.add( media-> {if(media instanceof VinylRecord) { return ((VinylRecord) media).getNumberOfTracks();}return null;});
		VINYL_RECORD_CALLBACKS.add( media-> {if(media instanceof VinylRecord) { return ((VinylRecord) media).getSizeInInches();}return null;});
		VINYL_RECORD_CALLBACKS.add( media-> {if(media instanceof VinylRecord) { return ((VinylRecord) media).getWeightInGrams();}return null;});
											
	}
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
		JMenuItem saveData = new JMenuItem("Save Data");
		JMenuItem exit = new JMenuItem("Exit");
		
		JMenu sortingMenu = new JMenu("Sort");
		JMenuItem sortByType = new JMenuItem("By Type");
		JMenuItem sortByArtist= new JMenuItem("By Artist");
		JMenuItem sortByTitle = new JMenuItem("By Title");
		JMenuItem sortByYear = new JMenuItem("By Year");
		
		JMenu 	  helpMenu = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		
		
		saveData.addActionListener(e->displaySaveDialog());
		saveData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
		exit.addActionListener(e->appFrame.dispose());
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
		fileMenu.add(saveData);
		fileMenu.add(exit);
		
		
		sortByType.addActionListener(e->displaySortedLibrary("Type"));
		sortByArtist.addActionListener(e->displaySortedLibrary("Artist"));
		sortByTitle.addActionListener(e->displaySortedLibrary("Title"));
		sortByYear.addActionListener(e->displaySortedLibrary("Year"));
		sortingMenu.add(sortByType);
		sortingMenu.add(sortByArtist);
		sortingMenu.add(sortByTitle);
		sortingMenu.add(sortByYear);
	
		about.addActionListener(e->{JOptionPane.showMessageDialog(null,ABOUT_MESSAGE);});
		helpMenu.add(about);
		
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
		dialogList.addListSelectionListener(e->{if(!e.getValueIsAdjusting()) {
			displaySelectedLibraryEntry(dialogList.getSelectedValue().split("\\|")[0].trim());}});
	
		dialog.add(scrollPane,BorderLayout.CENTER);
		dialog.add(buttonPanel,BorderLayout.SOUTH);
		dialog.setVisible(true);

	}
	
	private void displaySelectedLibraryEntry(String selectedSku) 
	{
		MusicMedia selectedFile= controller.readMusicRecord(selectedSku);
		if(selectedFile == null){
			throw new NullPointerException("Media File not found");
		}
		JDialog dataPanel = setUpInputPanel(selectedFile);
		for(Component component:appFrame.getContentPane().getComponents()) {
			if(component instanceof JPanel) {
				appFrame.remove(component);
				appFrame.revalidate();
				appFrame.repaint();
				
			}
		}
		dataPanel.setVisible(true);
		
	}
	
	private JDialog setUpInputPanel(MusicMedia mediaEntry) 
	{
		JDialog dialog = new JDialog ();
		dialog.setSize(ENTRY_DIALOG_WIDTH,ENTRY_DIALOG_HEIGHT);
		dialog.setLayout(new GridLayout(DIALOG_NUMBER_OF_ROWS,DIALOG_NUMBER_OF_COLUMNS,DIALOG_VERTICAL_GAP,DIALOG_HORIZONTAL_GAP));
		
		JPanel entriesPanel = new JPanel(new GridBagLayout());
		JPanel buttonPanel  = new JPanel(new GridBagLayout());
		
		
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.insets = new Insets(TOP_PADDING,BOTTOM_PADDING,LEFT_PADDING,RIGHT_PADDING);
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		textFields = new ArrayList<JTextField>();
		if(mediaEntry instanceof AudioFile) 
		{
			dialog.setTitle("Showing Audio File");
			for(int i=0;i<AUDIO_FILE_LABELS.length;i++) 
			{
				gridConstraints.gridx=0;
				gridConstraints.gridy=i;
				entriesPanel.add(new JLabel(AUDIO_FILE_LABELS[i]),gridConstraints);
			}
			int i=0;
			for(Callback<MusicMedia,?> getter:AUDIO_FILE_CALLBACKS) 
			{
				gridConstraints.gridx=1;
				gridConstraints.weightx=3.0;
				gridConstraints.gridy=i;
				JTextField textField = new JTextField(TEXT_FIELD_WIDTH);
				Object result = getter.apply(mediaEntry);
				textField.setText(result.toString());
				entriesPanel.add(textField,gridConstraints);
				textFields.add(textField);
				i++;
				
			}
		}
		else if(mediaEntry instanceof CompactDisk) 
		{
			for(int i=0;i<COMPACT_DISK_LABELS.length;i++) 
			{
				gridConstraints.gridx=0;
				gridConstraints.gridy=i;
				entriesPanel.add(new JLabel(COMPACT_DISK_LABELS[i]),gridConstraints);
			}
			int i=0;
			for(Callback<MusicMedia,?> getter:COMPACT_DISK_CALLBACKS) 
			{
				gridConstraints.gridx=1;
				gridConstraints.weightx=3.0;
				gridConstraints.gridy=i;
				JTextField textField = new JTextField(TEXT_FIELD_WIDTH);
				Object result = getter.apply(mediaEntry);
				textField.setText(result.toString());
				entriesPanel.add(textField,gridConstraints);
				textFields.add(textField);
				i++;
				
			}
		}
		else if (mediaEntry instanceof VinylRecord) 
		{
			for(int i=0;i<VINYL_RECORD_LABELS.length;i++) 
			{
				gridConstraints.gridx=0;
				gridConstraints.gridy=i;
				entriesPanel.add(new JLabel(VINYL_RECORD_LABELS[i]),gridConstraints);
			}
			int i=0;
			for(Callback<MusicMedia,?> getter:VINYL_RECORD_CALLBACKS) 
			{
				gridConstraints.gridx=1;
				gridConstraints.weightx=3.0;
				gridConstraints.gridy=i;
				JTextField textField = new JTextField(TEXT_FIELD_WIDTH);
				Object result = getter.apply(mediaEntry);
				textField.setText(result.toString());
				entriesPanel.add(textField,gridConstraints);
				textFields.add(textField);
				i++;
				
			}
		}
		JButton clearButton = new JButton("CLEAR");
		JButton saveButton = new JButton("SAVE");
		JButton deleteButton = new JButton("DELETE");
		JButton cancelButton = new JButton("CANCEL");
		
		clearButton.addActionListener	(e->clearEntries(entriesPanel));
	    saveButton.addActionListener	(e->getPanelData(entriesPanel));
	    deleteButton.addActionListener  (e->deleteRecordDialog(mediaEntry.getSku()));
	    cancelButton.addActionListener	(e->clearPanel(entriesPanel));
	    
	    gridConstraints.gridx=0;
	    gridConstraints.gridy=1;
	    buttonPanel.add(clearButton,gridConstraints);
	    
	    gridConstraints.gridx=2;
	    gridConstraints.gridy=1;
	    buttonPanel.add(saveButton,gridConstraints);
	    
	    gridConstraints.gridx=3;
	    gridConstraints.gridy=1;
	    buttonPanel.add(deleteButton,gridConstraints);
	    
	    
	    gridConstraints.gridx=4;
	    gridConstraints.gridy=1;
	    buttonPanel.add(cancelButton,gridConstraints);
	    
	    dialog.add(entriesPanel,BorderLayout.CENTER);
	    dialog.add(buttonPanel,BorderLayout.SOUTH);

		return dialog;
	}
	
	private void getPanelData(JPanel panel) {
		ArrayList<JTextField> panelData= new ArrayList<JTextField>();
		for(Component component:panel.getComponents()) {
			if(component instanceof JTextField) {
				JTextField textField=(JTextField) component;
				panelData.add(textField);
			}
		}
		controller.updateMusicRecord(panelData);
	}
	
	private void clearEntries(JPanel panel) {
		if(panel == null) {
			throw new IllegalArgumentException("Null panel");
		}
		for(Component component : panel.getComponents()) {
			if(component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}
	}
	
	private void clearPanel(JPanel panel) {
		if(panel == null) {
			throw new IllegalArgumentException("Null Panel");
		}
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
	
	
	private void displaySaveDialog() {
		JDialog  dialogPanel    = new JDialog ();
		dialogPanel.setSize(FRAME_DIALOG_WIDTH,FRAME_DIALOG_HEIGHT/2);
		JLabel messageLabel = new JLabel(SAVE_CHANGES_MESSAGE);
		dialogPanel.add(messageLabel,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton okButton = new JButton("OK");
		okButton.addActionListener(e->{controller.updateMusicLibrary();
									   dialogPanel.dispose();});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e->dialogPanel.dispose());
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		dialogPanel.add(buttonPanel,BorderLayout.SOUTH);
		dialogPanel.setVisible(true);
		
	}
	
	
	private void deleteRecordDialog(String mediaSKU) {
		JDialog dialogPanel  = new JDialog();
		dialogPanel.setSize(FRAME_DIALOG_WIDTH,FRAME_DIALOG_HEIGHT/2);
		JLabel  messageLabel = new JLabel(DELETE_MESSAGE);
		dialogPanel.add(messageLabel,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(e->{controller.deleteMusicRecord(mediaSKU);
									   dialogPanel.dispose();});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e->dialogPanel.dispose());
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		dialogPanel.add(buttonPanel,BorderLayout.SOUTH);
		dialogPanel.setVisible(true);
	}
	
	

}
