package librarycatalogue;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {

	// properties/fields/global variables
	Map<String, Book> bookCollection = new HashMap<String, Book>();
	int currentDay = 0;
	int lengthOfCheckoutPeriod = 7;
	double initialLateFee = 0.50;
	double feePerLateDay = 1;

	// constructors

	public LibraryCatalogue(Map<String, Book> collection) {
		this.bookCollection = collection;
	};

	public LibraryCatalogue(Map<String, Book> collection, int lengthOfCheckoutPeriod, double initialLateFee,
			double feePerLateDay) {
		this.bookCollection = collection;
		this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
		this.initialLateFee = initialLateFee;
		this.feePerLateDay = feePerLateDay;
	}

	public Book getBook(String bookTitle) {
		return getBookCollection().get(bookTitle);
	}

	public Map<String, Book> getBookCollection() {
		return bookCollection;
	}

	public void setBookCollection(Map<String, Book> bookCollection) {
		this.bookCollection = bookCollection;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}

	public int getLengthOfCheckoutPeriod() {
		return lengthOfCheckoutPeriod;
	}

	public void setLengthOfCheckoutPeriod(int lengthOfCheckoutPeriod) {
		this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
	}

	public double getInitialLateFee() {
		return initialLateFee;
	}

	public void setInitialLateFee(double initialLateFee) {
		this.initialLateFee = initialLateFee;
	}

	public double getFeePerLateDay() {
		return feePerLateDay;
	}

	public void setFeePerLateDay(double feePerLateDay) {
		this.feePerLateDay = feePerLateDay;
	}

	public void nextDay() {
		currentDay++;
	}

	public void setDay(int day) {
		currentDay = day;
	}

	// INSTANCE METHODS:
	public void checkOutBook(String title) {
		Book book = getBook(title);
		if (book.isAvailable()) {
			bookCheckedOut(book);
		} else {
			book.setAvailable(true, currentDay);
			System.out.println("You have just checked out " + title + " enjoy!!!");
			System.out.println("Please return book on day: " + (getCurrentDay() + getLengthOfCheckoutPeriod()) + ".");
		}
	}

	public void returnBook(String title) {
		Book book = getBook(title);
		int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckoutPeriod());
		if (daysLate > 0) {
			System.out.println(title + " is returned later than the desiganted return time."
					+ "\nPlease pay the fee of $" + (getInitialLateFee() + daysLate * getFeePerLateDay())
					+ " because your book is " + daysLate + " days overdue" + "\nShow me the money!!!");
		} else {
			System.out.println("Book Returned Thank you!");
		}
		book.setAvailable(false, -1);
	}

	public void bookCheckedOut(Book book) {
		System.out.println("Sorry nerd " + book.getTitle() + "is already checked out =(."
				+ "\nIt should be back on day " + (book.getDayCheckedOut() + getLengthOfCheckoutPeriod()) + ".");
	}

	public static void main(String[] args) {
		Map<String, Book> bookCollection = new HashMap<String, Book>();
		Book harry = new Book("Harry Potter and the order of the pheonix", 450, 75876);
		bookCollection.put("Harry Potter and the order of the Pheonix", harry);

		LibraryCatalogue lib = new LibraryCatalogue(bookCollection);

		lib.checkOutBook("Harry Potter and the order of the Pheonix");
		lib.nextDay();
		lib.nextDay();
		lib.checkOutBook("Harry Potter and the order of the Pheonix");
		lib.setDay(17);
		lib.returnBook("Harry Potter and the order of the Pheonix");
		lib.checkOutBook("Harry Potter and the order of the Pheonix");
	}

}
