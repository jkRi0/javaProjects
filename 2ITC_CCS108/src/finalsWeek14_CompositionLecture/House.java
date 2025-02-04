package finalsWeek14_CompositionLecture;

import java.util.ArrayList;
import java.util.List;
public class House {
	//class fields
	private int id;
	private String address;
	private List<Room> listRooms = new ArrayList<Room>();
	private int roomCounter=1;
	
	//constructor
	public House(int id, String address) {
		this.id = id;
		this.address = address;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	//method to create a new Room object inside a House object
	public void AddRoom(String description, double length, double width) {
		Room newRoom = new Room(this.roomCounter, description, length, width);
		this.listRooms.add(newRoom);
		this.roomCounter++;
		newRoom.setHouse(this);
	}
	
	//method to return the list of room details
	public String GetRoomList() {
		String rooms = "";
		//loop through the elements of listRooms
		for(Room room : this.listRooms) {
			rooms += room.GetRoomDetails() + "\n";
		}
		return rooms;
	}
	
	//method to generate and return the details of a house
	public String GetHouseDetails(){
		return "HOUSE DETAILS : \n" +
				"**************\n" +
				"ID : " + this.id + "\n" +
				"ADDRESS : " + this.address;
		
	}	
	
	//method to generate and return the details of a house including its rooms
	public String GetFullDetails(){
		return this.GetHouseDetails() + "\n" +
				this.GetRoomList();

	}
}
