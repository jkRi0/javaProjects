package finalsWeek15_Polymorphism;

public class GraduateStudent extends Student{
	//CLASSFIELDS
	private String researchTopic;
	private String advisor;
	
	//CONSTRUCTORS
	public GraduateStudent(String name, int age, int studentId) {
		super(name, age, studentId);
	}
	
	public GraduateStudent(String name, int age, int studentId, String researchTopic, String advisor) {
		super(name, age, studentId);
		this.researchTopic = researchTopic;
		this.advisor = advisor;
	}
	

	//METHODS
	public String DisplayDetails() {
		return super.DisplayDetails()+
				"\nReaserch Topic: "+this.researchTopic+
				"\nAdvisor: "+this.advisor+
				"\nEnrolled Courses: "+super.DisplayEnrollmentDetails();
	}
	
	public String DisplayEnrollmentDetails() {
		String str="";
		for(String course:super.getEnrolledCourse())
			str+="\nGraduate Student "+super.getName()+
				" has enrolled in "+course;
		return str;
	}
}
