/**
 * This class models a Vinyl Record
 * Author: Jose Tellez
 * Version: 1.0
 * */
import java.util.ArrayList;
import java.util.Arrays;

public class VinylRecord extends MusicMedia {
	private int numberOfTracks;
	private int weightInGrams; 
	private String sizeInInches;
	private final ArrayList<String> acceptedSizes = new ArrayList<String>(Arrays.asList("7","10","12"));
	public VinylRecord(String musicTitle, String artist) {
		super(musicTitle, artist);
		// TODO Auto-generated constructor stub
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
	
	public void play() {
		
	}


}
