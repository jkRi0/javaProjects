package finalsWeek11_Association;

public class Main_Person_DL {

	public static void main(String[] args) {
		Person obj1 = new Person("micheal", "Ryan");
		DriversLicense obj2 = new DriversLicense("ABC-456",3,obj1);

		System.out.println(obj1.GetPersonDetails());
		System.out.println(obj1.GetFullDetails());
		
		
		System.out.println(obj2.GetDriversLicenseDetails());
		System.out.println(obj2.GetFullDetails());
		
	}

}
