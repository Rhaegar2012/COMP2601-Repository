
/**
 * This class models a Vinyl Record
 * Author: Jose Tellez
 * Version: 1.0
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VinylRecord extends PhysicalMedia {
	private int 			numberOfTracks;
	private int 			weightInGrams; 
	private String 			sizeInInches;
	//Default Constants
	private final int 		DEFAULT_WEIGHT_GRAMS 		= 40;
	private final String 	DEFAULT_SIZE_INCHES			= "7";
	private final int 		DEFAULT_NUMBER_OF_TRACKS	= 2;
	//Instance constant 
	private  Integer 			 WEIGHT_MINIMUM_GRAMS;
	private  Integer 			 WEIGHT_MEDIUM_GRAMS;
	private  Integer 			 WEIGHT_MAXIMUM_GRAMS;
	private  String  			 MEDIUM_SIZE_INCHES;
	private  String  			 MAXIMUM_SIZE_INCHES;
	private  Integer 			 TWELVE_INCH_LOWER_WEIGHT_LIMIT;
	private  Integer 			 TWELVE_INCH_UPPER_WEIGHT_LIMIT;
	
	private final static String  INVALID_SIZE_MESSAGE	="Size must 7,10 or 12";
	private final static String  INVALID_WEIGHT_MESSAGE = "Weight must be between 40 and 200";
	
	//Constants initializer block
	{
		 WEIGHT_MINIMUM_GRAMS	 		  		= 40;
	     WEIGHT_MEDIUM_GRAMS		 	  		= 100;
	     WEIGHT_MAXIMUM_GRAMS     		  		= 200;
	     MEDIUM_SIZE_INCHES			  			= "10";
	     MAXIMUM_SIZE_INCHES			  		= "12";
	     TWELVE_INCH_LOWER_WEIGHT_LIMIT  		= 140;
	     TWELVE_INCH_UPPER_WEIGHT_LIMIT  		= 200; 
	
    }
	
	/**
	 * Default constructor
	 * */
	public VinylRecord() {
	
		this.numberOfTracks= DEFAULT_NUMBER_OF_TRACKS;
		this.weightInGrams = DEFAULT_WEIGHT_GRAMS;
		this.sizeInInches  = DEFAULT_SIZE_INCHES;
		
	}
	/**
     * Class constructor
     * @param musicTitle: music title
     * @param artist: artist name
     * @throws IllegalArgumentException if musicTitle, artist fail string check
     * @throws IllegalArgumentException if sizeInInches fails acceptable size check
     * @throws IllegalArgumentException if weightInGrams fails acceptable weight value check
     * */
	
	public VinylRecord(final String sku, final String musicTitle, final String artist, final int year , final int numberOfTracks) {
		super(sku,musicTitle,artist,year);
		if(!isValidInteger(numberOfTracks)) {
			throw new IllegalArgumentException();
		}
		this.numberOfTracks=numberOfTracks;
		
	}
	
	public VinylRecord(final String sku, final String musicTitle , final String artist, final int year,final int numberOfTracks, final String sizeInInches, final int weight) {
		super(sku,musicTitle,artist,year);
		if(!isValidInteger(numberOfTracks)) {
			throw new IllegalArgumentException();
		}
		this.sizeInInches	=sizeInInches;
		this.numberOfTracks	=numberOfTracks;
		this.sizeInInches 	= sizeInInches;
		
	}

	/**
	 * Checks if record size is a valid value returns true if is , false otherwise
	 * @param inputSize : record size in inches
	 * */
	private boolean isAnAcceptableVinylSize(String inputSize)
	{
		ArrayList<String> acceptedSizes = new ArrayList<String>(Arrays.asList(DEFAULT_SIZE_INCHES,MEDIUM_SIZE_INCHES,MAXIMUM_SIZE_INCHES));
		if(acceptedSizes.contains(inputSize)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the provided weight of a record is a valid value , returns true if it is , false otherwise
	 * @param sizeInInches: record size in inches , used to access size-weight dictionary
	 * @param weightInGrams: record weight in grams
	 * */
	private boolean isAnAcceptableVinylWeight(String sizeInInches,int weightInGrams) {
		Map<String,Integer> acceptedWeightsDictionary = new HashMap<String,Integer>(){
			{put(DEFAULT_SIZE_INCHES,DEFAULT_WEIGHT_GRAMS);
			 put(MEDIUM_SIZE_INCHES,WEIGHT_MEDIUM_GRAMS);}};
		if(!isValidInteger(weightInGrams)||!isValidString(sizeInInches)) {
			throw new IllegalArgumentException();
		}
		if(isAnAcceptableVinylSize(sizeInInches)){
			if(!sizeInInches.equals(MAXIMUM_SIZE_INCHES)) 
			{
				int acceptedWeight = acceptedWeightsDictionary.get(sizeInInches);
				if(acceptedWeight==weightInGrams){
					return true;
				}
			}
			else {
				if(weightInGrams >= TWELVE_INCH_LOWER_WEIGHT_LIMIT || weightInGrams <= TWELVE_INCH_UPPER_WEIGHT_LIMIT) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Returns number of tracks
	 * */
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	
	
	/**
	 * Sets new number of tracks
	 * @param numberOfTracks new number of tracks 
	 * */
	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}
	
	/**
	 * Returns weight of record in grams
	 * */
	public int getWeightInGrams() {
		return weightInGrams;
	}
	
	
	/**
	 * Sets new weight in grams
	 * @param weightInGrams: record weight in grams
	 * */
	public void setWeightInGrams(int weightInGrams) {
		this.weightInGrams = weightInGrams;
	}
	
	
	/**
	 * Returns record size in inches
	 * */
	public String getSizeInInches() {
		return sizeInInches;
	}
	
	/**
	 *Sets new size in inches 
	 *@param sizeInInches: newSize
	 * */
	public void setSizeInInches(String sizeInInches) {
		this.sizeInInches = sizeInInches;
	}
	
	
	/**
	 * toString extends toString method from parent class
	 * */
	@Override
	public String toString() 
	{
		String superString=super.toString();
		String vinylRecordString=superString+String.format("|%d |%s |%d",numberOfTracks,sizeInInches,weightInGrams);
		return vinylRecordString;
	}
	
	/**
	 * Concrete implementation of play class
	 * */
	public void play() {
		System.out.println("Vynil record is playing");
	}


}

