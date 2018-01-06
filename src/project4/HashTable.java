package project4;



public class HashTable {
	
	
	int tableSize;
	Vertex[] table;

	
	/** Creates array of vertexes size of length and sets size */
	HashTable(int length) {
		
		table = new Vertex[length];
		setSize(length);
	}
	
	
	/** Used to map data of arbitrary size to data of fixed size.
	 * Called in find and delete */
	static long ELFhash(String key, int tablesize) {
		
		long h = 0, g = 0;
		int i = 0;
		
		for (i = 0; i < key.length(); i++) {
			
			h = (h << 4) + (int)key.charAt(i);
			g = h & 0xF0000000L;
			
			if (g != 0) 
				h ^= g >>> 24;
			
			h &= ~g;
		}
		
		return h % tablesize;
	}
	

	/** Receives city as string, and returns index of city in vertex array */
	public Integer find(String key) throws IllegalArgumentException {

		int hash = (int)ELFhash(key, table.length);
		
		if(table[hash] == null) {
			return null;
			
		} else {
			
			Vertex temp = table[hash];
			
			while(temp != null && !temp.getKey().equalsIgnoreCase(key)) {
				temp = temp.getNext();
			}

			return temp.getValue();			
		}	
	}

	/** Receives city as string, gets index of city in table
	 * sets current table entry as table entries next vertex */
	public void delete(String key) {

		int hash = (int)ELFhash(key, table.length);

		if(table[hash] == null) {
			return;
			
		} else if(table[hash].getKey().compareTo(key) == 0) {
			table[hash] = table[hash].getNext();
			
		} else {
			
			Vertex temp = table[hash];
			
			while(temp.getNext() != null) {
				
				if(temp.getNext().getKey().compareTo(key) == 0) {
					temp.setNext(temp.getNext().getNext());
					break;
					
				} else {
					temp = temp.getNext();
				}	
			}
		}
	}

	
	/** Receives city as key, and index as value and inserts into table as vertex */
	public void insert(int value, String key) {
	
		int hash = (int)ELFhash(key, table.length);
		Vertex curr = null;
		
		if(table[hash] == null) {
			
			Vertex newVertex = new Vertex(key, value, null);
			table[hash] = newVertex;	
			
		} else {
			
			curr = table[hash];
			
			while(curr.getNext() != null) {
				curr = curr.getNext();
			}
			
			Vertex v = new Vertex(key, value, null);
			curr.setNext(v);
			v.setNext(null);
			
		}
	}
	
	public void setSize(int tableSize) {
		this.tableSize = tableSize;
	}
	
	public int getTableSize() {
		return tableSize;
	}
	
}

