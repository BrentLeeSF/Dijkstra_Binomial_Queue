package project4;


public class Graph {

	
	public int numVertex;
	public Edge edges[];

	
	public Graph(int numVerteces)  {
		
		numVertex = numVerteces;
		edges = new Edge[numVerteces];
		
		for (int i = 0; i < numVertex; i++) {
			edges[i] = null;
		}
	}
	
	// build edge
	// get index of vertex, use index to go into edges array
	// iterate to end of edges linked list,
	// create new edge
	
	public void build(Vertex vert) {
		
		Edge temp = new Edge();
		int index = vert.getIndex();	
		temp = edges[index];
		
		while(temp != null) {
			
			temp = temp.getNext();
		}
		
		Edge newEdge = new Edge();
		newEdge = temp;
		
		//edges[i_seattle] = node(sf, 100)
		//edges[i_sf] = node(seattle, 100)
	}
	
}

