import java.util.ArrayList;
import java.util.List;

public class SmartPhone {
	//CLASSFIELDS
	private String brand;
	private String model;
	private String color;
	private double screenSize;
	private int batteryCapacity;
	private double batteryLevel;
	private int storage;
	private boolean isPowerOn = false;
	private int volumeLevel = 1;
	private int brightness = 1;
	private double simulateConsumption;
	
	private int usedStorage;
	boolean isGalleryOn = false;
	private List<String> photoGallery = new ArrayList<>();
	private List<Integer> photoSizes = new ArrayList<>();

	//CONSTRUCTORS 
	public SmartPhone() {};
	public SmartPhone(String brand
	    			,String model
	    	    	,String color
	    	    	,double screenSize
	    	    	,int batteryCapacity
	    	    	,int batteryLevel
	    	    	,int storage) {
	    this.brand = brand;
	    this.model = model;
	    this.color = color;
	    this.screenSize = screenSize;
	    this.batteryCapacity = batteryCapacity;
	    this.batteryLevel = batteryLevel;
	    this.storage = storage * 1000; //GB to MB
	}
	
	// Getters and Setters
	public String getBrand() {
	    return brand;
	}
	public String getModel() {
	    return model;
	}
	public double getScreenSize() {
	    return screenSize;
	}
	public int getBatteryCapacity() { 
	    return batteryCapacity;
	}
	public double getBatteryLevel() {
		return batteryLevel;
	}
	public boolean getIsPowerOn() {
	          return isPowerOn;
	}
	public int getvolumeLevel() {
	          return volumeLevel;
	}
	public int getbrightness () {
	          return brightness;
	}
	public int getStorage() {
	          return storage;
	}
	
	
	
	      
	//METHODS
	public void MakeCall(String phoneNumber) {
		/*
		simulateConsumption is a variable that has every function of the smart phone,
		and it affects the battery level.
		*/
		simulateConsumption=0.1;  
	  	System.out.println("\nCalling... " + phoneNumber);
	}
	
	public void DisplayPhoneDetail() {
		if(this.isPowerOn==true) {  //if the smart phone was turned on
			System.out.println("\n\n|Brand: " + this.getBrand());
			System.out.println("|Model: " + this.getModel()+" ("+color+")");
			System.out.println("|ScreenSize: " + this.getScreenSize());
			System.out.println("|Battery Capacity: " + this.getBatteryCapacity());
			System.out.println("|Storage: " + this.getStorage() + "MB");
		}else {
			System.out.println("\n||Please turn ON the Smart Phone first\n||");
		}
	}
	
	public void DisplayPhoneStatus() {
		System.out.println("\n****************************************");
	  	System.out.println("Power: " + (this.getIsPowerOn() == true ? "ON" : "OFF"));
	    System.out.println("Volume: " + this.getvolumeLevel());
	  	System.out.println("Brightness: " + this.getbrightness());
	  	System.out.println("Battery: "+(int)this.getBatteryLevel()+"%");
	  	ConsumeBattery();
	}
	
	public void ChargeBattery() {
	    if (isPowerOn) {
	    	System.out.println("Cannot charge battery while the phone is powered on. Please power off first.");
	    } else {
	        batteryLevel = 100;
	        System.out.println("Battery fully charged.");
	    }
	}
	
	public void ConsumeBattery() {
		//CONSUMING BATTERY WHEN THE SMARTPHONE PHONE IS ON USE
		this.batteryLevel = this.batteryLevel - AffectBatteryConsumption(simulateConsumption, batteryCapacity);
	}
	
	public double AffectBatteryConsumption(double simulateConsumption, int batteryCapacity) {
		//SMARTPHONE's USAGE DURATION WILL DEPENDS ON BATTERY CAPACITY
		//temporary convert the integer into string
		String temp = Integer.toString(batteryCapacity); 
		String temp1 = "";
		
		//remove the last TWO character of the string
		for(int count=0; count<temp.length()-2; count++) {
			temp1+=temp.charAt(count);
		}
		
		//another temporary variable with converted value of string to integer
		int temp2 = Integer.parseInt(temp1);
		
		//CONVERTING INTEGER TO DECIMAL
		//denominator must be larger than numerator, to create the dependent simulateConsumption variable
		double denominator = batteryCapacity * temp2;
		double numerator = batteryCapacity;
		double decimalValue = numerator / denominator;
		double dependentVariable = simulateConsumption + decimalValue;
		return dependentVariable;
	}
	
	public void SwitchedPower() {
		//switch the boolean value of isPowerOn variable
		this.isPowerOn = !this.isPowerOn;
	}
	
	public void IncreaseVolume() {
		if(this.isPowerOn == true) {
			simulateConsumption=0.05;
			//can only increase if the volume level is less than 10
			if(this.volumeLevel < 10) {
				this.volumeLevel++;
				System.out.println("\n||Increased volume level||");
			}else {
				System.out.println("\n||Maximum volume level has been reached||");
			}
		}else {
			System.out.println("\n||Cannot increase the volume. Please turn on the Smart Phone||");
		}
	}
	
	public void DecreaseVolume() {
		if(this.isPowerOn == true) {
			simulateConsumption=0.03;
			//can only decrease if the volume level is greater than 1
			if(this.volumeLevel > 1) {
				this.volumeLevel--;
				System.out.println("\n||Decreased volume level||");
			}else {
				System.out.println("\n||Minimum volume level has been reached||");
			}
		}else {
			System.out.println("\n||Cannot decrease the volume. Please turn on the Smart Phone||");
		}
	}
	
