package MyLabExam;

public class DVD extends LibraryItem{
	private String director;
	
	public DVD(int id, String title) {
		super(id, title);
	}
	
	public DVD(int id, String title, String director) {
		this(id, title);
		this.director = director;
	}
	
	public String GetAdditionalInfo() {
		return "\nID: "+super.getId()+
				"\nTITLE: "+super.getTitle()+
				"\nSTATUS: "+super.getCheckedOutStatus()+
				"\nAUTHOR: "+this.director;
	}

	public void Checkout(User user) {
		super.setCheckedOutStatus(user);
	}

	public void ReturnItem() {
		super.setCheckedOutStatus(null);
	}
}
