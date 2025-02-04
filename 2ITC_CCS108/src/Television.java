
public class Television {
	
	int volumeLevel = 1;
	int channel = 1;
	boolean isPowerOn = false;
	boolean isMute = false;
	
	public void SwitchedPower() {
		this.isPowerOn = !this.isPowerOn;
		System.out.println(this.isPowerOn == true ? "\n||Power switched ON||":"\n||Power switched OFF||");
		this.PrintDetails();
		
	}
	
	public void IncreaseVolume() {
		if(this.isPowerOn == true) {
			if(this.volumeLevel < 10) {
				this.volumeLevel++;
				System.out.println("\n||Increased volume level||");
			}else {
				System.out.println("\n||Maximum volume level has been reached||");
			}
		}else {
			System.out.println("\n||Cannot increase the volume. Please turn on the TV.||");
		}
		this.PrintDetails();
	}
	public void DecreaseVolume() {
		if(this.isPowerOn == true) {
			if(this.volumeLevel > 1) {
				this.volumeLevel--;
				System.out.println("\n||Decreased volume level||");
			}else {
				System.out.println("\n||Minimum volume level has been reached||");
			}
		}else {
			System.out.println("\n||Cannot decrease the volume. Please turn on the TV.||");
		}
		this.PrintDetails();
	}
	
	public void IncreaseChannel() {
		if(this.isPowerOn == true) {
			System.out.println("\n||Increased channel||");
			if(this.channel < 10) {
				this.channel++;
			}else {
				this.channel=1;
			}
		}else {
			System.out.println("\n||Cannot increase the channel. Please turn on the TV.||");
		}
		this.PrintDetails();
	}
	public void DecreaseChannel() {
		if(this.isPowerOn == true) {
			System.out.println("\n||Decreased channel||");
			if(this.channel > 1) {
				this.channel--;
			}else {
				this.channel=10;
			}
		}else {
			System.out.println("\n||Cannot decrease the channel. Please turn on the TV.||");
		}
		this.PrintDetails();
	}
	
	public void SwitchMuteVolume() {
		if(this.isPowerOn == true) {
			System.out.println("\n||Volume Muted||");
			this.isMute = !this.isMute;
		}else {
			System.out.println("\n||Cannot mute the volume. Please turn on the TV.||");
		}
		this.PrintDetails();
	}
	
	public void PrintDetails() {
		System.out.println("VOLUME LEVEL: "+this.volumeLevel);
		System.out.println("CHANNEL: "+this.channel);
		System.out.println("POWER: "+(this.isPowerOn==true? "ON":"OFF"));
		System.out.println("MUTE: "+(this.isMute==true? "ON":"OFF"));
	}
	
	
	
}
