import java.util.Scanner;

public class MainDigitalCamera {

	public static void main(String[] args) {
		//create object
		int temp=1;	//used for random photo size
		
		Scanner scan=new Scanner(System.in);
		DigitalCamera objCamera = new DigitalCamera();
		objCamera.brand="SONY";
		objCamera.storageCapacity=100;
		
		
		
		while(true) {
			System.out.println("\n(1) Power ON/Off");
			System.out.println("(2) Capture a Photo");
			System.out.println("(3) Open Gallery");
			System.out.println("(4) Delete photo");
			System.out.println("Type /end, to terminate the program");
			System.out.print("Your choice: ");
			String chosen=scan.nextLine();
			switch(chosen) {
			case "1":
				objCamera.SwitchedPower();
				break;
			case "2":
				objCamera.CapturePhoto("Photo"+Integer.toString(temp++),
						(int)(Math.random()*30)+1);
				break;
			case "3":
				objCamera.DisplayPhotoGallery();
				break;
			case "4":
				if(objCamera.isPowerOn==true) {	//if power ON
					if(objCamera.isGalleryOn==true) { //if the gallery was open
						System.out.print("Photo number: ");
						int photoNumber=scan.nextInt();
						objCamera.DeletePhoto(photoNumber);
					}else {
					System.out.println("||Please open the gallery first||");
					}
				}else {
					System.out.println("||Please turn ON the digital camera first||");
				}
				break;
			case "/end":
				System.exit(0);
			default:
				System.out.println("\n||Nothing happen, because that is none of the choices brooo||");
			}
		}
		
		
	}

}
