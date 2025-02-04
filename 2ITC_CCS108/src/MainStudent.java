
public class MainStudent {

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.Display();
		
		Student student2 = new Student(2201592);
		student2.Display();
		
		Student student3 = new Student(2201573, "Micheal");
		student3.Display();
		
		Student student4 = new Student(2201554, "Elliot", "Anderson");
		student4.Display();
	}

}
