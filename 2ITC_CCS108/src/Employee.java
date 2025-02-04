public class Employee {
	//CLASSFIELD
	String name;
	int age;
	double salary;
	
	//DEFAULT CONSTRUCOTOR
	public Employee() {
		this.name = "Unkown";
		this.age = 0;
		this.salary = 0.0;
	}
	
	//PARAMETERIZED CONSTRUCTOR
	public Employee(String name, int age) {
		this();
		this.name = name;
		this.age = age;
	}
	
	public Employee(String name, int age, double salary) {
		this(name, age);
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	//DISPLAY DETAILS
	public void DisplayInfo() {
		System.out.println("NAME: "+this.name);
		System.out.println("AGE: "+this.age);
		System.out.println("SALARY: "+this.salary+"\n");
	}
}
