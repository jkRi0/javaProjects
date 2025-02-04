package finalsWeek13_Aggregation;
public class Employee {
	//CLASSFIELDS
	private int employeeId;
	private String employeeName;
	private String position;
	private double salary;
	
	
	//CONSTRUCTORS
	public Employee(int employeeId, String name, String position, double salary) {
		this.employeeId = employeeId;
		this.employeeName = name;
		this.position = position;
		this.salary = salary;
	}
	
	//METHODS
	public void DisplayInfo() {
		System.out.println("NAME: "+this.employeeName);
		System.out.println("ID: "+this.employeeId);
		System.out.println("POSITION: "+this.position);
		System.out.println("SALARY: $"+this.salary+"\n");
	}

}
