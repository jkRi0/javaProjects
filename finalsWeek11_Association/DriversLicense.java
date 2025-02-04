package finalsWeek11_Association;

public class DriversLicense {
	private String licenseNo;
	private int restriction;
	private Person person;
	
	public DriversLicense(String licenseNo, int restriction, Person person) {
		this.licenseNo = licenseNo;
		this.restriction = restriction;
		this.person = person;
		
		this.person.AssignDriversLicense(this);
	}
	
	public String GetDriversLicenseDetails() {
		return "\nLICENSE NO.: "+this.licenseNo+"\nRESTRICTION: "+this.restriction;
	}
	
	public String GetFullDetails() {
		return this.GetDriversLicenseDetails()+"\n"+this.person.GetPersonDetails();
	}
}
