
public class GradingPeriod {
	//CLASS FIELDS
	private int quizzesPCT;
	private int participationPCT;
	private int otherRequirementsPCT;
	private int examPCT;
	
	private int labExercisesPCT;
	private int labexamPCT;
	
	double periodGrade;
	
	
	//CONSTRUCTORS FOR PERIODICAL GRADE WITHOUT LABORATORY
	GradingPeriod(int quizzesPCT,
			int participationPCT,
			int otherRequirementsPCT,
			int examPCT){
		
		this.quizzesPCT = quizzesPCT;
		this.participationPCT = participationPCT;
		this.otherRequirementsPCT = otherRequirementsPCT;
		this.examPCT = examPCT;
		this.labExercisesPCT = 40;
		this.labexamPCT = 60;
	}
	//CONSTRUCTORS FOR PERIODICAL GRADE WITH LABORATORY
	GradingPeriod(int quizzesPCT,
			int participationPCT,
			int otherRequirementsPCT,
			int examPCT,
			int labExercisesPCT,
			int labexamPCT){
		
		this.quizzesPCT = quizzesPCT;
		this.participationPCT = participationPCT;
		this.otherRequirementsPCT = otherRequirementsPCT;
		this.examPCT = examPCT;
		this.labExercisesPCT = labExercisesPCT;
		this.labexamPCT = labexamPCT;
	}
	
	public void ComputePeriodGrade() {
		periodGrade=((quizzesPCT
				+participationPCT
				+otherRequirementsPCT
				+examPCT)*0.6)
				+((labExercisesPCT
				+labexamPCT)*0.4);
		System.out.printf("%.1f",periodGrade);
	}
	
	public void DisplayRemarks() {
		if(periodGrade>=60 && periodGrade<=100) {
			System.out.print("PASSED\n");
		}else {
			System.out.print("FAILED\n");
		}
	}
}	
	

