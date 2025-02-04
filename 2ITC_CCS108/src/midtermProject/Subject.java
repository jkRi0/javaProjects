package midtermProject;

public class Subject {
	private int id;
    private String subjectName;
    private int units;

    public Subject(int id, String subjectName, int units) {
        this.id = id;
        this.subjectName = subjectName;
        this.units = units;
    }

    public int getId() {
        return this.id;
    }
  
  	public String getSubjectName(){
      	return this.subjectName;
    }
  
  	public int getUnits(){
       	return this.units;
    }
    	    
    public String toString() {
        return 	"Subject ID: " + this.id + "\nName: " +
        		this.subjectName + "\nUnits: " + this.units;
    }
}
