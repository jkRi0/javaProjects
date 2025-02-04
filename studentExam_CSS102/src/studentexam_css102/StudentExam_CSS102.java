package studentexam_css102;
import java.util.Scanner;
public class StudentExam_CSS102 {
    static String courseName, name="BSIT";
    static void setCourseName(String name){
        courseName=name;
    }
    static String getCourseName(){
        return courseName;
    }
    static void displayMessage(){
        System.out.println("Welcome to the grade book for:\n"+
                getCourseName()+"\n");
    }
    public static void main(String[] args) {
        displayMessage();
        Scanner key=new Scanner(System.in);
        int passes=0, failures=0, studentCounter=1;
        while(studentCounter <=10){
            System.out.print("Student number "+studentCounter+
                    " Exam result: ");
            String result=key.next();
            if(result.equals("passed")){
                passes=passes+1;
            }
            else if(result.equals("failed")){
                failures=failures+1;
            }
            studentCounter=studentCounter+1;
        }
        System.out.println("\nnumber of passes: "+passes);
        System.out.println("number of failures: "+failures);
        if(passes>8){
            System.out.println("Bonus to instructor");
        }
    }
}
