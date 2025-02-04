
public class Student {
	int id;
	String firstName;
	String lastName;
	public Student() {}
	public Student(int id) {
		this.id = id;
	}
	public Student(int id, String firstName) {
		this.id = id;
		this.firstName = firstName;
	}
	public Student(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public void Display() {
		System.out.println("ID: "+this.id);
		System.out.println("FIRST NAME: "+this.firstName);
		System.out.println("LAST NAME: "+this.lastName+"\n");
	}
}
