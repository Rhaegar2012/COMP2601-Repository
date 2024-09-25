/**
 * This class models a compact disc , inherits from music media 
 * Author: Jose Tellez
 * Version 1.0
 * */
public class CompactDisc extends MusicMedia {

	private int numberOfTracks; 
	
	
	/**
	 * Class constructor
	 * @param musicTitle: music title
	 * @param artist: artist
	 * @param numberOfTracks: number of tracks of CD
	 * @Throws IllegalArgumentException if numberOfTracks fails valid Integer test
	 * */
	public CompactDisc(final String musicTitle,final String artist,final int numberOfTracks) {
		super(musicTitle, artist);
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
    	super.toString();
    	System.out.println(String.format("Number of tracks %s",numberOfTracks));
    	return null;
    }
    
    
    /**
     *Concrete implementation for play method of parent class 
     */
     
	public void play() {
		
		System.out.println("Compact Disc is playing");
		
	}
	

}
