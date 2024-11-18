
/**
 * Abstract class simulating musical audio files 
 * Author: Jose Tellez
 * Version 1.0
 * */
public abstract class MusicMedia {
	
	
	private     String artist;
	private     String sku;
	private     String title;
	private   	int    year;
	//Constants
	public static final int CURRENT_YEAR =2024;
	public static final int FIRST_YEAR   =1860;
	
	
	/**
	 * Default Constructor
	 */
	public MusicMedia() 
	{
		
	}
	
	public MusicMedia(final String sku, final String title, final String artist){
		if(!isValidString(sku)|| !isValidString(title)||!isValidString(artist)) {
			throw new IllegalArgumentException("Invalid arguments");
		}
		this.sku	=sku;
		this.title	=title;
		this.artist =artist;
		
		
	}
	/**
	 * Constructor
	 * @param musicTitle: music title
	 * @param artist : media artist
	 * @param year: year of publication
	 * @throws IllegalArgumentException if musicTitle or artist or year fail string test
	 * */
	
	public MusicMedia(final String sku, final String musicTitle, final String artist,final int year) {
		if(!isValidString(musicTitle) || !isValidString(artist)|| !isValidInteger(year)||!isValidString(sku)) 
		{
			throw new IllegalArgumentException("Invalid arguments");
		}
		this.sku		= sku;
		this.title		= musicTitle;
		this.artist 	= artist;
		this.year 		= year;
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
		return title;
	}

	/**
	 * Sets music title
	 * @param musicTitle: new music title
	 * @throws IllegalArgumentException if musicTitle fails the string check
	 * */
	public void setMusicTitle(String musicTitle) {
		if(!isValidString(musicTitle)) {
			throw new IllegalArgumentException();
		}
		this.title = musicTitle;
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
		if(!isValidString(artist)) {
			throw new IllegalArgumentException();
		}
		this.artist = artist;
	}
	
	
	public String getSku(){
		return this.sku;
	}
	
	public void setSku(final String sku){
		if(!isValidString(sku)) 
		{
			throw new IllegalArgumentException();
		}
		this.sku=sku;
		
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(final int year) {
		if(!isValidInteger(year)) 
		{
			throw new IllegalArgumentException();
		}
		this.year=year;
		
	}
	
	/**
	 * toString override
	 * */
	@Override
	public String toString() 
	{
		String mediaString = String.format("%s | %s | %s | %d", sku,artist,title,year);
		return mediaString;
	}
	
	
	public abstract void play();
	
	
	
	
	
	
	

}
