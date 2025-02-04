package GraphDataStructure;

public class Vertex {
	private int data;
	private List neighbors;
	
	public Vertex(int data) {
		this.data = data;
		this.neighbors = new List();
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public List getNeighbors() {
		return this.neighbors;
	}
}
