package project4;


class Edge  {
	
	private int neighbor;
	private int miles;
	private Edge next;
	private int distance = Integer.MAX_VALUE;
	private int path;
	private boolean known;
	

	public Edge(int neighbor, Edge next) {
		
		this.setNeighbor(neighbor);
		this.setNext(next);
		this.setMiles(0);
		
	}

	public Edge(int neighbor, int miles, Edge next) {
		
		this.neighbor = neighbor;
		this.miles = miles;
		this.next = next;
		
	}
	
	
	public Edge(int distance, int path, boolean known) {
		
		this.distance = distance;
		this.setPath(path);
		this.setKnown(known);
		
	}
	
	public Edge() {
		
	}

	public int getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(int neighbor) {
		this.neighbor = neighbor;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public Edge getNext() {
		return next;
	}

	public void setNext(Edge next) {
		this.next = next;
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