	public void IncreaseBrightness() {
		if(this.isPowerOn == true) {
			simulateConsumption=0.05;
			if(this.brightness < 10) {
				this.brightness++;
				System.out.println("\n||Increased brightness level||");
			}else {
				System.out.println("\n||Maximum brightness level has been reached||");
			}
		}else {
			System.out.println("\n||Cannot increase the brightness. Please turn on the Smart Phone||");
		}
	}
	
	public void DecreaseBrightness() {
		if(this.isPowerOn == true) {
			simulateConsumption=0.03;
			if(this.brightness > 1) {
				this.brightness--;
				System.out.println("\n||Decreased brightness level||");
			}else {
				System.out.println("\n||Minimum brightness level has been reached||");
			}
		}else {
			System.out.println("\n||Cannot decrease the brightness. Please turn on the Smart Phone||");
		}
	}
	
	//CAPTURE PHOTO
	public void CapturePhoto(String photoFileName, int photoSize) {
		if(this.isPowerOn==true) {
			simulateConsumption=0.1;
			//check the array list if the photo file name was already on the list
			if(!photoGallery.contains(photoFileName)) {
				//photo size limitation
				if(this.usedStorage+photoSize <= this.storage) {
					//add the photo size to the used storage
					this.usedStorage+=photoSize;
					
					//add the photo file to array list
					this.photoGallery.add(photoFileName);
					
					//add the photo size to array list
					this.photoSizes.add(photoSize);
					System.out.println("\n||Photo captured and saved: "+photoFileName+" "+photoSize+" MB||");
				}else {
					System.out.println("\n||Not enough storage to save: "+photoFileName+" "+photoSize+" MB||");
				}
			}else {
				System.out.println("\n||Error, "+photoFileName+" can not save because it has a duplicate||");
			}
		}else {
			System.out.println("\n||Please turn ON the Smart Phone first||");
		}
	}
	
	//DELETE PHOTO
	public void DeletePhoto(int index) {
		simulateConsumption=0.1;
		//the number of photo must be in the range of 0 to array list size
		if(index > 0 && index < photoGallery.size()) {
			//remove the photo from the array list
			photoGallery.remove(index-1);	
			
			//decrease the used storage
			this.usedStorage=this.usedStorage-photoSizes.get(index-1);	
			
			//remove the size of the selected photo
			photoSizes.remove(index-1);		
			System.out.println("\n||Photo"+index+" has been deleted||");
			DisplayGallery();
		}else {
			System.out.println("\n||No photo number was found||");
		}
	}
	
	//DISPLAY GALLERY
	public void DisplayGallery() {
		if(this.isPowerOn==true) {
			simulateConsumption=0.1;
			this.isGalleryOn=!this.isGalleryOn; //turn on the gallery
			if(this.isGalleryOn==true) {
				System.out.println("\n");
				
				//display each photo's and their sizes from the array list
				for(int count1=0; count1<photoGallery.size(); count1++) {
					System.out.println(photoGallery.get(count1)+"\t"+photoSizes.get(count1)+" MB");
				}
				
				//print the status/properties of the storage
				System.out.println("\n||Used storage: "+this.usedStorage+" MB");
				System.out.println("\n||Available storage: "+(this.storage-this.usedStorage)+" MB");
			}else {
				System.out.println("\n||Returned to the camera||");
			}
			
		}else {
			System.out.println("\n||Please turn ON the Smart Phone first||");
		}
	}
	
	public static double ComputeForCalculator(double answer, String input) {
		//INITIALIZATION
		char []operators= {'*','/','+','-'};
		char inputOperator=' ';
		int indexOperator=0;
		String firstString;
		String secondString;
		double firstNum = 0;
		double secondNum = 0;
		
		//GET THE OPERATOR:
		//LOOP FOR INPUT STRING
		for(int count1=0; count1<input.length(); count1++) {			
			//LOOP FOR ARRAY ELEMENTS
			for(int count2=0; count2<operators.length; count2++) {		
				//IF THE INPUT STRING HAS THE SAME CHARACTER FROM THE ARRAY ELEMENTS
				if(input.charAt(count1) == operators[count2]) {		
					inputOperator = input.charAt(count1);		//INITIALIZE THE VARIABLE WITH OPERATOR VALUE
					indexOperator = count1;						//INITIALIZE THE VALUE FOR THE INDEX OF OPERATOR
				}
			}
		}
		
		//GET THE FIRST NUMBER
		//substring from 0 to index of operator
		firstString = input.substring(0, indexOperator);
		if(firstString.equals("")) {
			//default value if there is no first number
			firstString = "0";
		}
		firstNum = Double.parseDouble(firstString); //string to double
		
		//GET THE SECOND NUMBER
		//substring from after the index operator to the rest
		secondString = input.substring(indexOperator+1);
		secondNum = Double.parseDouble(secondString);
		
		//CALCULATE THE NUMBERS USING THE SPECIFIC OPERATOR
		if(inputOperator == '*') {
			answer*=firstNum;
			answer*=secondNum;
		}else if(inputOperator == '/') {
			answer/=firstNum;
			answer/=secondNum;
		}else if(inputOperator == '+') {
			answer+=firstNum;
			answer+=secondNum;
		}else if(inputOperator == '-') {
			answer-=firstNum;
			answer-=secondNum;
		}
		
		return answer;
	}
	
}		