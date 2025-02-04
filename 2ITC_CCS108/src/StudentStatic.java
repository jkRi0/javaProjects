
public class StudentStatic {
	//class fields (common properties but the value is not shared)
	int id;
	String name;
	
	//static variable
	private static String universityName = "Pnc";
	
	public StudentStatic() {
		System.out.println("hello bruhhh");
	}
	
	public StudentStatic(int id) {
		this.id = id;
	}
	
	//parameterized constructor
	public StudentStatic(int id, String name) {
		this(id);
		this.name = name;
	}
	
	
	
	//static method
	public static void ChangeUniversityName(String universityName) {
		StudentStatic.universityName = universityName;
	}
	
	public void SayHello() {
		System.out.println("HElloo..");
	}
	
	//class method
	public void Display() {
		System.out.println("ID: "+this.id);
		System.out.println("NAME: "+this.name);
		System.out.println("UNIVERSITY: " + StudentStatic.universityName+"\n");
		this.SayHello();
	}
	
}
