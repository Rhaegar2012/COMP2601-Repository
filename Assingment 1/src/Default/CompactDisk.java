package Default;
/**
 * This class models a compact disc , inherits from music media 
 * Author: Jose Tellez
 * Version 1.0
 * */
public class CompactDisk extends PhysicalMedia {

	private int numberOfTracks; 
	
	/**
	 * Default Constructor
	 * */
	public CompactDisk() {
		
	}
	/**
	 * Class constructor
	 * @param musicTitle: music title
	 * @param artist: artist
	 * @param numberOfTracks: number of tracks of CD
	 * @Throws IllegalArgumentException if numberOfTracks fails valid Integer test
	 * */
	public CompactDisk(final String sku,final String musicTitle,final String artist,final int year,final int numberOfTracks) {
		super(sku,musicTitle, artist,year);
		if(!isValidInteger(numberOfTracks)) {
			throw new IllegalArgumentException();
		}
		this.numberOfTracks = numberOfTracks;
	
	}
	
	
	/**
	 * Returns number of tracks
	 * */
	public int getNumberOfTracks() {
		return numberOfTracks;
	}


	/**
	 * Sets new number of tracks 
	 * @param numberOfTracks : new number of tracks
	 * @throws illegalArgumentException if number of tracks fail integer check
	 * */
	public void setNumberOfTracks(int numberOfTracks) {
		if(!isValidInteger(numberOfTracks)) {
			throw new IllegalArgumentException();
		}
		this.numberOfTracks = numberOfTracks;
	}
	
	/**
	 * ToString extend 
	 * */
    public String toString() {
    	String superString		=super.toString();
    	String compactDiskString= String.format("Number of tracks %s",numberOfTracks)+superString;
    	System.out.println(compactDiskString);
    	return null;
    }
    
    
    /**
     *Concrete implementation for play method of parent class 
     */
     
	public void play() {

		System.out.println("Compact Disc is playing");
		
	}
	

}
