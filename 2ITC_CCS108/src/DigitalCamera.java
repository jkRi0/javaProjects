import java.util.ArrayList;
import java.util.List;

public class DigitalCamera {
	//class field
	String brand;
	int storageCapacity;
	int usedStorage;
	boolean isPowerOn = false;
	boolean isGalleryOn = false;
	List<String> photoGallery = new ArrayList<>();
	List<Integer> photoSizes = new ArrayList<>();
	
	public void SwitchedPower() {
		this.isPowerOn = !this.isPowerOn;
		System.out.println(this.isPowerOn == true ? "||Power switched ON||":"||Power switched OFF||");
	}
	
	//class method
	public void CapturePhoto(String photoFileName, int photoSize) {
		if(this.isPowerOn==true) {
			if(!photoGallery.contains(photoFileName)) {
				if(this.usedStorage+photoSize <= this.storageCapacity) {
					//save the file name to the list
					this.usedStorage+=photoSize;
					this.photoGallery.add(photoFileName);
					this.photoSizes.add(photoSize);
					System.out.println("||Photo captured and saved: "+photoFileName+" "+photoSize+" MB||");
				}else {
					System.out.println("||Not enough storage to save: "+photoFileName+" "+photoSize+" MB||");
				}
			}else {
				System.out.println("||Error, "+photoFileName+" can not save because it has a duplicate||");
			}
		}else {
			System.out.println("||Please turn ON the digital camera first||");
		}
	}
	public void DeletePhoto(int index) {
		if(index > 0 && index < photoGallery.size()) {
			photoGallery.remove(index-1);	//remove the photo from the array list
			this.usedStorage=this.usedStorage-photoSizes.get(index-1);	//decrease the used storage
			photoSizes.remove(index-1);		//remove the size of the selected photo
			System.out.println("||Photo"+index+" has been deleted||");
			DisplayPhotoGallery();
		}else {
			System.out.println("||No photo number was found||");
		}
	}
	public void DisplayPhotoGallery() {
		if(this.isPowerOn==true) {
			this.isGalleryOn=!this.isGalleryOn; //turn on the gallery
			if(this.isGalleryOn==true) {
				System.out.println("\n||Photo gallery for: "+this.brand);
				for(int count1=0; count1<photoGallery.size(); count1++) {
					System.out.println(photoGallery.get(count1)+"\t"+photoSizes.get(count1)+" MB");
				}
				System.out.println("||Used storage: "+this.usedStorage+" MB");
				System.out.println("||Available storage: "+(this.storageCapacity-this.usedStorage)+" MB");
			}else {
				System.out.println("||Gallery was turned off");
			}
			
		}else {
			System.out.println("||Please turn ON the digital camera first||");
		}
	}
	
	
}
