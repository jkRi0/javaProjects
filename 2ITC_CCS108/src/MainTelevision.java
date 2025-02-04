import java.util.Scanner;
public class MainTelevision {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Television objTV=new Television();
		
		System.out.println("***TELEVISION***");
		
		
		while(true) {
			System.out.print(
					  "\n(1)Power ON/OFF, (2)Increase volume, (3)Decrease volume"
					+ "\n(4)Increase channel, (5) Decrease channel, (6)Mute/Unmute volume"
					+ "\nChoose an action: ");
			String chosen=scan.next();
			switch(chosen) {
				case "1":
					objTV.SwitchedPower();
					break;
				case "2":
					objTV.IncreaseVolume();
					break;
				case "3":
					objTV.DecreaseVolume();
					break;
				case "4":
					objTV.IncreaseChannel();
					break;
				case "5":
					objTV.DecreaseChannel();
					break;
				case "6":
					objTV.SwitchMuteVolume();
					break;
				default:
					System.out.println("\n||Invalid input||");
					objTV.PrintDetails();
			}
			
		}
		
//		
//		objTV.PrintDetails();
//		
//		
//		objTV.IncreaseVolume();
//		objTV.SwitchedPower();
//		objTV.IncreaseVolume();
		
		
		
	}

}
