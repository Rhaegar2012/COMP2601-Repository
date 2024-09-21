/**
 * This class models a compact disc , inherits from music media 
 * */
public class CompactDisc extends MusicMedia {

	private int numberOfTracks; 
	
	public CompactDisc(final String musicTitle,final String artist,final int numberOfTracks) {
		super(musicTitle, artist);
		if(!isValidInteger(numberOfTracks)) {
			throw new IllegalArgumentException();
		}
		this.numberOfTracks = numberOfTracks;
	
	}
	
	
	public int getNumberOfTracks() {
		return numberOfTracks;
	}


	
	public void setNumberOfTracks(int numberOfTracks) {
		if(!isValidInteger(numberOfTracks)) {
			throw new IllegalArgumentException();
		}
		this.numberOfTracks = numberOfTracks;
	}

    public String toString() {
    	super.toString();
    	System.out.println(String.format("Number of tracks %s",numberOfTracks));
    	return null;
    }
    
	public void play() {
		
		System.out.println("Compact Disc is playing");
		
	}
	

}
