package finalsWeek14_Activity;

public class Main {

	public static void main(String[] args) {
		//INSTANTIATION FOR COMPANY OBJECT
		Company myCompany = new Company("XYZ Inc.");
		
		//ADDING OR INSTANTIATION THE DEPARTMENT INSIDE THE COMPANY
		myCompany.AddDepartment("Human Resources");
		myCompany.AddDepartment("Information Technology");
		
		//INSTANTIATION OF EACH EMPLOYEE TO THEIR RESPECTIVE DEPARTMENT ON THE COMPANY
		myCompany.getDepartmentList().get(0).AddEmployee(new Employee(101, "James", "Manager", 500.5));
		myCompany.getDepartmentList().get(0).AddEmployee(new Employee(102, "Sarah", "Specialist", 150.25));
		
		myCompany.getDepartmentList().get(1).AddEmployee(new Employee(201, "Bob", "Manager", 1000.0));
		myCompany.getDepartmentList().get(1).AddEmployee(new Employee(202, "Micheal", "Developer", 789.80));
		
		//PRINT THE FULL DETAILS OF THE COMPANY
		System.out.println(myCompany.GetFullDetails());
		
		//PRINT ALL THE DETAILS OF EMPLOYEE WITH THEIR RESPECTIVE DEPARTMENT
		System.out.println("**********************************************");
		System.out.println(myCompany.getDepartmentList().get(0).getEmployeeList().get(0).GetFullDetails());
		System.out.println(myCompany.getDepartmentList().get(0).getEmployeeList().get(1).GetFullDetails());
		System.out.println(myCompany.getDepartmentList().get(1).getEmployeeList().get(0).GetFullDetails());
		System.out.println(myCompany.getDepartmentList().get(1).getEmployeeList().get(1).GetFullDetails());
		
		//PRINT EVERY DEPARTMENT WITH ITS COMPANY DETAIL
		System.out.println("**********************************************");
		System.out.println(myCompany.getDepartmentList().get(0).GetDepartmentWithCompanyDetail());
		System.out.println(myCompany.getDepartmentList().get(1).GetDepartmentWithCompanyDetail());
	}

}
