package finals;

//STATIC POLYMORPHSIM - method overloading
class A{
	private String sampleVariable="heyy";
	
	public String getVar() {
		return this.sampleVariable;
	}
	
	public int Add(int num1, int num2) {
		return num1+num2;
	}
	
	public int Add(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
}


//DYNAMIC POLYMORPHISM - method overriding
class B extends A{
	public int Add(int num1, int num2) {
		return num1+num2+5555;
	}
}

//MAIN CLASS
public class Polymorphism {
	public static void main(String[] args) {
		//POLYMORPHISM IN OPERATORS
		//concatenation for strings
		String A = "abcd";
		String B = "efgh";
		String C = A + B + " ijkl ";
		
		//mathematical expression for integers
		int D = 123;
		int E = 456;
		int G = D + E + 999;
		
		//compiler automatic convert to concatenate?
		C += 456;

		//print the first example of POLYMORPHISM
		System.out.println(C);
		System.out.println(G);
		
		//second example of POLYMORPHISM
		A a = new A();
		System.out.println(a.Add(D, E));
		System.out.println(a.Add(D, E, G));
		
		//third example of POLYMORPHISM
		B b = new B();
		System.out.println(b.Add(D, E)+"\n");	

		//POLYMORPHIC ARRAY
		Food []foods = new Food[2];
		foods[0] = new IceCream();
		foods[1] = new Burger();
		
		for(int count=0;count<foods.length;count++) {
			foods[count].Eat();
		}
		
		Food objFood = new Food();
		objFood.Eat();
	}
}

class Food{
	public void Eat() {
		System.out.println("yummy!");
	}
}

class IceCream extends Food{
	public void Eat() {
		System.out.println("cold!");
	}
}

class Burger extends Food{
	public void Eat() {
		System.out.println("hot!");
	}
}

