package midterm;

public class MainBook {

	public static void main(String[] args) {
		// Create Book 1
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        // Print Book 1 information
        book1.PrintBookInfo("1");

        // Create Book 2 with a different title and author
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        // Update Book 2 information
        book2.setTitle("Multivers of Madness");
        book2.setAuthor("Stan Lee");
        book2.setYearPublished(2022);

        // Print Book 2 information
        book2.PrintBookInfo("2");
	}

}
