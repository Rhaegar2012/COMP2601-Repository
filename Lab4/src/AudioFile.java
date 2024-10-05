/**
 * Class that models an audio file 
 * Author: Jose Tellez
 * Version 1.0
 * */
public class AudioFile extends DigitalMedia {
	
	private String fileName;
	private int    fileSize;
	private String filePath;
	
	/**
	 * Class constructor
	 * @param musicTitle: media music title
	 * @param artist: artist name
	 * @param fileName: file name 
	 * @param fileSize  file size in mb
	 * @throws IllegalArgumentException parameters fail string check
	 * */
	public AudioFile(final String musicTitle,final String artist, final String fileName, final int fileSize,final String filePath) {
		super(musicTitle, artist,filePath);
		// TODO Auto-generated constructor stub
		if(!isValidString(fileName)) {
			throw new IllegalArgumentException();
		}
		if(!isValidInteger(fileSize)) {
			throw new IllegalArgumentException(); 
		}
		this.fileName = fileName;
		this.fileSize = fileSize;
		
	}
	
	/**
	 * Returns media file name
	 * */
	
	public String getFileName() {
		return fileName;
	}
	
	
	/**
	 * Sets new file name
	 * @param fileName: new file name
	 * @throws IllegalArgumentException if fileName fails string check
	 * */
	public void setFileName(String fileName) {
		if(!isValidString(fileName)) {
			throw new IllegalArgumentException();
		}
		this.fileName = fileName;
	}
	
	/**
	 * Return files size
	 * */
	public int getFileSize() {
		return fileSize;
	}
	
	/**
	 * Sets new file size
	 * @param fileSize: new file size
	 * @throws IllegalArgumentException if fileSize fails string checks
	 * */
	public void setFileSize(int fileSize) {
		if(!isValidInteger(fileSize)) {
			throw new IllegalArgumentException();
		}
		this.fileSize = fileSize;
	}
	
	
	/**
	 * toString method , prints audio file information 
	 **/
	public String toString() {
		super.toString();
		System.out.println(String.format("File name: %s",this.fileName));
		System.out.println(String.format("File size: %d",this.fileSize));
		return null;
	}
	
	
	/**
	 * override of play method , plays Audio file message
	 * */
	public void play() {
		System.out.println("Audio file is playing");
		
	}
	
	
	

}
