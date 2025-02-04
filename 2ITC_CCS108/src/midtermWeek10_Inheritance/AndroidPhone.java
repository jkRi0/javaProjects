package midtermWeek10_Inheritance;

public class AndroidPhone extends SmartPhone{
	private String os;
	
	//to be visible for super class
	public int version = 18;
	
	public int getVersion() {
		return this.version;
	}
	//****************************
	
	
	
	
	public String getOS() {
		return os;
	}
	
	public void InstallApp(String appName) {
		System.out.println("Installing "+appName+" app on "+super.getBrand()+" "+super.getModel());
	}
	
	AndroidPhone(String brand, String model, String os){
		super(brand, model);
		this.os = os;
	}
}

