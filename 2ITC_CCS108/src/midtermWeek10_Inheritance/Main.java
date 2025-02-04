package midtermWeek10_Inheritance;

import java.util.ArrayList;
import java.util.List;
public class Main {
  	public static void main(String[] args) {
    	//DECLARING THE ARRAYLIST
		List <SmartPhone> smartPhoneObj = new ArrayList<SmartPhone>();
		
		System.out.println("List of Smartphones:\n");
		
		//INITIALIZATION OF ARRAY LIST WITH INSTANTIATED OBJECTS FOR SMARTPHONE
		smartPhoneObj.add(new AndroidPhone("Samsung","Galaxy S4","Android 6"));
		smartPhoneObj.add(new IPhone("Apple","iPhone 6", 9));
		smartPhoneObj.add(new AndroidPhone("LG","V60 ThinQ 5G","Android 10"));
		smartPhoneObj.add(new IPhone("Apple","iPhone 15", 17));
		
		//ITERATE THROUGH THE LIST TO DISPLAY DETAILS AND FUNCTIONS
		for(int count = 0; count < smartPhoneObj.size(); count++) {
			System.out.println("Brand: "+smartPhoneObj.get(count).getBrand());
			System.out.println("Model: "+smartPhoneObj.get(count).getModel());
			
			//VALIDATE THE OBJECT FROM ARRAYLIST IF ITS HAS AN INSTANCE FROM ONE OF THE SUBCLASS
			if(smartPhoneObj.get(count) instanceof AndroidPhone) {
				//CASTING THE SUPERCLASS WITH SUBCLASS
				System.out.println("OS: "+((AndroidPhone) smartPhoneObj.get(count)).getOS());
				((AndroidPhone) smartPhoneObj.get(count)).InstallApp("FileManager");
			
			}else if(smartPhoneObj.get(count) instanceof IPhone) {
				System.out.println("iOs Version: "+((IPhone) smartPhoneObj.get(count)).getIOSVersion());
				((IPhone) smartPhoneObj.get(count)).UpdateIOS();
			}
			
			//MAKE A CALL AND SEND MESSAGE FOR EVERY SMARTPHONE USING THE METHODS FROM SUPER CLASS
			smartPhoneObj.get(count).MakeCall("123-456-7890");
			smartPhoneObj.get(count).SendMessage("James", "Good Day!");
			System.out.println("\n");
		}
  	}
}
