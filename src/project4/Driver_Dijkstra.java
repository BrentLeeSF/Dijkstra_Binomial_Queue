package project4;



public class Driver_Dijkstra {
	
	/** This program can be run from this file, or tested in Test.java */

	public static void main(String[] args) {
		
		
		/** Parses file (as args) to create hash table and create graph. Prints results as adjacency list */
		ParseArgs parse = new ParseArgs(args);
		System.out.println("PRINT GRAPH"+"\n");
		parse.printGraph();
		
		/** gets all edges as a graph, and creates new table with distance=max, path=-1, and known=false */
		Edge[] graph = parse.returnEdgeArray();
		Node[] newTable = new Node[graph.length];
		newTable = buildNewTable(newTable, graph.length);
		
		/** Initiates BQ and removes from BQ */
		buildBQ(graph, 0, newTable);

	}
	
	/** Builds table to be used to create BQ */
	public static Node[] buildNewTable(Node[] table, int graphLength) {
		
		table = new Node[graphLength];
		
		for(int i = 0; i < graphLength; i++) {
			table[i] = new Node();
		}
		return table;
	}

	/** Initiate and insert BQ. Then remove smallest priority and get shortest distance between nodes */
	public static void buildBQ(Edge[] graph, int initial, Node[] table) {
		
		int vert = 0;
		Edge thisEdge = null;
		
		BinomialQueue bq = new BinomialQueue(graph.length);
		
		/** Inserts initial index of SF with distance of zero */
		table[initial].setDistance(0);
		bq.insertElem(0, 0);

		/** Inserts into BQ with max distance */
		for(int i = 1; i < graph.length; i++) {
			bq.insertElem(i, table[i].getDistance());
		}
		
		/** Continually removes the link with the smallest value (distance or miles) until empty.
		 * if distance of table's neighbor is greater than the removed node's distance + edge's miles,
		 * Set table's neighbor's distance to removed node's distance + edge's miles (to find shortest path)
		 * Remove it (decreaseKey) from the BQ and rearrange BQ according to 
		 * Then set table's neighbor's path to removed priority */
		while(!bq.bqEmpty()) {
			
			vert = bq.removeSmallest();
			table[vert].setKnown(true);
		
			
			for(thisEdge = graph[vert]; thisEdge != null; thisEdge = thisEdge.getNext()) {
					
				if(table[thisEdge.getNeighbor()].getDistance() > table[vert].getDistance() + thisEdge.getMiles()) {
					
					table[thisEdge.getNeighbor()].setDistance(table[vert].getDistance() + thisEdge.getMiles());
					
					bq.decreaseKey(thisEdge.getNeighbor(), table[thisEdge.getNeighbor()].getDistance());
					
					table[thisEdge.getNeighbor()].setPath(vert);
					
				}
			}
			System.out.println("New BQ");
			bq.printQueue();
			System.out.println();
		}
		
	}
	
}

