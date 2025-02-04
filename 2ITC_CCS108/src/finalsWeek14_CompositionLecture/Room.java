package finalsWeek14_CompositionLecture;

public class Room {
	//class fields
	private int id;
	private String description;
	private double length;
	private double width;
	public House house;
	
	public Room() {}
	//constructor
	public Room(int id, String description, double length, double width) {
		this.id = id;
		this.description = description;
		this.length = length;
		this.width = width;
	}
	
	public House getHouse() {
		return this.house;
	}
	
	public void setHouse(House house) {
		this.house = house;
	}
	
	//method to compute and return the floor area of a room
	private double ComputeFloorArea() {
		return (this.length * this.width);
	}
	
	//method to generate and return the details of a room
	public String GetRoomDetails(){
		return "\nROOM DETAILS : \n" +
				"**************\n" +
				"ID : " + this.id + "\n" +
				"DESCRIPTION : " + this.description + "\n" +
				"FLOOR AREA : " + this.ComputeFloorArea() + " meters";

	}
	
}
