package GraphDataStructure;

public class List {
	private Vertex[] vertices;	//more likely the storage for neighbors
	private int size;
	
	public List() {
		vertices = new Vertex[5];
		size = 0;
	}
	
	//METHOD FOR ADDING A VERTEX TO THE LIST
	public void add(Vertex vertex) {
		ensureCapacity();
		vertices[size++] = vertex;
	}
	
	//METHOD FOR CHECKING THE CAPACITY OF THE LIST
	private void ensureCapacity() {
		if(size==vertices.length) {
			Vertex[] temp = new Vertex[size*2];
			for(int i=0; i<size; i++) {
				temp[i]=vertices[i];
			}
			vertices = temp;
		}
	}
	
	//GET METHODS
	public Vertex getVertex(int i) {
		return vertices[i];
	}
	
	public int getSize() {
		return size;
	}
}
