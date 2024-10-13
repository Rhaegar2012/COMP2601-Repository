/**
 * Driver class 
 * Author Jose Tellez
 * Version 1.0;
 * */
public class Driver {

	public static void main(String[] args) {
	
		DigitalMedia audioFile 	= new AudioFile("A girl like you","foo fighters","a girl like you.mp3",3,"C://My");
		PhysicalMedia compactDisc  = new CompactDisc("Master of Puppets","Metallica",8);
		PhysicalMedia vinyl        = new VinylRecord("Abbey Road","The Beatles");
		
		audioFile.toString();
		audioFile.play();
		
		compactDisc.toString();
		compactDisc.play();
		
		vinyl.toString();
		vinyl.play();

	}

}

