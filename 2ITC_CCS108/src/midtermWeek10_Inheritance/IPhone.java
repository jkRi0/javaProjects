package midtermWeek10_Inheritance;

public class IPhone extends SmartPhone{
	private int iosVersion;
	IPhone(String brand, String model, int version){
		super(brand, model);
		iosVersion = version;
	}
	
	public int getIOSVersion() {
		return iosVersion;
	}
	
	public void UpdateIOS() {
		iosVersion++;
		System.out.println("Updating iOS on "+super.getBrand()+" "+super.getModel()+" to version "+iosVersion);
	}
}

