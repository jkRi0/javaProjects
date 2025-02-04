package midterm;

public class MainPerson {
	public static void main(String[] args) {
		//CREATING AN INSTANCE OF THE PERSON
		Person objPerson = new Person("asd","qwerty",-2);
		
		//DISPLAY THE PERSON's INFORMATION
		objPerson.DisplayInfo();
		
		//UPDATING THE AGE AND FIRSTNAME
		objPerson.setAge(18);
		objPerson.setFirstName("James");
		
		//DISPLAY THE UPDATED INFORMATION
		objPerson.DisplayInfo();
	}
}
