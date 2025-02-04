
public class Main {

	public static void main(String []args) {
		//create an instance (object) - instantiation
		Book objBook = new Book();
		
		//dot notation
		//. == intelisense
		
		
		objBook.setTitle("Intro to OOP");
		//objBook.setTitle("Intro to OOP");
		//objBook.author="Juan Dela Cruz";
		//objBook.numPages=200;
		
		System.out.println("BOOK TITLE: "+objBook.getTitle());
		//System.out.println("BOOK AUTHOR: "+objBook.author);
		//System.out.println("BOOK NUMBER OF PAGES: "+objBook.numPages);
		
		
		objBook.OpenBook();
		objBook.FlipPage();
		objBook.CloseBook();
		
		
		
		
	}

}
