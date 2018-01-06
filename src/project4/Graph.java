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
	
}

