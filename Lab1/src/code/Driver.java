package code;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Main driver class with data reading functionality 
 * */
public class Driver {
	
	private static final int  BOOK_TITLE_INDEX		=0;
	private static final int  BOOK_AUTHOR_INDEX		=1;
	private static final int  BOOK_YEAR_INDEX		=2;
	
	/**
	 * Main class ,
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ArrayList<Book> bookArray = loadData("book_data.txt");
		for(Book book: bookArray) 
		{
			String bookTitle  = book.getTitle();
			String bookAuthor = book.getAuthor();
			int    bookYear   = book.getYear();
			String formattedString = String.format("Book Title: %s. Book Author: %s Year of Publication: %d",bookTitle,bookAuthor,bookYear);
			System.out.println(formattedString);
		}
	}
	
	/**
	 * Reads data from a text file , creates book object and adds it to a local array list 
	 * @param filepath: text file path
	 * @return populated ArrayList with book objects
	 * */
	private static ArrayList<Book> loadData(final String filepath){
		File file = new File(filepath);
		Scanner fileScanner = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			fileScanner = new Scanner(file);
			while(fileScanner.hasNext()) {
				String fileLine 		= fileScanner.nextLine();
				String [] bookDataArray = fileLine.split(",");
				String bookTitle 		= bookDataArray[BOOK_TITLE_INDEX];
				String bookAuthor 		= bookDataArray[BOOK_AUTHOR_INDEX];
				int bookYear 			= Integer.parseInt(bookDataArray[BOOK_YEAR_INDEX]);
				Book newBook 			= new Book(bookTitle,bookAuthor,bookYear);
				books.add(newBook);
				}
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
			
			}finally {
			
			fileScanner.close();
			
		}
		return books;
	}
}
