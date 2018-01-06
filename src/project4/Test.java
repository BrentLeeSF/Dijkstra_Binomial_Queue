package project4;


public class Test {

	
	public static void testPriorityQueue() {
		
		
		int size = 31;
		BinomialQueue Q = new BinomialQueue(size);

		for (int i = 0; i < size; i++) {
			Q.insertElem(i, i);
		}
		
		Q.printQueue();
		size = 1000;
		Q = new BinomialQueue(size);
		
		for (int i = 0; i < size; i++) {
			Q.insertElem(i, size-i);
		}
		
		boolean errorFound = false;
		
		for (int i = 0; i < size; i++) {
			
			if (size - i - 1 != Q.removeSmallest()) {
				errorFound = true;
			}
		}
		
		if (errorFound) {
			System.out.println("Error on removeSmallest (and / or insertElem)");
			
		} else {
			System.out.println("removeSmallest OK");
		}
		
		Q = new BinomialQueue(size);
		
		for (int i = 0; i < size; i++) {
			Q.insertElem(i, 3 * size-i);
		}
		
		for (int i = 0; i < size; i++) {
			Q.decreaseKey(i, i + 1);
		}

		errorFound = false;
		
		for (int i = 0; i < size; i++) {

			int next = Q.removeSmallest();
			
			if (i !=  next) {
				System.out.println(i);
				System.out.println(next);
				errorFound = true;
			}
		}
		
		if (errorFound) {
			System.out.println("Error on decreaseKey (and / or insertElem / removeSmallest)");
			
		} else {
			System.out.println("decreaseKey OK");
		}

	}


	public static void testHashTable() {
		
		HashTable H = new HashTable(10);
		int size = 500;

		for (int i = 0; i < size; i++) {
			
			String key = Integer.toString(i) +"_" +  Integer.toString(i);
			H.insert(new Integer(i), key);
			
		}
		
		boolean errorFound = false;
		
		for (int i = 0; i < size; i++) {
			
			String key = Integer.toString(i) +"_" +  Integer.toString(i);
			
			if (H.find(key) == null || !H.find(key).equals(new Integer(i))) {
				errorFound = true;
			}
		}
		
		if (errorFound) {
			System.out.println("Error in insert / find");
			
		} else {
			
			System.out.println("HashTable insert / find both look good");
		}

		for (int i = 0; i < size; i = i + 2) {
			
			String key = Integer.toString(i) +"_" +  Integer.toString(i);
			H.delete(key);
			
		}
		
		errorFound = false;
		
		for (int i = 0; i < size; i = i + 2) {
			
			String key = Integer.toString(i) +"_" +  Integer.toString(i);
			
			if (i % 2 == 0) {
				
				if (H.find(key) != null) {
					errorFound = true;
				}
				
			} else if(H.find(key) == null || !H.find(key).equals(new Integer(i))) {
				errorFound = true;
			}
		}
		
		if (errorFound) {
			
			System.out.println("Error in HashTable delete (or insert / find)");
			
		} else {
			System.out.println("HashTable delete looks good");
			
		}

	}

	public static void main(String args[]) {
		
		testPriorityQueue();
		testHashTable();
	}
	
}


