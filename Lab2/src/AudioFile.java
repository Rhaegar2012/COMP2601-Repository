/**
 * Class that models an audio file 
 * Author: Jose Tellez
 * Version 1.0
 * */
public class AudioFile extends MusicMedia {
	
	private String fileName;
	private int fileSize;
	
	public AudioFile(final String musicTitle,final String artist, final String fileName, final int fileSize) {
		super(musicTitle, artist);
		// TODO Auto-generated constructor stub
		if(!isValidString(fileName)) {
			throw new IllegalArgumentException();
		}
		if(!isValidInteger(fileSize)) {
			throw new IllegalArgumentException(); 
		}
		
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		if(!isValidString(fileName)) {
			throw new IllegalArgumentException();
		}
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		if(!isValidInteger(fileSize)) {
			throw new IllegalArgumentException();
		}
		this.fileSize = fileSize;
	}
	
	
	public String toString() {
		super.toString();
		System.out.println(String.format("File name: %s",this.fileName));
		System.out.println(String.format("File size: %d",this.fileSize));
		return null;
	}
	
	
	public void play() {
		System.out.println("Audio file is playing");
		
	}
	
	
	

}
