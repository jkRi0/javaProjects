
public class Phone {
	private String brand;
	private String owner;
	private int numUsers;
	
	boolean lcdPower=false;
	
	
	//getter methods
	public String getBrand() {
		return this.brand;
	}
	public String getOwner() {
		return this.owner;
	}
	public int getNumUsers() {
		return this.numUsers;
	}
		
	
	//setter methods
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public void setOwner(String owner) {
		this.owner=owner;
	}
	public void setNumUsers(int numUsers) {
		this.numUsers=numUsers;
	}
	
	
	
	//class methods
	public void TurnOnPhone() {
		System.out.println("The phone has been turned on");
	}
	public void UsePhone() {
		System.out.println("The phone has been in used");
	}
	public void TurnOffPhone() {
		System.out.println("The phone has been turned off");
	}
	
}
