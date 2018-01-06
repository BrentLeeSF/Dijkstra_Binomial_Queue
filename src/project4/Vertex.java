package project4;



public class Vertex {

	private String key;
	private int value;
	private int index;
	private int miles;
	private int distance;
	private String city;
	private Vertex next;
	private int torFalse;
	
	private boolean known;
	private String path;
	
	
	// vertex should have index and city
	// edge should have distance and next
	
	public Vertex(String key, int value, Vertex next) {
		
		this.key = key;
		this.value = value;
		this.setNext(next);
		
	}
	
	public Vertex(String city, int miles, int distance, Vertex next) {
		
		this.setCity(city);
		this.miles = miles;
		this.distance = distance;
		this.next = next;
		
	}
	
	public Vertex(int distance, String path, boolean known) {
		
		this.distance = distance;
		this.path = path;
		this.known = known;
		
	}
	
	public Vertex(int dist, int huh) {
		
		distance = dist;
		torFalse = huh;
		
	}
	
	public Vertex() {
		
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return key + ", " +value;
	}

	public Vertex getNext() {
		return next;
	}

	public void setNext(Vertex next) {
		this.next = next;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTorFalse() {
		return torFalse;
	}

	public void setTorFalse(int torFalse) {
		this.torFalse = torFalse;
	}

	public boolean getKnown() {
		return known;
	}

	public void setKnown(boolean known) {
		this.known = known;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}

