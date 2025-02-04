package SetDataStructure;


/*

The most commonly used type parameter names are:
E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
S,U,V etc. - 2nd, 3rd, 4th types

 */
//GENERIC CLASS, 
public class CustomSet<T> {
	private Object[] elements;
	private int size;
	// class constructor
	public CustomSet() {
		elements = new Object[5];
		size = 0;
	}
	// method for adding a unique element to the set
	public void add(T element) {
		if (!contains(element)) {
			ensureCapacity();
			elements[size++] = element;
		}
	}
	// method for checking if the element to be added is unique
	public boolean contains(T element) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
	// method for adjusting the capacity of the array as needed
	private void ensureCapacity() {
		if (size == elements.length) {
			Object[] temp = new Object[size * 2];
			for(int i = 0; i<size; i++){
				temp[i] = elements[i];
			}
			elements = temp;
		}
	}

	// method for displaying the elements in the set
	public void display() {
		for(int i=0; i<size; i++)
			System.out.print(elements[i].toString() + " ");
	}
	// method for removing an element from the set
	public void remove(T elementToDelete) {
		// Find the index of the element to delete
		int indexToDelete = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(elementToDelete)) {
				indexToDelete = i;
				break;
			}
		}
		// If the element is found, shift elements to the left
		if (indexToDelete != -1) {
			for (int i = indexToDelete; i < size - 1; i++) {
				elements[i] = elements[i + 1];
			}
			size--;
		}
	}
	
	
}
