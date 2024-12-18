
/**
 * This class selects and display a specific music media library based on file type 
 * Author: Jose Tellez 
 * Version 1.0; 
 * */
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MusicLibrary {
	
	private HashMap<String,MusicMedia> library;
	private static final String SOURCE_FILE_PATH="music_data.txt";
	public  static MusicLibrary musicLibrary = new MusicLibrary();
	
	/**
	 * Default Constructor
	 * */
	public MusicLibrary() {
		library= new HashMap<String,MusicMedia>();
	}
	
	
	
	/**
	 * Adds a music media file to the library 
	 * @param selection: music media file
	 * */
	public void addMusic(final MusicMedia selection) {
		if(selection == null) {
			throw new NullPointerException();
		}
		library.put(selection.getSku(), selection);
	}
	
	public void removeMusic(final String removeSKU) {
		if(removeSKU == null || removeSKU.isBlank()) {
			throw new IllegalArgumentException();
		}
		library.remove(removeSKU);
	}
	
	public int getLibrarySize() {
		return library.size();
	}
	
	public MusicMedia getMusicMediaFile(final String fileSKU) {
		if(fileSKU == null || fileSKU.isBlank()) {
			throw new IllegalArgumentException();
		}
		MusicMedia mediaFile = library.get(fileSKU);
		return mediaFile;
	}
	
	public void setMusicMediaFile(final String fileSKU,final MusicMedia updatedFile) {
		if(fileSKU == null || fileSKU.isBlank()) {
			throw new IllegalArgumentException();
		}
		if(updatedFile == null) {
			throw new NullPointerException();
		}
		library.put(fileSKU,updatedFile);
	}
	
	public void writeLibraryToFile() {
		try(BufferedWriter writer= new BufferedWriter(new FileWriter(SOURCE_FILE_PATH))){
			for(Map.Entry<String, MusicMedia>entry:library.entrySet()) {
				writer.write(entry.getValue().toString());
				writer.newLine();
			}}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Returns and unsorted string array 
	 * */
	public ArrayList<MusicMedia> getLibraryEntries() {
		int i=0;
		ArrayList<MusicMedia> musicEntries = new ArrayList<MusicMedia>();
		for(String key: library.keySet()) {
			MusicMedia media = library.get(key);
			musicEntries.add(media);
			
		}
		return musicEntries;
	}
	
	
	/**
	 * Overload of displayLibrary, shows a specific subsection of the library
	 * @param mediaLibrary, filtered media library
	 * */
	private void displayLibrary(final Map<String,MusicMedia> mediaLibrary) 
	{
		if(mediaLibrary == null) {
			throw new NullPointerException();
		}
		for(String key: mediaLibrary.keySet()) {
			MusicMedia media = mediaLibrary.get(key);
			media.toString();
		}
	}
	
	
	
	/**
	 * Returns full  media library size 
	 * */
	public int displayLibraryCount() {
		return library.size();
	}
	
	
	/**
	 *Filters library for a specific media type , using a passing a prefix
	 *@param prefix : prefix for filtering, possible values af: audio file , cd: compact disk vr: vinyl record
	 *@throws Illegal argument exception if the prefix is not a valid media type , is null , or empty
	 * */
	
	
	public void displayChoice(final String prefix) {
		if(prefix == null || prefix.isBlank()) {
			throw new IllegalArgumentException();
		}
		ArrayList<String> choiceOptions = new ArrayList<>(Arrays.asList("af","cd","vr"));
		if(prefix == null || prefix.isBlank()) {
			throw new IllegalArgumentException("Empty prefix");
		}
		
		if(choiceOptions.contains(prefix)) 
		{
			// FIlters library hashmap by a specific media type
			// Access HashMap stream API to filter the library by a specific media type using a lambda expression 
			// Filtered entries are collected into a new Hashmap for the appropriate media type
			// Call to displayLibrary overload 
			switch(prefix) {
				case "af":
					Map<String,MusicMedia> audioFiles = library.entrySet().stream()
																		  .filter(entry -> entry.getValue() instanceof AudioFile)
																		  .collect(Collectors.toMap(Map.Entry::getKey,entry->(AudioFile)entry.getValue()));
					System.out.println("Showing Audio Files");
					displayLibrary(audioFiles);
					break;
					
				case "cd":
					Map<String,MusicMedia> compactDisks = library.entrySet().stream()
																			.filter(entry -> entry.getValue() instanceof CompactDisk)
																			.collect(Collectors.toMap(Map.Entry::getKey,entry->(CompactDisk)entry.getValue()));
					System.out.println("Showing Compact Disk");
					displayLibrary(compactDisks);
					break;
				case "vr":
					Map<String,MusicMedia> vinylRecords = library.entrySet().stream()
																			.filter(entry -> entry.getValue() instanceof VinylRecord)
																			.collect(Collectors.toMap(Map.Entry::getKey,entry->(VinylRecord)entry.getValue()));
					System.out.println("Showing Vinyl Records");
					displayLibrary(vinylRecords);
					break;
					
			}
		}else {
			throw new IllegalArgumentException("Invalid media type");
		}
		
		
	}
	
	
	

}
