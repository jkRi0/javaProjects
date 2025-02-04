import java.util.Scanner;

public class MainSmartPhone {
    public static void main(String[] args) {
    	//ENTER PHONE's PROPERTIES
    	Scanner scanner = new Scanner(System.in);
        System.out.println("____MY PHONE____");
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine(); 
        System.out.print("Enter your phone's color: ");
        String color = scanner.nextLine();
        System.out.print("Enter screen size on inches: ");
        double screenSize = scanner.nextDouble();
        System.out.print("Enter battery capacity in milliamps(mah), "
        		+ "\n good capacity ranging from 1500 - 5000: ");
        int batteryCapacity = scanner.nextInt();
        int batteryLevel = 100;
        System.out.print("Enter storage capacity in GB: ");
        int storageCapacity = scanner.nextInt();
        
        //INSTANTIATION
        SmartPhone phone = new SmartPhone(brand, model, color, screenSize, batteryCapacity, 
        								batteryLevel, storageCapacity);
        DisplayMainMenu(phone);
    }
    
    //PHONE's MAIN MENU
    public static void DisplayMainMenu(SmartPhone phone) {
    	Scanner scanner = new Scanner(System.in);
    	while (true) {
        	phone.DisplayPhoneStatus();
        	System.out.println("________________MENU's__________________");
        	System.out.println("|(0) Exit\t\t\t\t|");
        	System.out.println("|(1) Power On/Off\t\t\t|");
        	System.out.println("|(2) Increase Volume\t\t\t|");
        	System.out.println("|(3) Decrease Volume\t\t\t|");
        	System.out.println("|(4) Increase Brightness\t\t|");
        	System.out.println("|(5) Decrease Brightness\t\t|");
        	System.out.println("|Applications:\t\t\t\t|");
        	System.out.println("|\t(6) Make Call\t\t\t|");
        	System.out.println("|\t(7) Open Camera\t\t\t|");
        	System.out.println("|\t(8) Open Calculator\t\t|");
        	System.out.println("|\t(9) Open Gallery\t\t|");
        	System.out.println("|\t(10) About Phone\t\t|");
        	System.out.println("|(11) Tabs\t(12) Home\t(13) Back|");
        	
        	System.out.print("Enter your choice: ");
        	int choice = scanner.nextInt();
        	
        	switch (choice) {
        	case 0:
        		System.out.println("Exiting the program.");
        		System.exit(0);
        		break;
        	case 1:
        		phone.SwitchedPower();
        		break;
        	case 2:
        		phone.IncreaseVolume();
        		break;
        	case 3:
        		phone.DecreaseVolume();
        		break;
        	case 4:
        		phone.IncreaseBrightness();
    			break;
        	case 5: 
        		phone.DecreaseBrightness();
        		break;
        	case 6:
        		//PHONE MUST BE TURNED ON
    			if(phone.getIsPowerOn()==true) {
    				System.out.print("Enter phone number to call: ");
    				String stringNum = scanner.next();
    				//PHONE NUMBER MUST BE IN 11 DIGITS LONG
    				if(stringNum.length() == 11) {
    					phone.MakeCall(stringNum);
    				}else {
    					System.out.println("\n||Failed to make a call! Please check your number again||");
    				}
    			}else {
    				System.out.println("\n||Please turn ON the Smart Phone first||");
    			}
        		break;
        	case 7:
        		OpenCamera(phone);	//CALL THE METHOD BELOW
        		break;
        	case 8:
        		OpenCalculator(phone);
        		break;
        	case 9:
        		phone.DisplayGallery();
        		break;
        	case 10:
        		phone.DisplayPhoneDetail();
        		break;
        	case 11:
        		System.out.println("APPLICATIONS: ");
        		break;
        	case 12:
        		DisplayMainMenu(phone);
        		break;
        	case 13:
        		DisplayMainMenu(phone);
        		break;
        	default:
        		System.out.println("Invalid choice. Please select a valid option (1-6)");
        	 
        	}//END OF SWITCH
        }//END OF WHILE
    }
    
