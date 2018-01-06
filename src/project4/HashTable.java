package project4;



public class HashTable {
	
	
	int tableSize;
	Vertex[] table;
	Vertex[] arr;

	//TODO called in Parse
	HashTable(int length) {
		
		table = new Vertex[length];
		arr = new Vertex[length];
		setSize(length);
	}
	
	/*
	public void createStuff(int size) {
		
		for (int i = 0; i < tableSize; i++) {
			
			table[i] = null;
			arr[i]  = null;
			
		}
	}*/

	//TODO - used here
	/** Used to map data of arbitrary size to data of fixed size */
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
	
	//TODO called in parse
	/**
	 * Returns location/index of city
	 * @param key
	 * @return
	 * @throws IllegalArgumentException
	 */
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

		// 1 elf for index
		// if hash table sub index is null, else itereate through until find node
		// return int in node

		/*for(Vertex v: table) {
			if(v.getKey().equalsIgnoreCase(key)) {
				return v.getValue();
			}
		}*/
	}

	
	public void delete(String key) {

		int hash = (int)ELFhash(key, table.length);

		if(table[hash] == null) {
			return;
			
		} else if(table[hash].getKey().compareTo(key) ==0) {
			
			//			&& table[hash].getNext() != null) {
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

		/*for(Vertex v: table) {
			if(v.getKey().equalsIgnoreCase(key)) {
				v.setKey(null);
			}
		}*/
	}

	
	//TODO called in parse
	/**
	 * 1. If string value in table is null, create vertex and insert into table and array
	 * 2. Else gets current vertex from table at index. Iterate until null. Create new
	 * vertex and set current's next to new vertex
	 * @param value
	 * @param key
	 */
	public void insert(int value, String key) {

		int hash = (int)ELFhash(key, table.length);
		Vertex curr = null;
		
		if(table[hash] == null) {
			
			Vertex newVertex = new Vertex(key, value, null);
			table[hash] = newVertex;
			arr[hash] = newVertex;	
			
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
	
	
	//TODO called in parse to print graph
	/**
	 * Return table (vertex array)
	 * @return
	 */
	/*public Vertex[] getTable() {
		return table;
	}*/

	
	/*public void printHash() {
		
		//System.out.println("Q*$(*Q^YQ(* "+table.length);
		for(int i = 0; i < table.length; i++) {
			
			if(table[i] != null) {
				
				while(table[i] != null) {
					
					System.out.println("Hash: "+i+ " "+table[i].getKey()+ ", "+table[i].getValue());
					table[i] = table[i].getNext();
				}
				
			}

		}

	}*/

	//TODO called here
	public void setSize(int tableSize) {
		this.tableSize = tableSize;
	}
	
	public int getTableSize() {
		return tableSize;
	}
	
}

