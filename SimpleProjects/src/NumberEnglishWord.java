
public class NumberEnglishWord {
	
	public static void main(String[] args) {
		String stringNum="123";
		System.out.println(solution(stringNum));
	}
	
	public static String solution(String input) {
		String[]ones= {"zero","one","two","three","four","five","six","seven","eight","nine"};
		String[]teens={"ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
		String[]tens= {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		String[]placeValue= {"hundred","thousand","million","billion"};
		String[]reverseString=new String[input.length()];
		String output="";
		
		if(1<=Long.parseLong(input) && Long.parseLong(input)<=Power(2)) {
			//DETERMINE THE PLACE VALUE
			int placeValueIndex=DeterminePlaceValue(input);
			
//			//CONCATINATION OF ENGLISH NUMBER WORDS
//			for(int count=0; count<input.length(); count++) {
//				
//			}
			System.out.println(placeValueIndex);
			
		}else {
			System.out.println("exceed the limit");
		}
		
		return output;
	}
	
	public static long Power(int n) {
		long pow=1;
		for(int count=0; count<39; count++) {
			pow=n*pow;
		}
		return pow;
	}
	
	public static int DeterminePlaceValue(String value) {
		int zeroCount=0;
		int count1=3;
		for(int count=0; count<value.length(); count++) {
			if(count==count1) {
				count1+=3;
				zeroCount++;
			}
		}
		return zeroCount;
	}
}
