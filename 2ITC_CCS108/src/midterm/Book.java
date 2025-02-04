package midterm;

import java.time.Year;

public class Book {

	private String title;
	private String author;
	private int yearPublished;
	
	public Book(String title, String author, int yearPublished) {
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
	}
	
	
	// Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
	
    public Year CalculateAge() {
		Year year = Year.now();
		return year.minusYears(this.yearPublished);
	}
    
    public void PrintBookInfo(String bookNumber) {
        System.out.println("Book " + bookNumber + " Information:");
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Year Published: " + this.yearPublished);
        System.out.println("Summary of " + this.title + ":");
        System.out.println("Author: " + this.author);
        System.out.println("Published in: " + this.yearPublished);
        System.out.println("Age: " + CalculateAge() + " years");
    }
}