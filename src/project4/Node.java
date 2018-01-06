package project4;



public class Node {
	

	private int distance;
	private int path;
	private boolean known;
	
	
	//TODO called in BuildDijkstra
	public Node() {
		
		this.setDistance(Integer.MAX_VALUE);
		this.setPath(-1);
		this.setKnown(false);
		
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPath() {
		return path;
	}

	public void setPath(int path) {
		this.path = path;
	}

	public boolean getKnown() {
		return known;
	}

	public void setKnown(boolean known) {
		this.known = known;
	}
	
	
}
