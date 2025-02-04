package MyLabExam;

public class Book extends LibraryItem{
	private String author;
	
	public Book(int id, String title) {
		super(id, title);
	}
	
	public Book(int id, String title, String author) {
		this(id, title);
		this.author = author;
	}
	
	public String GetAdditionalInfo() {
		return "\nID: "+super.getId()+
				"\nTITLE: "+super.getTitle()+
				"\nSTATUS: "+super.getCheckedOutStatus()+
				"\nAUTHOR: "+this.author;
	}

	public void Checkout(User user) {
		super.setCheckedOutStatus(user);
	}

	public void ReturnItem() {
		super.setCheckedOutStatus(null);
	}
}
