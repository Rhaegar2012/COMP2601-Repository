package code;
/**
 * This class models book data 
 * author: Jose Tellez 
 * Version 0.0
 * */
public class Book {
	
	private final String title;
	private final String author;
	private final int    year;
	
	/**
	 * Class Constructor
	 * @param title  : book title
	 * @param author : book author
	 * @param year   : book year
	 * */
	public Book(final String title, final String author, final int year) {
		this.title	=title;
		this.author	=author;
		this.year 	= year;
	}

	/**
	 * Returns book title
	 * @return title
	 * */
	public String getTitle() {
		return title;
	}
	/**
	 * Returns book's author
	 * @return author
	 * */
	public String getAuthor() {
		return author;
	}
	/**
	 * Returns book's publication year
	 * @return year
	 * */
	public int getYear() {
		return year;
	}
	
	
}
