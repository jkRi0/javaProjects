package finalsWeek15_Polymorphism;

public class UndergraduateStudent extends Student{
	//CLASSFIELDS
	private String major;
	private String year;
	
	//CONSTRUCTORS
	public UndergraduateStudent(String name, int age, int studentId) {
		super(name, age, studentId);
	}
	
	public UndergraduateStudent(String name, int age, int studentId, String major, String year) {
		super(name, age, studentId);
		this.major = major;
		this.year = year;
	}
	
	//METHODS
	public String DisplayDetails() {
		return 	super.DisplayDetails()+
				"\nMajor: "+this.major+
				"\nYear: "+this.year+
				"\nEnrolled Courses: "+super.DisplayEnrollmentDetails();
	}
	
	public String DisplayEnrollmentDetails() {
		String str="";
		for(String course:super.getEnrolledCourse())
			str+="\nUndergraduate Student "+super.getName()+
				" has enrolled in "+course;
		return str;
	}
}
