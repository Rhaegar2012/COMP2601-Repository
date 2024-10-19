package Default;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment1 {
	
	private static MusicLibrary library;
	private static final String AUDIO_FILE_PREFFIX 	 ="af";
	private static final String CD_PREFFIX 		   	 ="cd";
	private static final String VINYL_RECORD_PREFFIX ="vr";
	private static final int	MENU_OPTION_1=1;
	private static final int	MENU_OPTION_2=2;
	private static final int	MENU_OPTION_3=3;
	private static final int 	MENU_OPTION_4=4;
	
	
	public static void main (String[] args) {
		
		library = new MusicLibrary();
		FileLoader.loadData("music_data.txt");
		System.out.println("music Data loaded succesfully");
		MenuDisplay.displayMenu();
	}
	
	private static class FileLoader{
		
		static FileReader reader = null;
		static Scanner    scanner = null;
	
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
		
		private static  void CreateMusicMediaObject(final String[] musicDataArray,String fileType) {
			int arraySize = musicDataArray.length;
			switch(fileType) {
				case "af":
	
					String    afSku 	 	= musicDataArray[0];
					String    afTitle 	= musicDataArray[1];
					String    afArtist 	= musicDataArray[2];
					int       afYear		= Integer.parseInt(musicDataArray[3]);
					String    afFileName	= musicDataArray[4];
					int 	  afFileResolution = Integer.parseInt(musicDataArray[5]);
					AudioFile audioFile = new AudioFile(afSku,afTitle,afArtist,afYear,afFileName,afFileResolution);
					library.addMusic(audioFile);
				break;
				case "cd":
					String    cdSku 	 	= musicDataArray[0];
					String    cdTitle 	= musicDataArray[1];
					String    cdArtist 	= musicDataArray[2];
					int       cdYear		= Integer.parseInt(musicDataArray[3]);
					int 	  cdNumberOfTracks = Integer.parseInt(musicDataArray[4]);
					CompactDisk compactDisk = new CompactDisk(cdSku,cdTitle,cdArtist,cdYear,cdNumberOfTracks);
					library.addMusic(compactDisk);
				break;
				case "vr":
					String    vrSku 	 	= musicDataArray[0];
					String    vrTitle 	= musicDataArray[1];
					String    vrArtist 	= musicDataArray[2];
					int       vrYear		= Integer.parseInt(musicDataArray[3]);
					int 	  vrNumberOfTracks = Integer.parseInt(musicDataArray[4]);
					String 	  vrSizeInInches = musicDataArray[5];
					int       vrWeightInGrams = Integer.parseInt(musicDataArray[6]);
					VinylRecord vinylRecord = new VinylRecord(vrSku,vrTitle,vrArtist,vrYear,vrNumberOfTracks,vrSizeInInches,vrWeightInGrams);
					library.addMusic(vinylRecord);
				break;
			}
		}
	}
	
	private static class MenuDisplay {
		
		private static void printMenuOptions() {
			
			System.out.println("Choose one of the following options: ");
			System.out.println("1. Display Audio Files ");
			System.out.println("2. Display Compact Discs");
			System.out.println("3. Display Vinyl Records");
			System.out.println("4. Exit");
		}
		
		public static  void displayMenu() {
			
			boolean isAppRunning = true;
			Scanner scanner 	 = null;
			int 	userInput;
			while(isAppRunning) {
				printMenuOptions();
				scanner = new Scanner(System.in);
				try {
					userInput = Integer.parseInt(scanner.nextLine());
				}
				catch(Exception e){
					System.out.println("Input is not valid , enter number 1 to 5");
					continue;
				}
				switch(userInput) {
				case MENU_OPTION_1:
					library.displayChoice(AUDIO_FILE_PREFFIX);
				break;
				case MENU_OPTION_2:
					library.displayChoice(CD_PREFFIX);
				break;
				case MENU_OPTION_3:
					library.displayChoice(VINYL_RECORD_PREFFIX);
				break;
				case MENU_OPTION_4:
					scanner.close();
					isAppRunning=false;
				break;
				}
			} 
		
		}
	}
}

