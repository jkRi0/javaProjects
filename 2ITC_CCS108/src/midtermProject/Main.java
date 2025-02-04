package midtermProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Student> students = new ArrayList<>();
	static List<Subject> subjects = new ArrayList<>();
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("\n[1] create new student record");
			System.out.println("[2] create new subject record");
			System.out.println("[3] enlist the subject to student");
			System.out.println("[4] remove the subject from a student");
			System.out.println("[5] display details of the student");
			System.out.println("[6] display all details of all student");
			System.out.println("[7] Display all Student details enlisted in a selected subject");
			System.out.println("[8] Exit");
			System.out.print("Enter the number of your choice: ");
			int chosen = scan.nextInt();
			switch(chosen) {
                
                
         	case 1:
    			boolean studentExists;
   	 			do {
        			studentExists = false;
        			// Creating Student Record
        			// Student ID       
        			System.out.print("Enter Student ID: ");
        			int studentId = scan.nextInt();
        			scan.nextLine();
        
        			// FirstName
        			System.out.print("Enter First Name: ");
        			String firstName = scan.nextLine();
        
        			// LastName
        			System.out.print("Enter Last Name: ");
        			String lastName = scan.next();
      
         			//Course
    				System.out.print("Enter Course: ");
    				String course = scan.next();

        			// Check if a student with the same ID and full name already exists
        			for (Student existingStudent : students) {
            			if (existingStudent.getId() == studentId &&
                			existingStudent.getFirstName().equals(firstName) &&
                			existingStudent.getLastName().equals(lastName)) {
                			studentExists = true;
                			System.out.println("Student with the same ID and full name already exists. Please try again.");
                			break;
            			}
        			}

        			if (!studentExists) {
            			Student newStudent = new Student(studentId, firstName, lastName, course);
            			students.add(newStudent);
            			System.out.println("\nStudent record created successfully.");
        			}
    			} while (studentExists);
    			break;

			case 2:
                int newID;
				while (true) {
					scan.nextLine();
					System.out.print("Enter subject ID (3 digits only): ");
            		String id = scan.nextLine();

            		if (id.matches("\\d{3}")) {
                		newID = Integer.parseInt(id);
                		break; 
            		} else {
                		System.out.println("Invalid input. Please enter a 3-digit subject ID.");
           			}
        		}

       		 	System.out.println("You entered a valid subject ID: " + newID);    

				System.out.print("Enter subject Name: ");
				String subName = scan.nextLine();
		
				System.out.print("Enter subject units: ");
				int units = scan.nextInt();
						
				subjects.add(new Subject(newID, subName, units));
                System.out.println("\nNew subject has been recorded.");
                scan.nextLine();
				break;
                
			case 3:
				System.out.print("\nEnter a valid student ID: ");
				int studentIndexID = ValidateUserInput(scan, true);
				System.out.print("Enter a valid subject ID: ");
				int subjectIndexID = ValidateUserInput(scan, false);
				
				//IF THE STUDENT ENLISTED SUBJECT LIST DOES NOT CONTAIN WITH THE ENTERED SUBJECT
				if(students.get(studentIndexID).getEnlistedSubjects().contains(subjects.get(subjectIndexID))) {
					System.out.println("\nThe selected subject was already enlisted.");
				}else {
					//ENLIST THE SELECTED SUBJECT TO THE ENLISTED SUBJECT LIST OF THE STUDENT
					students.get(studentIndexID).enlist(subjects.get(subjectIndexID));
					System.out.println("\nThe subject was successfully enlisted.");
				}
				break;
                
			case 4:
				System.out.print("\nEnter a valid student ID: ");
				int studentIndexID2 = ValidateUserInput(scan, true);
				System.out.print("Enter a valid subject ID: ");
				int subjectIndexID2 = ValidateUserInput(scan, false);
				
				//IF THE SUBJECT WAS ON THE LIST OF ENLISTED SUBJECT OF THE STUDENT
				if(students.get(studentIndexID2).getEnlistedSubjects().contains(subjects.get(subjectIndexID2))) {
					//REMOVE THE SUBJECT TO LIST OF ENLISTED SUBJECT OF THE STUDENT
					students.get(studentIndexID2).removeEnrollment(subjects.get(subjectIndexID2));
					System.out.println("\nThe subject was successfully removed.");
				}else {
					System.out.println("\nThe selected subject was not found on the list of enlisted subjects.");
				}
                break;
                
			case 5:
				System.out.println("Enter Student ID:");
				int studentIdToDisplay = scan.nextInt();
				for(Student student : students){
						System.out.println(student.toString());
						System.out.println(student.getEnlistedSubjects());		
				   }
				
				break;
                
			case 6:
				if (students.size() == 0) {
		            System.out.println("No students in the list.");
		        } else {
		            // Display details of all students
		            for (Student student : students) {
		                System.out.println("Student Details:");
		                System.out.println(student);

		                // Check if the enlisted subjects list is empty for the current student
		                if (student.getEnlistedSubjects().size() == 0) {
		                    System.out.println("No enlisted subjects for this student.");
		                } else {
		                    System.out.println("Enlisted Subjects:");
		                    for (Subject subject : student.getEnlistedSubjects()) {
		                        System.out.println(subject);
		                    }
		                }
		                System.out.println();
		            }
		        }
				break;
			case 7:
				Scanner scanner = new Scanner(System.in);
		        System.out.print("Enter subject ID: ");
		        int subjectId = ValidateUserInput(scanner, false);
		        Subject subject = subjects.get(subjectId);
		        if (subject == null) {
		            System.out.println("Subject not found.");
		            return;
		        }
		        System.out.println("Students enlisted in " + subject.getSubjectName() + ": ");
		        for (Student student : students) {
		            if (student.getEnlistedSubjects().contains(subject)) {
		                System.out.println("ID: " + student.getId());
		                System.out.println("First Name: " + student.getFirstName());
		                System.out.println("Last Name: " + student.getLastName());
		                System.out.println("Course: " + student.getCourse());
		                System.out.println();
		            }
		        }
				break;
                
			case 8:
                System.out.println("\nThe program ended...");
				System.exit(0);
				break;
			default:
				System.out.println("\nNone of the options, please choose again.");
			}//END OF SWITCH STATEMENT
		}//END OF WHILE LOOP
	}
	
	public static int ValidateUserInput(Scanner scan, boolean studentList) {
		int objectIndex = -1;
		//DETERMINE THE REQUIRED LIST SIZE
		int listSize = students.size();
		if(studentList == false) {
			listSize = subjects.size();
		}
		
		//IF THE USER INPUT IS INTEGER
		if(scan.hasNextInt()) {
			//CREATE A VARIABLE FOR USER INPUT
			int id = scan.nextInt();
			//GET THE INDEX OF THE OBJECT ON THE LIST
			int value = SearchToTheList(id, studentList);
			//VERIFYING THE VALUE IF ITS ON THE RANGES OF THE LIST
			if(value >= 0 && value < listSize) {
				//SET THE VALUE AS THE INDEX OF THE OBJECT THAT CONTAINS THE ID
				objectIndex = value;
			}else {
				System.out.println("\nInvalid entered ID, please try again.");
				main(null);
			}
		}else {
			System.out.println("\nInput must be integer, please try again.");
			main(null);
		}
		return objectIndex;
	}
	
	public static int SearchToTheList(int id, boolean studentList) {
		int objectIndex = -1;
		//SEARCH THROUGH THE LIST IF ITS HAS THE ENTERED ID
		//SEARCH FOR STUDENT LIST 
		if(studentList == true) {
			//COMPARING THE ENTERED ID TO THE ID's ON THE LIST
			for(int count = 0; count < students.size(); count++) {
				if(students.get(count).getId() == id) {
					objectIndex = count;
				}
			}
			
		}
		//SEARCH FOR SUBJECT LIST
		if(studentList == false) {
			for(int count = 0; count < subjects.size(); count++) {
				if(subjects.get(count).getId() == id) {
					objectIndex = count;
				}
			}
		}
		return objectIndex;
	}
}