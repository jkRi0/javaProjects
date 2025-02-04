package SetDataStructure;

public class Main {

	public static void main(String[] args) {
		// Creating a custom set of integers
		CustomSet<Integer> mySet = new CustomSet<>();

		// Adding elements to the set
		mySet.add(1);
		mySet.add(2);
		mySet.add(10);
		mySet.add(4);
		mySet.add(2);
		mySet.add(6);
		// Displays the elements of the set
		System.out.print("\nThe elements are: ");
		mySet.display();
		// Checks if the set contains the element 2
		if(mySet.contains(2))
		System.out.print("\nThe set has element 2.");
		else
		System.out.print("\nThe set does not have element 2.");

		// Removing an element from the set
		mySet.remove(1);
		mySet.remove(2);
		mySet.remove(5);
		// Display the set elements after the remove operations
		System.out.print("\nThe updated elements of the set are: ");
		mySet.display();

	}

}
