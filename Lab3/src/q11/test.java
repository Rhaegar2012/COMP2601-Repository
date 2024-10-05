package q11;
import java.util.ArrayList;

public class test {
	
	public static void main (String args[]) 
	{
		ArrayList<AddressTools> list = new ArrayList<>();
		list.add(new Envelope());
	}
}

interface AddressTools{
	
}

class Envelope implements AddressTools{
	
}