package finalsWeek14_Activity;

public class Employee {
	//CLASSFIELDS
	private int employeeId;
	private String employeeName;
	private String position;
	private double salary;
	private Department department;
	
	//CONSTRUCTOR
	public Employee(int id, String name, String position, double salary) {
		this.employeeId = id;
		this.employeeName = name;
		this.position = position;
		this.salary = salary;
	}
	
	//SETTERS AND GETTERS
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Department getDepartment() {
		return this.department;
	}
	
	//METHODS
	public String GetEmployeeDetails() {
		return "\n\tEMPLOYEE ID: "+this.employeeId+
				"\n\tEMPLOYEE NAME: "+this.employeeName+
				"\n\tEMPLOYEE POSITION: "+this.position+
				"\n\tEMPLOYEE SALARY: "+this.salary;
	}
	
	public String GetFullDetails() {
		return this.department.GetDepartmentDetails()+"\n"+this.GetEmployeeDetails();
	}
}
