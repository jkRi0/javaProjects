package MidtermLaboratory_ArrayImplementation;
/*

Rioveros, Justine Ken D.
Sta. Ana, Juliana Louise M.
November 16, 2023
2IT-C

*/


public class Stack {
    // CLASSFIELDS
    private int[] elements;
    private int top;

    // CONSTRUCTOR FOR INITIALIZING THE SIZE
    public Stack(int size) {
        this.elements = new int[size];
        this.top = -1;
    }

    // GETTERS
    public int[] getArr() {
        return this.elements;
    }

    public int getTop() {
        return this.top;
    }

    // METHODS
    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.elements.length - 1;
    }

    public void push(int element) {
        if (this.isFull()) {
            System.out.println("\nStack is Full");
        } else {
            // INSERT THE ELEMENT TO THE ARRAY THAT HAS THE TOP VALUE AS INDEX
            this.elements[++this.top] = element;
        }
    }

    public int pop() {
        if (!this.isEmpty()) {
            // DELETE THE ELEMENT
            return this.elements[this.top--];
        } else {
            System.out.println("\nStack is Empty");
            return -1;
        }

    }

    public int peek() {
        // GET THE TOP ELEMENT FROM THE ARRAY
    	if (!this.isEmpty()) {
    		return this.elements[this.top];
        } else {
            System.out.println("\nStack is Empty");
            return -1;
        }
    }

    public void printStack() {
        if (!this.isEmpty()) {
            System.out.println("\nThe Elements:");
            // PRINT THE ARRAY ELEMENTS
            for (int i = 0; i <= this.top; i++) {
                System.out.print(this.elements[i] + " ");
            }
            System.out.println();
        }
    }
}
