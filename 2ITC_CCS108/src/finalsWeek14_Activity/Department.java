package finalsWeek14_Activity;
import java.util.List;
import java.util.ArrayList;

public class Department {
	//CLASSFIELDS
	private int departmentId;
	private String departmentName;
	private List<Employee> employeeList;
	private Company company;
	
	//CONSTRUCTORS
	public Department(int id, String name) {
		this.departmentId = id;
		this.departmentName = name;
		this.employeeList = new ArrayList<Employee>();
	}
	
	//GETTERS AND SETTERS
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public List<Employee> getEmployeeList(){
		return this.employeeList;
	}

	//METHODS
	public void AddEmployee(Employee employee) {
		employeeList.add(employee);
		employee.setDepartment(this);//TO GET AWARE OF ITS WHOLE
	}
	
	public void RemoveEmployee(Employee employee) {
		employeeList.remove(employee);
	}
	
	public String GetDepartmentDetails() {
		return "\n   DEPARTMENT ID: "+this.departmentId+
				"\n   DEPARTMENT NAME: "+this.departmentName;
	}
	
	public String GetFullDetails() {
		return this.GetDepartmentDetails()+"\n"+this.GetAllEmployee();
	}
	
	public String GetDepartmentWithCompanyDetail() {
		return "\nCOMPANY NAME: "+this.company.getCompanyName()+this.GetDepartmentDetails();
	}
	
	public String GetAllEmployee() {
		String list="";
		for(Employee employee:this.employeeList) {
			list+=employee.GetEmployeeDetails()+"\n";
		}
		return list;
	}
	
}
