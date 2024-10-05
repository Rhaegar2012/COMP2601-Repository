/**
 * Abstract class simulating musical audio files 
 * Author: Jose Tellez
 * Version 1.0
 * */
public abstract class MusicMedia {
	
	protected String musicTitle;
	protected String artist;
	
	/**
	 * Default Constructor
	 */
	public MusicMedia() 
	{
		
	}
	/**
	 * Constructor
	 * @param musicTitle: music title
	 * @param artist : media artist
	 * @throws IllegalArgumentException if musicTitle or artist fail string test
	 * */
	
	public MusicMedia(final String musicTitle, final String artist) {
		if(!isValidString(musicTitle) || !isValidString(artist)) 
		{
			throw new IllegalArgumentException("Invalid arguments");
		}
		this.musicTitle = musicTitle;
		this.artist 	= artist;
	}
	
	/**
	 * Validates if a parameter is a valid string entry, returns false if the string is null or empty , true otherwise
	 * @param string: string to be evaluated
	 * */
	public boolean isValidString(final String string) {
		if(string == null) 
		{
			return false;
		}
		if(string.isBlank()) 
		{
			return false;
		}
		return true;
	}
	/**
	 * Validates if a parameter is a valid integer entry, returns false if the integer is null , true otherwise
	 * @param number: integer to be validated
	 * */
	public boolean isValidInteger(final Integer number) {
		
		if(number==null) 
		{
			return false;
		}
		return true;

	}

	/**
	 * Returns music title
	 * */
	public String getMusicTitle() {
		return musicTitle;
	}

	/**
	 * Sets music title
	 * @param musicTitle: new music title
	 * @throws IllegalArgumentException if musicTitle fails the string check
	 * */
	public void setMusicTitle(String musicTitle) {
		if(isValidString(musicTitle)) {
			throw new IllegalArgumentException();
		}
		this.musicTitle = musicTitle;
	}
	/**
	 * Returns music media artist
	 * */
	public String getArtist() {
		return artist;
	}

	
	
	/**
	 * Sets new artist
	 * @param artist: new artist
	 * @throws IllegalArgumentException if artist fails string check
	 * */
	public void setArtist(String artist) {
		if(isValidString(artist)) {
			throw new IllegalArgumentException();
		}
		this.artist = artist;
	}
	
	
	/**
	 * toString override
	 * */
	@Override
	public String toString() 
	{
		System.out.println("Media info");
		System.out.println(String.format("Music title: %s",musicTitle));
		System.out.println(String.format("Artist: %s",artist));
		return null;
	}
	
	
	public abstract void play();
	
	
	
	
	
	
	

}
