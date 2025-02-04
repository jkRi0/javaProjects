public class MainGradingPeriod {
	public static void main(String[]args) {
		
		//PRELIM
		int quizzesPCT=20;				
		int participationPCT=10;		
		int otherRequirementsPCT=20;	
		int examPCT=50;					
		int labExercisesPCT=40;			
		int labexamPCT=60;
		GradingPeriod prelim=new GradingPeriod(quizzesPCT
				,participationPCT
				,otherRequirementsPCT
				,examPCT
				,labExercisesPCT
				,labexamPCT);
		System.out.print("\nComputed Prelim Grade: ");
		prelim.ComputePeriodGrade();
		double prelimGrade = prelim.periodGrade;
		System.out.print("\nRemarks: ");
		prelim.DisplayRemarks();
		
		
		//MIDTERM
		//without laboratory
		quizzesPCT=18;
		participationPCT=9;
		otherRequirementsPCT=15;
		examPCT=45;
		GradingPeriod midterm=new GradingPeriod(quizzesPCT
				,participationPCT
				,otherRequirementsPCT
				,examPCT);
		System.out.print("\nComputed Midterm Grade: ");
		midterm.ComputePeriodGrade();
		double midtermGrade = midterm.periodGrade;
		System.out.print("\nRemarks: ");
		midterm.DisplayRemarks();
		//for midterm standing
		double midStanding = ComputeMidStanding(prelimGrade,midtermGrade);
		System.out.print("\nComputed Midterm Standing: "+ midStanding);
		System.out.print("\nRemarks: "+DisplayRemarks(Double.toString(midStanding)));
				
		
		//FINALS
		quizzesPCT=19;
		participationPCT=8;
		otherRequirementsPCT=18;
		examPCT=46;
		labExercisesPCT=38;
		labexamPCT=56;
		GradingPeriod finals=new GradingPeriod(quizzesPCT
				,participationPCT
				,otherRequirementsPCT
				,examPCT
				,labExercisesPCT
				,labexamPCT);
		System.out.print("\nComputed Final Grade: ");
		finals.ComputePeriodGrade();
		double finalGrade = finals.periodGrade;
		System.out.print("\nRemarks: ");
		finals.DisplayRemarks();
		//for semestral grade
		double semGrade = ComputeSemGrade(prelimGrade,midtermGrade,finalGrade);
		System.out.print("\nComputed Semestral Grade: "+semGrade);
		System.out.print("\nRemarks: "+DisplayRemarks(Double.toString(semGrade)));
		
	}
	//
	public static double ComputeMidStanding(double prelimGrade, double midtermGrade) {
		double midStandingGrade;
		return midStandingGrade = (prelimGrade + midtermGrade)/2;
		
	}
	
	public static double ComputeSemGrade(double prelimGrade, double midtermGrade, double finalGrade) {
		double semGrade;
		return semGrade = (prelimGrade + midtermGrade + finalGrade)/3;
		
	}
	public static String DisplayRemarks(String forRemark) {
		String remark;
		if(Double.parseDouble(forRemark)>=60 && Double.parseDouble(forRemark)<=100) {
			return remark="PASSED\n";
		}else {
			return remark="FAILED\n";
		}
	}
}
