package finalsWeek13_Aggregation;
public class Main {

	public static void main(String[] args) {
		//CREATING OBJECTS FOR DEPARTMENT
		Department objDepartment1 = new Department(1, "HR");
		Department objDepartment2 = new Department(2, "IT");
		
		//FIRST DEPARTMENT
		Employee objEmployee1 = new Employee(1, "James", "Manager", 5000.5);
		Employee objEmployee2 = new Employee(2, "Jhon", "Manager", 100.0);
		Employee objEmployee3 = new Employee(3, "Hannah", "Manager", 560.89);
		objDepartment1.AddEmployee(objEmployee1);
		objDepartment1.AddEmployee(objEmployee2);
		objDepartment1.AddEmployee(objEmployee3);
		
		//DISPLAYING ALL THE EMPLOYEE
		objDepartment1.DisplayEmployee();
		objDepartment2.DisplayEmployee();
		
		//SECOND DEPARTMENT
		Employee objEmployee4 = new Employee(4, "Rodolfo", "Manager", 505.8);
		Employee objEmployee5 = new Employee(5, "Brandon", "Manager", 500);
		Employee objEmployee6 = new Employee(6, "Jake", "Manager", 5069.5);
		objDepartment2.AddEmployee(objEmployee4);
		objDepartment2.AddEmployee(objEmployee5);
		objDepartment2.AddEmployee(objEmployee6);
		
		//REMOVING AN EMPLOYEE
		objDepartment2.RemoveEmployee(objEmployee5);
		
		//DISPLAYING ALL THE EMPLOYEE
		objDepartment2.DisplayEmployee();
		
		
		
	}

}
