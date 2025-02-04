package finalsWeek14_Activity;
import java.util.List;
import java.util.ArrayList;

public class Company {
	//CLASSFIELDS
	private String companyName;
	private List<Department> departmentList;
	private int departmentCount = 1;
	
	//CONSTRUCTORS
	public Company(String name) {
		this.companyName = name;
		this.departmentList = new ArrayList<Department>();
	}
	
	//GETTERS
	public String getCompanyName() {
		return this.companyName;
	}
	
	public List<Department> getDepartmentList(){
		return this.departmentList;
	}
	
	//METHODS
	public void AddDepartment(String name) {
		Department objDepartment = new Department(departmentCount, name);
		this.departmentList.add(objDepartment);
		this.departmentCount++; //FOR AUTOMATIC ID INITIALIZATION
		objDepartment.setCompany(this); //TO GET AWARE OF ITS WHOLE
	}
	
	public void RemoveDepartment(Department department) {
		this.departmentList.remove(department);
	}
	
	public String GetAllDepartment() {
		String list="";
		//CONCATENATE EVERY DETAILS
		for(Department department:this.departmentList) {
			list+=department.GetFullDetails()+"\n";
		}
		return list;
	}
	
	public String GetFullDetails() {
		return "\nCOMPANY NAME: "+this.companyName+"\n"+this.GetAllDepartment();
	}
	
}
