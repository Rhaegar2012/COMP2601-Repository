/**
 * Abstract class simulating musical audio files 
 * Author: Jose Tellez
 * Version 1.0
 * */
public abstract class MusicMedia {
	
	private String musicTitle;
	private String artist;
	
	public MusicMedia(final String musicTitle, final String artist) {
		if(!isValidString(musicTitle) || !isValidString(artist)) 
		{
			throw new IllegalArgumentException("Invalid arguments");
		}
		this.musicTitle = musicTitle;
		this.artist 	= artist;
	}
	
	
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
	
	public boolean isValidInteger(final Integer number) {
		
		if(number==null) 
		{
			return false;
		}
		return true;

	}


	public String getMusicTitle() {
		return musicTitle;
	}


	public void setMusicTitle(String musicTitle) {
		if(isValidString(musicTitle)) {
			throw new IllegalArgumentException();
		}
		this.musicTitle = musicTitle;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		if(isValidString(musicTitle)) {
			throw new IllegalArgumentException();
		}
		this.artist = artist;
	}
	
	
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
