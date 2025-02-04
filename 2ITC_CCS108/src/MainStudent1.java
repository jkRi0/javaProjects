
public class MainStudent1 {

	public static void main(String[] args) {
		//create an object
		StudentStatic objStudent1 = new StudentStatic(1, "John Doe");
		objStudent1.Display();
		
		StudentStatic objStudent2 = new StudentStatic(2, "James Smith");
		objStudent2.Display();
		
		StudentStatic.ChangeUniversityName("UC");
		
		objStudent1.Display();
		objStudent2.Display();
		
	}

}
