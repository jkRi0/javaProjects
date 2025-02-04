package midtermProject;
import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int id;
    private String firstName;
    private String lastName;
    private String course;
    private List<Subject> enlistedSubjects;

    public Student(int id, String firstName, String lastName, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.enlistedSubjects = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public String getCourse() {
    	return this.course;
    }

    public void enlist(Subject subject) {
        this.enlistedSubjects.add(subject);
    }

    public void removeEnrollment(Subject subject) {
        this.enlistedSubjects.remove(subject);
    }

    public List<Subject> getEnlistedSubjects() {
        return this.enlistedSubjects;
    }
  
    public String toString() {
        return "\nStudent ID: " + this.id +
               "\nName: " + this.firstName + " " + this.lastName +
               "\nCourse: " + this.course;
    }
}

