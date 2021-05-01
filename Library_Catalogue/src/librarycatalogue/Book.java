package librarycatalogue;

public class Book {

	// properties, fields, global variables
	String title;
	int pageCount;
	int ISBN;
	boolean isAvailable;
	int dayCheckedOut = -1;

	// constructor for Book class
	public Book(String bookTitle, int bookPageCount, int bookISBN) {
		this.title = bookTitle;
		this.pageCount = bookPageCount;
		this.ISBN = bookISBN;
		isAvailable = false;
	}

	// Getters and Setters / instance variable
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable, int currentDayCheckedOut) {
		this.isAvailable = isAvailable;
		setDayCheckedOut(currentDayCheckedOut);
	}

	public int getDayCheckedOut() {
		return dayCheckedOut;
	}

	public void setDayCheckedOut(int dayCheckedOut) {
		this.dayCheckedOut = dayCheckedOut;
	}

}
