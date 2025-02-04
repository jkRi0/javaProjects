package finalsWeek15_Polymorphism;

public class Main {
	static int counter1=2000;
	static int counter2=3000;
	
	public static void main(String []args) {
		//INSTANTIATION OF STUDENT OBJECTS
		Student objStudent = new Student("Alice", 20, 1001);
		
		Main.counter1++;
		Student objStudent1 = new UndergraduateStudent("Bob",22, Main.counter1, "Computer Science", "3");
		
		Main.counter2++;
		Student objStudent2 = new GraduateStudent("Charlie",25,Main.counter2,"Machine Learning","Dr. Smith");
		
		
		//DISPLAYING OF DETAILS
		System.out.println(objStudent.DisplayDetails());
		System.out.println("\nUndergraduate Student Details:");
		System.out.println(objStudent1.DisplayDetails());
		System.out.println("\nGraduate Student Details:");
		System.out.println(objStudent2.DisplayDetails());


		//ENROLLMENT OF COURSES
		objStudent1.EnrollInCourse("introduction to Java Programming");
		objStudent1.EnrollInCourse("Data Structures and Algorithms");

		objStudent2.EnrollInCourse("Advanced Machine Learning");
		objStudent2.EnrollInCourse("Deep Learning Reaserch");
		
		//DISPLAYING OF ENROLLMENT DETAILS
		System.out.println(objStudent1.DisplayEnrollmentDetails());
		System.out.println(objStudent2.DisplayEnrollmentDetails());
		Main.DisplayCourseInformation(objStudent1);
		Main.DisplayCourseInformation(objStudent2);
				
	}
	
	//TO DISPLAY ENROLLMENT INFORMATION
	public static void DisplayCourseInformation(Student student) {
		System.out.println("\nCourse Information for "+student.getName());
		System.out.println(student.GetEnrolledCourses());
	}
}
