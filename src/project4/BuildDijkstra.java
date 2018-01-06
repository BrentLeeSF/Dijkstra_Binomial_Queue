package project4;

public class BuildDijkstra {


	public Node[] table;
	
	
	public BuildDijkstra(int dijkSize) {
		
		table = new Node[dijkSize];
		
		for(int i = 0; i < dijkSize; i++) {
			table[i] = new Node();
		}
	}
	
	public Node[] returnTable() {
		return table;
	}
	
	
}