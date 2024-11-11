/**
 * Music controller performs CRUD and sorting operation in music data
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class MusicController {
	
	private MusicLibrary musicLibrary;
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
	
	public void createMusicRecord() {
		
		
	}
	
	
	public void updateMusicRecord() {
		
	}
	
	public void deleteMusicRecord() {
		
	}
	
	public void updateMusicFile() {
		
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
