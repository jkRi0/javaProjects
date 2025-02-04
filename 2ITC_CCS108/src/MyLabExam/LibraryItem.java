package MyLabExam;

public abstract class LibraryItem implements Borrowable{
	private int id;
	private String title;
	private User checkedOutStatus;
	
	public LibraryItem(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public User getCheckedOutStatus() {
		return this.checkedOutStatus;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCheckedOutStatus(User checkedOutStatus) {
		this.checkedOutStatus = checkedOutStatus;
	}
	
	public abstract String GetAdditionalInfo();

	
	
}
