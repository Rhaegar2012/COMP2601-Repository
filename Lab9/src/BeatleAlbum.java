
public class BeatleAlbum {
	private String id;
	private String title;
	private boolean acquired;
	private String label;
	private String pressing;
	private String sound;
	private String catNo;
	
	public BeatleAlbum(final String id,final String title, final boolean acquired,
			final String label,final String pressing,final String sound, 
			final String catNo) {
		if(!isValidString(id) || !isValidString(title)||
		   !isValidString(label)||!isValidString(pressing)||
		   !isValidString(sound)||!isValidString(catNo)) {
			throw new IllegalBeatleException("Beatle information is incorrect");
			
		}
		this.id = id;
		this.title=title;
		this.acquired=acquired;
		this.label=label;
		this.pressing=pressing;
		this.sound= sound;
		this.catNo = catNo;
		
	}
	
	private boolean isValidString(String value) {
		
		if(value == null || value.isBlank()) 
		{
			return false;
		}
		return true;
	}
	
	//Setter
	public void setAcquired(final boolean acquired) {
		this.acquired=acquired;
	}
	
	//Getters 
	
	public String getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public Boolean getAcquired() {
		return this.acquired;
	}
	
	public String getPressing() {
		return this.pressing;
	}
	
	public String getSound() {
		return this.sound;
	}
	
	public String getCatNo() {
		return this.catNo;
	}
	
	@Override
	public  String toString() {
		String message = String.format("Beatle Album [id=%s, title=%s,acquired=%b,label=%s,pressing=%s,sound=%s,catNo=%s]", 
										id,title,acquired,label,pressing,sound,catNo);
		
		return message;
	}
	
	
	
	//Custom exception class
	private class IllegalBeatleException extends RuntimeException{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public IllegalBeatleException(String exceptionMessage) 
		{
			super(exceptionMessage);
		}
		
	}

}