    //CAMERA APPLICATION
    public static void OpenCamera(SmartPhone phone) {
    	Scanner scanner = new Scanner (System.in);
    	int temp=1;	//used for random photo size
    	if(phone.getIsPowerOn()==true) {
    		while (true) {
    			phone.DisplayPhoneStatus();
    			System.out.println("________________CAMERA__________________");
	        	System.out.println("|(0) Exit\t\t\t\t|");
	        	System.out.println("|(1) Power On/Off\t\t\t|");
	        	System.out.println("|(2) Increase Volume\t\t\t|");
	        	System.out.println("|(3) Decrease Volume\t\t\t|");
	        	System.out.println("|(4) Increase Brightness\t\t|");
        		System.out.println("|(5) Decrease Brightness\t\t|");
        		System.out.println("|\t\t\t\t\t|");
        		System.out.println("|(6) Capture Photo\t\t\t|");
        		System.out.println("|(7) Delete Photo\t\t\t|");
        		System.out.println("|(8) Open Gallery\t\t\t|");
        		System.out.println("|(9) Tabs\t(10) Home\t(11) Back|");
        		
        		System.out.print("Enter your choice: ");
        		int choice = scanner.nextInt();
        		
        		switch (choice) {
        		case 0:
        			System.out.println("Exiting the program.");
        			System.exit(0);
        			break;
        		case 1:
        			phone.SwitchedPower();
        			break;
        		case 2:
        			phone.IncreaseVolume();
        			break;
        		case 3:
        			phone.DecreaseVolume();
        			break;
        		case 4:
        			phone.IncreaseBrightness();
        			break;
        		case 5: 
        			phone.DecreaseBrightness();
        			break;
        		case 6:
        			//photo file name and random integer for photo size
        			phone.CapturePhoto("Photo"+Integer.toString(temp++),
    						(int)(Math.random()*30)+1);
	        		break;
	        	case 7:
	        		//if the gallery was open
	        		if(phone.isGalleryOn==true) { 
						System.out.print("Photo number: ");
						int photoNumber=scanner.nextInt();
						phone.DeletePhoto(photoNumber);
					}else {
						System.out.println("||Please open the gallery first||");
					}
	        		break;
	        	case 8:
	        		phone.DisplayGallery();
	        		break;
	        	case 9:
	        		System.out.println("APPLICATIONS: ");
	        		break;
	        	case 10:
	        		DisplayMainMenu(phone);
	        		break;
	        	case 11:
	        		DisplayMainMenu(phone);
	        		break;
	        	default:
	        		System.out.println("Invalid choice. Please select a valid option (1-6)");
	        	 
	        	}//END OF SWITCH
	        }//END OF WHILE
		}else {
			System.out.println("\n||Please turn ON the Smart Phone first||");
		}
    }
    
    //CALCULATOR APPLICATION
    public static void OpenCalculator(SmartPhone phone) {
    	if(phone.getIsPowerOn()==true) {
    		double answer=0;
    		while (true) {
    			Scanner scanner = new Scanner (System.in);
    			phone.DisplayPhoneStatus();
    			System.out.println("\n______________CALCULATOR________________");
	        	System.out.println("|(/z) Exit\t\t\t\t|");
	        	System.out.println("|(/a) Power On/Off\t\t\t|");
	        	System.out.println("|(/b) Increase Volume\t\t\t|");
	        	System.out.println("|(/c) Decrease Volume\t\t\t|");
	        	System.out.println("|(/d) Increase Brightness\t\t|");
        		System.out.println("|(/e) Decrease Brightness\t\t|");
        		System.out.println("|\t\t\t\t\t|");
        		System.out.println("|(/f) Back");
        		System.out.println("|(/g) Clear Memory");
        		System.out.print("Enter mathematical expression (e.g. 1+2 or +4)."+
        							"\nOtherwise, enter a command given by the Menu: ");
        		String input=scanner.nextLine();
        		switch(input) {
        		case "/z":
        			System.out.println("Exiting the program.");
        			System.exit(0);
        			break;
        		case "/a":
        			phone.SwitchedPower();
        			DisplayMainMenu(phone);
        			break;
        		case "/b":
        			phone.IncreaseVolume();
        			break;
        		case "/c":
        			phone.DecreaseVolume();
        			break;
        		case "/d":
        			phone.IncreaseBrightness();
        			break;
        		case "/e":
        			phone.DecreaseBrightness();
        			break;
        		case "/f":
        			DisplayMainMenu(phone);
        			break;
        		case "/g":
        			answer = 0;
        			System.out.println("\n||Calculated Memory Cleared!");
        			break;
        		default:
        			answer=SmartPhone.ComputeForCalculator(answer, input);
        			System.out.println("\nANSWER: "+answer);
        		}//END OF SWITCH
    		}//END OF WHILE
		}else {
			System.out.println("\n||Please turn ON the Smart Phone first||");
		}
    }
}