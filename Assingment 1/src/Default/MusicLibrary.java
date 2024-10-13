package Default;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class MusicLibrary {
	
	private HashMap<String,MusicMedia> library;
	
	/**
	 * Default Constructor
	 * */
	public MusicLibrary() {
		
	}
	
	public void addMusic(final MusicMedia selection) {
		library.put(selection.getSku(), selection);
	}
	
	public void displayLibrary() {
		for(String key: library.keySet()) {
			MusicMedia media = library.get(key);
			media.toString();
		}
	}
	
	private void displayLibrary(final Map<String,MusicMedia> mediaLibrary) 
	{
		for(String key: mediaLibrary.keySet()) {
			MusicMedia media = mediaLibrary.get(key);
			media.toString();
		}
	}
	
	public void displayChoice(final String prefix) {
		ArrayList<String> choiceOptions = new ArrayList<>(Arrays.asList("af","cd","vr"));
	
		
		if(choiceOptions.contains(prefix)) 
		{
			// FIlters library hashmap by a specific media type
			// Access HashMap stream API to filter the library by a specific media type 
			// Filtered entries are collected into a new Hashmap for the appropriate media type
			// Call to displayLibrary overload 
			switch(prefix) {
				case "af":
					Map<String,MusicMedia> audioFiles = library.entrySet().stream()
																		  .filter(entry -> entry.getValue() instanceof AudioFile)
																		  .collect(Collectors.toMap(Map.Entry::getKey,entry->(AudioFile)entry.getValue()));
					displayLibrary(audioFiles);
					break;
					
				case "cd":
					Map<String,MusicMedia> compactDisks = library.entrySet().stream()
																			.filter(entry -> entry.getValue() instanceof CompactDisk)
																			.collect(Collectors.toMap(Map.Entry::getKey,entry->(CompactDisk)entry.getValue()));
					displayLibrary(compactDisks);
					break;
				case "vr":
					Map<String,MusicMedia> vinylRecords = library.entrySet().stream()
																			.filter(entry -> entry.getValue() instanceof VinylRecord)
																			.collect(Collectors.toMap(Map.Entry::getKey,entry->(VinylRecord)entry.getValue()));
					displayLibrary(vinylRecords);
					
					break;
					
			}
		}else {
			throw new IllegalArgumentException("Invalid media type");
		}
		
		
	}
	
	
	

}
