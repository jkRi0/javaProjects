package midterm;

public class Person {
	//CLASS FIELDS
	private String firstName;
	private String lastName;
	private int age;
	
	//CONSTRUCTOR
	Person(String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		setAge(age);
	}
	
	//SETTERS
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAge(int age) {
		//the age must be greater than zero
		if(age > 0) {
			this.age = age;
		}else {
			this.age = 0;
		}
	}
	
	//GETTERS
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	//METHODS
	public String GetFullName() {
		//Concatenate the first and last name
		return firstName+" "+lastName;
	}
	
	public void DisplayInfo() {
		System.out.println("\nFull Name: " + GetFullName());
		System.out.println("Age: " + this.age);
		//ternary operator if age was less than zero
		System.out.println(this.age <= 0? "There is no such age like that!":"");
	}
}
