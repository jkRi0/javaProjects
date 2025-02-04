package MyLabExam;

import java.util.List;
import java.util.ArrayList;
public class LibraryUser implements User{
	private String name;
	private List<Borrowable> borrowedItems = new ArrayList<>();
	
	public LibraryUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void BorrowItem(Borrowable item) {
		this.borrowedItems.add(item);
	}
	
	public void ReturnItem(Borrowable item) {
		this.borrowedItems.remove(item);
	}
}
