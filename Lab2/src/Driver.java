/**
 * Driver class 
 * Author Jose Tellez
 * Version 1.0;
 * */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicMedia audioFile 	= new AudioFile("learn to fly","foo fighters","learntofly.mp3",3);
		MusicMedia compactDisc  = new CompactDisc("Master of Puppets","Metallica",8);
		MusicMedia vinyl        = new VinylRecord("Abbey Road","The Beatles",17,180,"12\"");
		
		audioFile.toString();
		audioFile.play();
		
		compactDisc.toString();
		compactDisc.play();
		
		vinyl.toString();
		vinyl.play();

	}

}
