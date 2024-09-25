/**
 * This class models a Vinyl Record
 * Author: Jose Tellez
 * Version: 1.0
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VinylRecord extends MusicMedia {
	private int numberOfTracks;
	private int weightInGrams; 
	private String sizeInInches;
	private final ArrayList<String> acceptedSizes = new ArrayList<String>(Arrays.asList("7\"","10\"","12\""));
	Map<String,Integer> acceptedWeightsDictionary = new HashMap<String,Integer>(){
		{put("7\"",50);
		 put("10\"",100);}};
    private final Integer TWELVE_INCH_LOWER_WEIGHT_LIMIT = 140;
    private final Integer TWELVE_INCH_UPPER_WEIGHT_LIMIT = 200;
    
    
    /**
     * Class constructor
     * @param musicTitle: music title
     * @param artist: artist name
     * @param numberOfTracks: record number of tracks
     * @param weightInGrams: record weight in grams
     * @param sizeInInches: record size in inches
     * @throws IllegalArgumentException if musicTitle, artist fail string check
     * @throws IllegalArgumentException if sizeInInches fails acceptable size check
     * @throws IllegalArgumentException if weightInGrams fails acceptable weight value check
     * */
    
	public VinylRecord(final String musicTitle,final String artist, final int numberOfTracks, final int weightInGrams,final String sizeInInches) {
		super(musicTitle, artist);
		// TODO Auto-generated constructor stub
		if(!isValidInteger(numberOfTracks)) {
			throw new IllegalArgumentException();
		}
		if(!isAnAcceptableVinylSize(sizeInInches)){
			throw new IllegalArgumentException();
		}
		if(!isAnAcceptableVinylWeight(sizeInInches,weightInGrams)) {
			throw new IllegalArgumentException();
		}
		this.weightInGrams  =weightInGrams;
		this.sizeInInches   =sizeInInches;
		this.numberOfTracks =numberOfTracks;
	
		
	}
	
	
	/**
	 * Checks if record size is a valid value returns true if is , false otherwise
	 * @param inputSize : record size in inches
	 * */
	private boolean isAnAcceptableVinylSize(String inputSize)
	{
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
		if(isAnAcceptableVinylSize(sizeInInches)) 
		{
			if(sizeInInches != "12\"") 
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
	public String toString() 
	{
		super.toString();
		System.out.println(String.format("Record number of tracks: %d",this.numberOfTracks));
		System.out.println(String.format("Record size in inches:   %s",this.sizeInInches));
		System.out.println(String.format("Record weight in grams:  %d",this.weightInGrams));
		return null;
	}
	
	/**
	 * Concrete implementation of play class
	 * */
	public void play() {
		System.out.println("Vynil record is playing");
	}


}
