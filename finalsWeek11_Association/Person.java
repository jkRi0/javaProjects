package finalsWeek11_Association;

public class Person {
	private String firstName;
	private String lastName;
	private DriversLicense driversLicense;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		
	}
	
	public String GetPersonDetails() {
		return "NAME: "+this.firstName+" "+this.lastName;
	}
	
	public String GetFullDetails() {
		String display = this.GetPersonDetails();
		if(driversLicense != null) {
			display+=this.driversLicense.GetDriversLicenseDetails();
		}else {
			display+="No Driver's License";
		}
		return display+"\n";
	}
	
	public void AssignDriversLicense(DriversLicense driversLicense) {
		this.driversLicense = driversLicense;
	}
}
