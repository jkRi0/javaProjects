package midtermWeek10_Inheritance;

public class SmartPhone {
	private String brand;
	private String model;
	
	//example to get the fields from subclass
	private AndroidPhone androidPhone;
	
	public int getVersion() {
		return this.androidPhone.getVersion();
	}
	//****************************************
	
	
	
	
	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}
	
	SmartPhone(String brand, String model){
		this.brand = brand;
		this.model = model;
	}
	
	public void MakeCall(String number) {
		System.out.println("Calling "+number+" from "+brand+" "+model);
	}
	
	public void SendMessage(String recepient, String message) {
		System.out.println("Sending message to "+recepient+" from "+brand+" "+model+": "+message);
	}
}
