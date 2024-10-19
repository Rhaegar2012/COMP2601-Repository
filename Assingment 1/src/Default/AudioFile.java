package Default;
/**
 * Class that models an audio file 
 * Author: Jose Tellez
 * Version 1.0
 * */
public class AudioFile extends DigitalMedia {
	
	private String fileName;
	private int    fileResolution;

	
	/**
	 * Default Constructor
	 * */
	public AudioFile(){
		
	}
	
	public AudioFile(final String sku,final String title, final String artist , final int year , final String fileName){
		super(sku,title,artist,year);
		if(!isValidString(fileName)) {
			throw new IllegalArgumentException();
		}
		this.fileName=fileName;
	}
	
	/**
	 * Class constructor
	 * @param musicTitle: media music title
	 * @param artist: artist name
	 * @param fileName: file name 
	 * @param fileResolution  file size in mb
	 * @throws IllegalArgumentException parameters fail string check
	 * */
	public AudioFile(final String sku,final String title, final String artist, final int year,final String fileName,final int fileResolution) {
		super(sku,title,artist,year);
		// TODO Auto-generated constructor stub
		if(!isValidString(fileName) || !isValidInteger(fileResolution)) {
			throw new IllegalArgumentException();
		}
		this.fileName = fileName;
		this.fileResolution = fileResolution;
		
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
	public int getFileResolution() {
		return fileResolution;
	}
	
	/**
	 * Sets new file size
	 * @param fileSize: new file size
	 * @throws IllegalArgumentException if fileSize fails string checks
	 * */
	public void setFileResolution(int fileSize) {
		if(!isValidInteger(fileSize)) {
			throw new IllegalArgumentException();
		}
		this.fileResolution = fileSize;
	}
	
	
	/**
	 * toString method , prints audio file information 
	 **/
	public String toString() {
		String superString 			=super.toString();
		String audioFileDescription =String.format("AudioFile[fileName=%s,fileResolution=%d]", fileName,fileResolution)+superString;
		System.out.println(audioFileDescription);
		return null;
	}
	
	
	/**
	 * override of play method , plays Audio file message
	 * */
	public void play() {
		System.out.println("Audio file is playing");
		
	}
	
	
	

}
