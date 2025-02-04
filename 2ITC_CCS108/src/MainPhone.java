import java.util.Scanner;
public class MainPhone {

	static Scanner scanner=new Scanner(System.in);
	static Phone objPhone = new Phone();
	
	public static void main(String[] args) {
		
		
		System.out.println("Brand of your phone: ");
		String phoneBrand=scanner.nextLine();
		
		System.out.println("Phone owner username: ");
		String phoneUserName=scanner.nextLine();
		
		objPhone.setBrand(phoneBrand);
		objPhone.setOwner(phoneUserName);
		objPhone.setNumUsers(1);
		
		
		PhoneStatus();
	}
	public static void PhoneStatus() {
		System.out.println("\n(1)Turn On, (2)Turn Off");
		String chosen=scanner.next();
		if(chosen.equals("1")) {
			objPhone.TurnOnPhone();
			objPhone.lcdPower=true;
			
			
			System.out.println("\nOpening... "+objPhone.getBrand());
			System.out.println("Welcome "+objPhone.getOwner());
			objPhone.UsePhone();
			
			
			
			System.out.println("(1)Turn On, (2)Turn Off");
			String chosen1=scanner.next();
			if(chosen.equals("1")) {
				System.out.println("The phone is already in turned on");
				PhoneStatus();
			}
			else if(chosen.equals("2")) {
				objPhone.TurnOffPhone();
				
			}
		}
		else if(chosen.equals("2")) {
			if(objPhone.lcdPower==true) {
				objPhone.TurnOffPhone();
			}
			else {
				System.out.println("The phone is already in turned off");
				PhoneStatus();
			}
		}
	}

}
