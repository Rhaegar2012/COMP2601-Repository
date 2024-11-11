
/**
 * This class simulates a physical Media File
 * Author Jose Tellez
 * Version 1.0
 * */
public abstract class PhysicalMedia extends MusicMedia {
	
	/**
	 * Default Constructor
	 * */
	public PhysicalMedia() {
		super();
	}
	
	/**
	 * Class constructor 
	 * @param musicTitle: music title
	 * @param artis: artist name
	 * */
	public PhysicalMedia(String sku, String musicTitle, String artist,int year) {
		super(sku,musicTitle,artist,year);
		
	}

}