package Default;
/**
 * This class models a digital media file 
 * Author: Jose Tellez
 * Version 1.0
 * */
public abstract class DigitalMedia extends MusicMedia implements FileProcessor {

	private String filePath;
	
	/**
	 * Default Constructor
	 * */
	public DigitalMedia() 
	{
		super();
	}
	
	public DigitalMedia(final String sku, final String musicTitle, final String artist, final int year) 
	{
		super(sku,musicTitle,artist,year);
	}
	
	/**
	 * Constructor
	 * @param musicTitle: music title 
	 * @param artist: 	 artist name 
	 * @param filePath:  filePath
	 * @throws IllegalArgument Exception if the file path is not valid 
	 * */
	public DigitalMedia(final String sku,final String musicTitle,final String artist,final String filePath,int year) {
		super(sku,musicTitle, artist,year);
		if(!isValidString(filePath)) 
		{
			throw new IllegalArgumentException();
		}
		this.filePath = filePath;
	}
	
	/**
	 * ToString extend 
	 * */
    public String toString() {
    	super.toString();
    	System.out.println(String.format("Filepath:  %s",filePath));
    	return null;
    }
    
    /**
     * Save method, stores a digital file 
     * @param filePath: file path for saving
     * @throws IllegalArgumentException: if file path is not valid
     * */
    public void save(final String filePath){
    	if(!isValidString(filePath)) {
    		throw new IllegalArgumentException();
    	}
    	this.filePath = filePath;
    	System.out.println("Saving de audiofile");
    	
    }
    
    
    /**
     * Simulates deleting a file 
     * @param filePath: file path in machine
     * */
    public void delete(final String filePath) {
    	System.out.println("Deleting the audio file "); 
    	
    }
	

}

