import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;


public class lab8 {
	
	private static  ArrayList<BeatleAlbum> beatleAlbums;
	private static  int ID_INDEX		=0;
	private static  int ALBUM_INDEX		=1; 
	private static  int ACQUIRED_INDEX	=2;
	private static  int LABEL_INDEX		=3;
	private static 	int PRESSING_INDEX	=4;
	private static  int SOUND_INDEX		=5;
	private static 	int CATNO_INDEX		=6;
	
	
	
	public static void main(String[] args) {
		beatleAlbums		  = new ArrayList<BeatleAlbum>();
		FileLoader fileLoader = new FileLoader("beatles_vinyl.csv");
		fileLoader.LoadData();
		Filter 	   filter 	  = new Filter();
		filter.filterByTitle("Abbey Road");
		filter.filterByLabel("rainbow no brackets");
		filter.filterByAcquiredStatus(true);
		filter.filterByTitleLabelAcquired("The Beatles","Apple", true);
		filter.filterByPressingAndSound("RCA", "Mono");
	}
	
	private static class Filter{
		
		public void filterByTitle(final String title) {
			
			List<BeatleAlbum> filteredEntries = new ArrayList<>();
			filteredEntries = (List<BeatleAlbum>) beatleAlbums.stream().filter((album)->album.getTitle().toLowerCase().equals(title.toLowerCase())).collect(Collectors.toList());
			System.out.println("Albums by title \n");
			printEntries(filteredEntries);
			
		}
		
		public void filterByLabel(final String label) {
			
			List<BeatleAlbum> filteredEntries = new ArrayList<>();
			filteredEntries = (List<BeatleAlbum>) beatleAlbums.stream().filter((album)->album.getLabel().toLowerCase().equals(label.toLowerCase())).collect(Collectors.toList());
			System.out.println("Albums by Label\n");
			printEntries(filteredEntries);
		}
		
		public void filterByAcquiredStatus(final boolean acquired) {
			
			List<BeatleAlbum> filteredEntries = new ArrayList<>();
			filteredEntries =  beatleAlbums.stream().filter((album)->album.getAcquired()==acquired).collect(Collectors.toList());
			System.out.println("Albums by acquired status \n");
			printEntries(filteredEntries);
		}
		
		public void filterByTitleLabelAcquired(final String title,final String label ,final boolean acquired) {
			
			List<BeatleAlbum> filteredEntries = new ArrayList<>();
			filteredEntries = (ArrayList<BeatleAlbum>) beatleAlbums.stream().filter((album)->album.getTitle().toLowerCase().equals(title.toLowerCase()))
																			.filter((album)->album.getLabel().toLowerCase().equals(label.toLowerCase()))
																			.filter((album)->album.getAcquired()==acquired).collect(Collectors.toList());
			System.out.println("Albums by title, label and acquired status \n");
			printEntries(filteredEntries);
		}
		
		public void filterByPressingAndSound(final String pressing ,final String sound) {
			
			List<BeatleAlbum> filteredEntries = new ArrayList<>();
			filteredEntries = (ArrayList<BeatleAlbum>) beatleAlbums.stream().filter((album)->album.getPressing().toLowerCase().equals(pressing.toLowerCase()))
																			.filter((album)->album.getPressing().toLowerCase().equals(sound.toLowerCase())).collect(Collectors.toList());
			
			System.out.println("Albums by pressing and sound \n");
			printEntries(filteredEntries);
			
			
		}
		
		public void printEntries (final List<BeatleAlbum> albumEntries) {
			for(BeatleAlbum album: albumEntries) {
				System.out.println(album.toString());
			}
			
			
		}
		
	}
	
	private static class FileLoader{
		private Scanner 	scanner		=null;
		private File 		file		=null;
		private FileReader 	fileReader	=null; 
		private String 		filePath;
		
		public FileLoader(final String filePath) {
			if(filePath == null || filePath.isBlank() ) {
				throw new IllegalArgumentException("Invalid file path");
			}
			this.filePath = filePath;
			this.file = new File(this.filePath);
			if(!file.exists()) {
				System.out.println("The file is not found");
				System.exit(-1);
			}
			try {
				this.fileReader = new FileReader(file);
				this.scanner 	= new Scanner(fileReader);
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
			
		}
		
		public void LoadData() {
			while(scanner.hasNext()) {
				String lineData 		= scanner.nextLine();
				String[] dataArray 		= lineData.split(",");
				String id 				= dataArray[ID_INDEX];
				String albumTitle 		= dataArray[ALBUM_INDEX];
				boolean acquired 		= Boolean.parseBoolean(dataArray[ACQUIRED_INDEX]);
				String label 			= dataArray[LABEL_INDEX];
				String pressingIndex 	= dataArray[PRESSING_INDEX];
				String sound 			= dataArray[SOUND_INDEX];
				String catNo 			= dataArray[CATNO_INDEX];
				BeatleAlbum newAlbum = new BeatleAlbum(id,albumTitle,acquired,label,pressingIndex,sound,catNo);
				beatleAlbums.add(newAlbum);
			}
			
		}
		
	}

}
