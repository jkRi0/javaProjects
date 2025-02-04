package finalsWeek15_Polymorphism;

import java.util.List;
import java.util.ArrayList;
public class Student {
	//CLASSFIELDS
	private String name;
	private int age;
	private int studentId;
	private List<String>enrolledCourse = new ArrayList<String>();
	
	//CONSTRUCTORS
	public Student(String name, int age, int studentId) {
		this.name = name;
		this.age = age;
		this.studentId = studentId;
	}
	
	public Student(String name, int age, int studentId, String str1, String str2) {
		this.name = name;
		this.age = age;
		this.studentId = studentId;
	}
	
	//GETTERS AND SETTERS
	public List<String> getEnrolledCourse(){
		return this.enrolledCourse;
	}
	
	public String getName() {
		return this.name;
	}
	
	//METHODS
	public void EnrollInCourse(String courseName) {
		//VALIDATE IF THE COURSE NAME WAS ALREADY ON THE LIST
		if(!this.enrolledCourse.contains(courseName)) {
			this.enrolledCourse.add(courseName);
		}else
			System.out.println("The course name was already on the list");
	}
	
	public String DisplayDetails() {
		return "Student name: "+this.name+
				"\nAge: "+this.age+
				"\nStudent ID: "+this.studentId;		
	}
	
	public String GetEnrolledCourses() {
		String list="";
		for(String course:this.enrolledCourse)
			list+="- "+course+" (Instructor: Dr. John Doe)\n";
		return list;
	}
	
	public String DisplayEnrollmentDetails() {
		String str="";
		for(String course:this.getEnrolledCourse())
			str+="\n"+course;
		return str;
	}
}
