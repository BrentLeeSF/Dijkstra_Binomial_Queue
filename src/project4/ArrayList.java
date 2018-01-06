package project4;


public class ArrayList {
	

	private static final int DEFAULT_MAX_SIZE = 10;
	private int maxsize;
	private int currentSize;
	private Vertex data[];
	

	ArrayList() {
		
		maxsize = DEFAULT_MAX_SIZE;
		currentSize = 0;
		data = new Vertex[maxsize];
		
	}

	ArrayList(int maximumSize) {
		
		maxsize = maximumSize;
		currentSize = 0;
		data = new Vertex[maxsize];
		
	}

	public void clear() {
		currentSize = 0;
	}

	public int size() {
		return currentSize;
	}

	public void add(Vertex elem) {
		
		//Assert.notFalse(currentSize < maxsize,"List is full");
		data[currentSize] = elem;
		currentSize++;
		
	}

	public void add(int index, Vertex elem) {
		
		//Assert.notFalse(currentSize < maxsize, "List is full");
		//Assert.notFalse(index <= currentSize, "Can't insert outside bounds of array");
		
		for (int i = currentSize; i > index; i--) {
			data[i] = data[i-1];
		}
		
		data[index] = elem;
		currentSize++;
		
	}

	public Vertex get(int index) {
	//	Assert.notFalse(index >= 0 && index < currentSize, "Index not in list");
		return data[index];
	}

	public void remove(int index) {
		
	//	Assert.notFalse(index >= 0 && index < currentSize, "Index not in list");
		
		for (int i = index + 1; i < currentSize; i++) {
			data[i-1] = data[i];
		}
		
		currentSize--;
	}

	public void remove(Vertex elem) {
		
		int removeIndex;
		
		for (removeIndex = 0; removeIndex < currentSize && !elem.equals(data[removeIndex]); removeIndex++);
		
		if (removeIndex < currentSize) {
			remove(removeIndex);
		}
		
	}

	public ListIterator listIterator() {
		return new InnerIterator(0);
	}

	public ListIterator listIterator(int index) {
		return new InnerIterator(index);
	}

	
	private class InnerIterator implements ListIterator {

		private int nextIndex;

		public InnerIterator(int startingIndex) {
			nextIndex = startingIndex;
		}

		public Vertex next() {
		//	Assert.notFalse(nextIndex < currentSize, "No next element");
			return data[nextIndex++];
		}

		public boolean hasNext() {
			return nextIndex < currentSize && nextIndex >= 0;
		}

		public Vertex previous() {
		//	Assert.notFalse(nextIndex > 0, "No previous element");
			return data[--nextIndex];
		}

		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		public void set(Vertex value) {
		//	Assert.notFalse(nextIndex > 0, "No current element to set");
			data[nextIndex] = value;
		}

		public void add(Vertex elem) {
			
			int i = 0;
			//Assert.notFalse(currentSize < maxsize, "List is full");
			//Assert.notFalse((nextIndex >= 0 && nextIndex <= currentSize), "Iterator not in list");
			
			for (i = currentSize; i > nextIndex; i--) {
				data[i] = data[i-1];
			}
				
			data[nextIndex] = elem;
			nextIndex++;
			currentSize++;
			
		}

		public void remove() {
			
		//	Assert.notFalse(currentSize > 0, "List is empty");
		//	Assert.notFalse(nextIndex > 0 && nextIndex <= currentSize, "No current element to delete");
			for (int i = nextIndex; i < currentSize; i++)
				data[i-1] = data[i];
			
			currentSize--;
			nextIndex--;
			
		}
	}
}