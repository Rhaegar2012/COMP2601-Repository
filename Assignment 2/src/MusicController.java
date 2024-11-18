/**
 * Music controller performs CRUD and sorting operation in music data
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import javax.swing.JTextField;
public class MusicController {
	interface Callback<T,U> extends BiConsumer<T,U>{
		
	}
	private MusicLibrary musicLibrary;
	
	private final List<Callback<MusicMedia,Object>> AUDIO_FILE_CALLBACKS;
	private final List<Callback<MusicMedia,Object>> COMPACT_DISK_CALLBACKS;
	private final List<Callback<MusicMedia,Object>> VINYL_RECORD_CALLBACKS;

	
	{
		AUDIO_FILE_CALLBACKS = new ArrayList<>();
		AUDIO_FILE_CALLBACKS.add((music,value)->music.setSku((String)value));
		AUDIO_FILE_CALLBACKS.add((music,value)->music.setMusicTitle((String)value));
		AUDIO_FILE_CALLBACKS.add((music,value)->music.setArtist((String)value));
		AUDIO_FILE_CALLBACKS.add((music,value)->music.setYear((Integer.parseInt((String)value))));
		AUDIO_FILE_CALLBACKS.add((music,value)-> {if(music instanceof AudioFile) { ((AudioFile) music).setFileName((String) value);}});
		AUDIO_FILE_CALLBACKS.add((music,value)-> {if(music instanceof AudioFile) { ((AudioFile) music).setFileResolution(Integer.parseInt((String)value));}});
		
		COMPACT_DISK_CALLBACKS= new ArrayList<>();
		COMPACT_DISK_CALLBACKS.add((music,value)-> music.setSku((String)value));
		COMPACT_DISK_CALLBACKS.add((music,value)-> music.setMusicTitle((String)value));
		COMPACT_DISK_CALLBACKS.add((music,value)-> music.setArtist((String)value));
		COMPACT_DISK_CALLBACKS.add((music,value)-> music.setYear((Integer.parseInt((String)value))));
		COMPACT_DISK_CALLBACKS.add((music,value)-> {if(music instanceof CompactDisk) { ((CompactDisk) music).setNumberOfTracks(Integer.parseInt((String)value));}});
		
		
		VINYL_RECORD_CALLBACKS = new ArrayList<>();
		VINYL_RECORD_CALLBACKS.add((music,value)->music.setSku((String)value));
		VINYL_RECORD_CALLBACKS.add((music,value)->music.setMusicTitle((String)value));
		VINYL_RECORD_CALLBACKS.add((music,value)->music.setArtist((String)value));
		VINYL_RECORD_CALLBACKS.add((music,value)->music.setYear((Integer.parseInt((String)value))));
		VINYL_RECORD_CALLBACKS.add((music,value)-> {if(music instanceof VinylRecord) {((VinylRecord) music).setNumberOfTracks(Integer.parseInt((String)value));};});
		VINYL_RECORD_CALLBACKS.add((media,value)-> {if(media instanceof VinylRecord) {((VinylRecord) media).setSizeInInches((String)value);};});
		VINYL_RECORD_CALLBACKS.add((media,value)-> {if(media instanceof VinylRecord) {((VinylRecord) media).setWeightInGrams(Integer.parseInt((String)value));};});
											
	}
	
	
	public MusicController(final MusicLibrary musicLibrary) {
		if(musicLibrary == null || musicLibrary.getLibrarySize()<=0) {
			throw new IllegalArgumentException("Library is null or empty");
		}
		this.musicLibrary = musicLibrary;

		
	}
	
	
	public MusicMedia readMusicRecord(String fileSKU) {
		
		MusicMedia media = musicLibrary.getMusicMediaFile(fileSKU);
		return media;
	}
	
	
	public void updateMusicRecord(ArrayList<JTextField> textFields) {
		System.out.println(textFields.size());
		if(textFields == null || textFields.size()<0) {
			throw new IllegalArgumentException("Null or empty form text fields");
		}
		String fileSKU= textFields.get(0).getText();
		MusicMedia file = musicLibrary.getMusicMediaFile(fileSKU);
		if(file == null) {
			createMusicRecord(textFields);
		}
		else {
			String fileTypePreffix = fileSKU.substring(0,2);
			switch(fileTypePreffix) {
				case "af":
					for(int i=0 ;i< AUDIO_FILE_CALLBACKS.size();i++){
						AUDIO_FILE_CALLBACKS.get(i).accept(file, textFields.get(i).getText());
						
					}
					
				break;
				case "cd":
					for(int i=0;i< COMPACT_DISK_CALLBACKS.size();i++) {
						COMPACT_DISK_CALLBACKS.get(i).accept(file,textFields.get(i).getText());
					}
				break;
				case "vr":
					for(int i=0;i<VINYL_RECORD_CALLBACKS.size();i++) {
						VINYL_RECORD_CALLBACKS.get(i).accept(file,textFields.get(i).getText());
					}
				break;
			}
			musicLibrary.setMusicMediaFile(fileSKU, file);
		}
	}
	
	public void createMusicRecord(final ArrayList<JTextField> textValues) {
		if(textValues == null || textValues.size()==0) {
			throw new IllegalArgumentException("Empty form values");
		}
		
		String newSKU= textValues.get(0).getText();
		System.out.println(newSKU);
		String fileTypePreffix = newSKU.substring(0,2);
		switch(fileTypePreffix) 
		{
			case "af":
				String    afSku 	 					= textValues.get(0).getText();
				String    afTitle 						= textValues.get(1).getText();
				String    afArtist 						= textValues.get(2).getText();
				int       afYear						= Integer.parseInt(textValues.get(3).getText());
				String    afFileName					= textValues.get(4).getText();
				int 	  afFileResolution				= Integer.parseInt(textValues.get(5).getText());
				AudioFile audioFile = new AudioFile(afSku,afTitle,afArtist,afYear,afFileName,afFileResolution);
				musicLibrary.addMusic(audioFile);
				break;
			case "cd":
				String    cdSku 	 					= textValues.get(0).getText();
				String    cdTitle 						= textValues.get(1).getText();
				String    cdArtist 						= textValues.get(2).getText();
				int       cdYear						= Integer.parseInt(textValues.get(3).getText());
				int 	  cdNumberOfTracks 				= Integer.parseInt(textValues.get(4).getText());
				CompactDisk compactDisk = new CompactDisk(cdSku,cdTitle,cdArtist,cdYear,cdNumberOfTracks);
				musicLibrary.addMusic(compactDisk);
				break;
			case "vr":
				String    vrSku 	 					= textValues.get(0).getText();
				String    vrTitle 						= textValues.get(1).getText();
				String    vrArtist 						= textValues.get(2).getText();
				int       vrYear						= Integer.parseInt(textValues.get(3).getText());
				int 	  vrNumberOfTracks 				= Integer.parseInt(textValues.get(4).getText());
				String 	  vrSizeInInches 				= textValues.get(5).getText();
				int       vrWeightInGrams 				= Integer.parseInt(textValues.get(6).getText());
				VinylRecord vinylRecord = new VinylRecord(vrSku,vrTitle,vrArtist,vrYear,vrNumberOfTracks,vrSizeInInches,vrWeightInGrams);
				musicLibrary.addMusic(vinylRecord);
				break;
		
		}
	}
	
	public void updateMusicLibrary(){
		musicLibrary.writeLibraryToFile();
	}
	
	
	public void deleteMusicRecord(final String targetSKU) {
		if(targetSKU==null || targetSKU.isBlank()) {
			throw new IllegalArgumentException("Invalid or empty SKU for deletion");		
		}
		musicLibrary.removeMusic(targetSKU);
	
		
	}
	

	public String[] sortEntriesByType() {
		ArrayList<MusicMedia> unsortedData = musicLibrary.getLibraryEntries();
		Collections.sort(unsortedData,(m1,m2)-> m1.getSku().compareTo(m2.getSku()));
		String[] sortedEntries= new String[unsortedData.size()];
		int i =0;
		for(MusicMedia media: unsortedData) {
			sortedEntries[i]=media.toString();
			i++;
		}
		
		return sortedEntries;
		
	}
	
	public String[] sortEntriesByArtist() {
		ArrayList<MusicMedia> unsortedData = musicLibrary.getLibraryEntries();
		Collections.sort(unsortedData,(m1,m2)->m1.getArtist().compareTo(m2.getArtist()));
		String[] sortedEntries = new String[unsortedData.size()];
		int i=0;
		for(MusicMedia media:unsortedData) {
			sortedEntries[i]= media.toString();
			i++;
		}
		return sortedEntries;
		
	}
	
	public String[] sortEntriesByTitle() {
		ArrayList<MusicMedia> unsortedData = musicLibrary.getLibraryEntries();
		Collections.sort(unsortedData,(m1,m2)->m1.getMusicTitle().compareTo(m2.getMusicTitle()));
		String[] sortedEntries = new String[unsortedData.size()];
		int i=0;
		for(MusicMedia media:unsortedData) {
			sortedEntries[i]=media.toString();
			i++;
		}
		return sortedEntries;
		
	}
	
	public String[] sortEntriesByYear() {
		ArrayList<MusicMedia> unsortedData = musicLibrary.getLibraryEntries();
		Collections.sort(unsortedData,(m1,m2)->Integer.compare(m1.getYear(),m2.getYear()));
		String[] sortedEntries = new String[unsortedData.size()];
		int i=0;
		for(MusicMedia media: unsortedData) {
			sortedEntries[i]=media.toString();
			i++;
		}
		return sortedEntries;
	}
	
	
	
	
	
	
	

}
