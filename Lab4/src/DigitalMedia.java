
public abstract class DigitalMedia extends MusicMedia implements FileProcessor {

	private String filePath;
	
	public DigitalMedia() 
	{
		super();
	}
	public DigitalMedia(final String musicTitle,final String artist,final String filePath) {
		super(musicTitle, artist);
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
    
    
    public void save(final String filePath){
    	if(!isValidString(filePath)) {
    		throw new IllegalArgumentException();
    	}
    	this.filePath = filePath;
    	System.out.println("Saving de audiofile");
    	
    }
    
    public void delete(final String filePath) {
    	System.out.println("Deleting the audio file "); 
    	
    }
	

}
