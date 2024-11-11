/**
 * Main Driver Class to visualize the music library
 * Author: Jose Tellez
 * Version:1.0
 * */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment2 {
	
	private static MusicLibrary library;
	private static final String AUDIO_FILE_PREFFIX 	 ="af";
	private static final String CD_PREFFIX 		   	 ="cd";
	private static final String VINYL_RECORD_PREFFIX ="vr";
	private static final int 	SKU_INDEX 			 	=0;
	private static final int    TITLE_INDEX			 	=1;
	private static final int 	ARTIST_INDEX		 	=2;
	private static final int 	YEAR_INDEX			 	=3;
	private static final int	FILE_NAME_INDEX		 	=4;
	private static final int	NUMBER_TRACKS_INDEX	 	=4;
	private static final int    FILE_RESOLUTION_INDEX 	=5;
	private static final int 	WEIGHT_IN_GRAMS_INDEX	=5;
	private static final int 	SIZE_IN_INCHES_INDEX	=6;
	
	
	public static void main (String[] args) {
		
		library = new MusicLibrary();
		FileLoader.loadData("music_data.txt");
		System.out.println("music Data loaded succesfully");
		UserInterface userUI = new UserInterface(library);
		userUI.displayFrame();;
		
		
	}
	
	/*
	 * Nested class to manage data load operations
	 * */
	private static class FileLoader{
		
		static FileReader reader = null;
		static Scanner    scanner = null;
		
		/*
		 * Reads music data from a text file and creates a music media object
		 * @param: fileName fileName , name of the file to loaded
		 * @throws: IOException , if file fails to load
		 * */
		
		public static void loadData(final String fileName) {
			File musicFile= new File(fileName);
			if(!musicFile.exists()) {
				System.out.println("The file was not found");
				System.exit(-1);
			}
			
			try {
				reader= new FileReader(musicFile);
				scanner = new Scanner(reader);
				
				while(scanner.hasNext()) {
					String fileLine = scanner.nextLine();
					String fileType = fileLine.substring(0,2);
					String [] fileData = fileLine.split("\\|");
					CreateMusicMediaObject(fileData,fileType);
				}
				
			}catch(IOException e){
				System.out.println(e.getMessage());
				
			}
			
			
			
		}
		
		
		/**
		 * Creates anew music media object 
		 * @param :musicData array, string collection of parameters to create music object
		 * @param :fileType, file type to be created (Audio file ,Compact Disk, Vinyl Record) 
		 * */
		private static  void CreateMusicMediaObject(final String[] musicDataArray,String fileType) {
			int arraySize = musicDataArray.length;
			switch(fileType) {
				case AUDIO_FILE_PREFFIX:
	
					String    afSku 	 					= musicDataArray[SKU_INDEX];
					String    afTitle 						= musicDataArray[TITLE_INDEX];
					String    afArtist 						= musicDataArray[ARTIST_INDEX];
					int       afYear						= Integer.parseInt(musicDataArray[YEAR_INDEX]);
					String    afFileName					= musicDataArray[FILE_NAME_INDEX];
					int 	  afFileResolution				= Integer.parseInt(musicDataArray[FILE_RESOLUTION_INDEX]);
					AudioFile audioFile = new AudioFile(afSku,afTitle,afArtist,afYear,afFileName,afFileResolution);
					library.addMusic(audioFile);
				break;
				case CD_PREFFIX:
					String    cdSku 	 					= musicDataArray[SKU_INDEX];
					String    cdTitle 						= musicDataArray[TITLE_INDEX];
					String    cdArtist 						= musicDataArray[ARTIST_INDEX];
					int       cdYear						= Integer.parseInt(musicDataArray[YEAR_INDEX]);
					int 	  cdNumberOfTracks 				= Integer.parseInt(musicDataArray[NUMBER_TRACKS_INDEX]);
					CompactDisk compactDisk = new CompactDisk(cdSku,cdTitle,cdArtist,cdYear,cdNumberOfTracks);
					library.addMusic(compactDisk);
				break;
				case VINYL_RECORD_PREFFIX:
					String    vrSku 	 					= musicDataArray[SKU_INDEX];
					String    vrTitle 						= musicDataArray[TITLE_INDEX];
					String    vrArtist 						= musicDataArray[ARTIST_INDEX];
					int       vrYear						= Integer.parseInt(musicDataArray[YEAR_INDEX]);
					int 	  vrNumberOfTracks 				= Integer.parseInt(musicDataArray[NUMBER_TRACKS_INDEX]);
					String 	  vrSizeInInches 				= musicDataArray[SIZE_IN_INCHES_INDEX];
					int       vrWeightInGrams 				= Integer.parseInt(musicDataArray[WEIGHT_IN_GRAMS_INDEX]);
					VinylRecord vinylRecord = new VinylRecord(vrSku,vrTitle,vrArtist,vrYear,vrNumberOfTracks,vrSizeInInches,vrWeightInGrams);
					library.addMusic(vinylRecord);
				break;
			}
		}
	}
	
	
	
	
}

