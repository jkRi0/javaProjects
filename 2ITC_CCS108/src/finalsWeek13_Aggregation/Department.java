package finalsWeek13_Aggregation;

import java.util.List;
import java.util.ArrayList;
public class Department {
	//CLASSFIELDS
	private int departmentId;
	private String departmentName;
	private List<Employee> employees;
	
	
	//CONSTRUCTORS
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		employees = new ArrayList<Employee>();
	}
	
	//METHODS
	public void AddEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void RemoveEmployee(Employee employee) {
		employees.remove(employee);
	}
	
	public void DisplayEmployee() {
		System.out.println("\n-----------------------------------");
		if(employees.size() != 0) {
			System.out.println("Employees in the "+this.departmentName+
					" department (Department ID: "+this.departmentId+"):");
			for(Employee employee: employees) {
				employee.DisplayInfo();
			}
		}else {
			System.out.println("The "+this.departmentName+" department has no employee.");
		}	
	}
}
