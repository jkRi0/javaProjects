package GraphDataStructure;

public class Graph {
	private List vertices;
	
	public Graph() {
		this.vertices = new List();
	}
	
	//METHOD FOR ADDING A VERTEX TO THE GRAPH
	public void addVertex(int data) {
		Vertex vertex = new Vertex(data);
		vertices.add(vertex);
	}
	
	//METHOD TO ADD AN EDGE BETWEEN TWO VERTICES
	public void addEdge(int data1, int data2) {
		Vertex v1 = findVertex(data1);
		Vertex v2 = findVertex(data2);
		if(v1!=null && v2!=null) {
			v1.getNeighbors().add(v2);
			v2.getNeighbors().add(v1);
		}else {
			System.out.println("One or more vertices not found.");
		}
	}
	
	//METHOD FOR FINDING THE EXISTANCE OF A VERTEX IN THE GRAPH
	//TO PREVENT DISCONNECTED GRAPH or edges
	public Vertex findVertex(int data) {
		for(int i=0; i<vertices.getSize(); i++) {
			if(vertices.getVertex(i).getData() == data) {
				return vertices.getVertex(i);
			}
		}
		return null;
	}

	public void displayGraph() {
		for(int i=0; i<vertices.getSize(); i++) {
			System.out.println("\nVertex: "+vertices.getVertex(i).getData());
			System.out.print("Neighbors: ");
			for(int j=0; j<vertices.getVertex(i).getNeighbors().getSize(); j++) {
				System.out.print(vertices.getVertex(i).getNeighbors().getVertex(j).getData()+" ");
			}
			System.out.println();
		}
	}
}

