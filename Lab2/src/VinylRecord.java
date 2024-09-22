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
		this.weightInGrams=weightInGrams;
		this.sizeInInches =sizeInInches;
	
		
	}
	
	private boolean isAnAcceptableVinylSize(String inputSize)
	{
		if(acceptedSizes.contains(inputSize)) {
			return true;
		}
		return false;
	}
	
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
	
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}
	public int getWeightInGrams() {
		return weightInGrams;
	}
	public void setWeightInGrams(int weightInGrams) {
		this.weightInGrams = weightInGrams;
	}
	public String getSizeInInches() {
		return sizeInInches;
	}
	public void setSizeInInches(String sizeInInches) {
		this.sizeInInches = sizeInInches;
	}
	
	public String toString() 
	{
		super.toString();
		System.out.println(String.format("Record number of tracks: %d",this.numberOfTracks));
		System.out.println(String.format("Record size in inches: %s",this.sizeInInches));
		System.out.println(String.format("Record weight in grams: %d",this.weightInGrams));
		return null;
	}
	public void play() {
		System.out.println("Vynil record is playing");
	}


}
