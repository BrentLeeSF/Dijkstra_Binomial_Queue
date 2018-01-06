package project4;


public class BinomialQueue {


	private Link[] linkListArray;
	private int bqSize;
	Link root;
	

	/** Create linked list size of graph, and set nodes to null */
	public BinomialQueue(int size) {
		
		linkListArray = new Link[size];
		bqSize = 0;
		root = null;
		
		for(int i = 0; i < size; i++) {
			linkListArray[i] = null;
		}
		
	}

	/** Creates new Link and inserts into linkedListArray. 
	 * Calls merge to merge with links in BQ, and combine to place in proper order based on input */
	public  void insertElem(int value, int priority){

		Link newLink = new Link(value, priority, 0, null, null, null);
		linkListArray[newLink.getValue()] = newLink;
		bqSize++;
		
		root = merge(root,newLink);
	
		root = combine(root);

	}
	
	
	/** Merges the two 'heaps' (from individual nodes) by degree */
	public static Link merge(Link firstHeap, Link secondHeap) {
		
		/** Returns non-null heap */
		if(firstHeap == null) {
			return secondHeap;
			
		}else if(secondHeap == null) {
			return firstHeap;
			
		/** Merges heaps according to heaps (individual nodes) degree */ 
		} else if(firstHeap.getDegree() <= secondHeap.getDegree()) {
			firstHeap.setRightSib(merge(firstHeap.getRightSib(), secondHeap));
			return firstHeap;
			
		} else {
			secondHeap.setRightSib(merge(secondHeap.getRightSib(), firstHeap));
			return secondHeap;
		}
		
	}
	

	/** Combine nodes (or heaps) according to degree and priority to make BQ structure */
	public Link combine(Link newNode) {

		
		if(newNode != null) {			
			
			/** If single node */
			if(newNode.getRightSib() == null){
				return newNode;
				
			
			/** If NewNode & NewNode's Rights degrees do NOT match, 
			 * get new node's right, set newNode to have right with higher Degree */
			} else if(newNode.getDegree() != newNode.getRightSib().getDegree()) {
				
				Link newNodesRight = newNode.getRightSib();
				newNode.setRightSib(combine(newNodesRight));
				return newNode;
				
			
			/** NewNode & NewNode's Rights degrees DO match */
			} else {
				
				Link rightsSibling = newNode.getRightSib();			
				Link rightsSiblingRight = rightsSibling.getRightSib();

				/** If the degrees of NewNode's RightSib & NewNode's Right Right match, set newNodes Right with higher Degree */
				if((rightsSiblingRight != null) && (rightsSiblingRight.getDegree() == rightsSibling.getDegree())) {
					newNode.setRightSib(combine(rightsSibling));
					return newNode;
				
				/** Degrees of NewNode's Right and NewNode's RightRight do NOT match */
				} else {
						
					Link minPriority;
					Link maxPriority;

					/** Set Node with highest priority as max */
					if(newNode.getPriority() <= rightsSibling.getPriority()) {
							
						maxPriority = rightsSibling;
						minPriority = newNode;
							
					} else {
						maxPriority = newNode;
						minPriority = rightsSibling;
					}
					
					/** This restructures the BQ (looks like a tree, or a heap), increase min's degree, then returns to combine
					 * 
					 * Sets min priorty as parent, min's left set to max, min's right set to rightRight
					 * max priority's parent is min, and sets max's right to min's left */
					maxPriority.setParent(minPriority);
					maxPriority.setRightSib(minPriority.getLeftChild());
						
					minPriority.setLeftChild(maxPriority);
					minPriority.setRightSib(rightsSiblingRight);
						
					int thisDegree = minPriority.getDegree();
					minPriority.setDegree(thisDegree+1);
						
					return combine(minPriority);
						
				}
			}
			
		}
		
		return null;
	}
	

	/** Returns the smallest value (distance/miles) of BQ, then restructures BQ according to current
	 * nodes (heaps) degrees and priorities */
	public int removeSmallest(){
		
		if(root == null ){
			return -1;
		}
		
		/** returns node with lowest priority */
		Link temp = findMin();
		
		Link prev = null;
		Link curr = root; // start at root
		Link currRight = curr.getRightSib();
		
		/** Sets root's curr to temp (removed node with lowest priority) */ 
		while(curr != null){
			
			if(temp.equals(curr)){
				break;
			}
			prev = curr;
			curr = curr.getRightSib();
		}
		
		
		/** At the head of list. 
		 * If curr's prev is null (curr's previous RightSib), gets curr's leftChild and sends it to reverse
		 * reverse then sends back node with it's lowest degree (most right sib). 
		 * Then calls merge and combine to restructure BQ */
		if(prev == null) {
			
			currRight = curr.getRightSib();
			Link children = curr.getLeftChild();

			curr.setLeftChild(null);
			curr.setRightSib(null);

			/** returns node with lower degree than children */
			children = reverse(children);
			
			root = merge(children,currRight);
			root = combine(root);
			
		/** If currRight is null (root's original rightSib), get curr's left (as children), send 
		 * children to reverse to return children's node with lowest degree (most right sib)
		 * Then calls merge and combine to restructure BQ */
		} else if(currRight == null){
			
			Link children = curr.getLeftChild();
			children = reverse(children);
			
			root = merge(children,prev);
			
			root = combine(root);
			
		/** currRight and prev NOT null, so set prev's right to currRight and get curr's left as children
		 * to reverse to return children's node with lowest degree (most right sib) */
		} else {
			
			currRight = curr.getRightSib();
			Link children = curr.getLeftChild();
			
			curr.setLeftChild(null);
			curr.setRightSib(null);
			
			prev.setRightSib(currRight);
			
			children = reverse(children);
			
			root = merge(children,root);

			root = combine(root);
			
		}
		
		bqSize--;
		return temp.getValue();
		
	}

	
	/** Called from removeSmallest to remove link with smallest priority */
	public Link findMin() {
		
		Link temp = root;
		Link min = temp;
		
		while(temp!= null){
			if(temp.getPriority() < min.getPriority()){
				min = temp;
			}
			temp = temp.getRightSib();
		}
		return min;
	}

	
	/** Returns Node with lower degree. If there is no lower, returns currentNode as null */
	public Link reverse(Link currentNode) {
		
		Link prev = null;
		Link current = currentNode;
		Link next = null;
		
		while(current != null) {
			
			next = current.getRightSib();
			current.setRightSib(prev);
			prev = current;
			current = next;
			
		}
		
		currentNode = prev;
		return currentNode;
		
	}

	
	/** After the smallest value (index of mileage/distance from table) has been removed, 
	 * we get passed the neighbor of the value removed as the new table index (newIndex)
	 * (from Driver) in this case it's from the linkListArray 
	 * 
	 * We basically move the newLink as parent node of BQ */
	public void decreaseKey(int newIndex, int newPriority){
		
		Link newNode = linkListArray[newIndex];
		newNode.setPriority(newPriority);
		int parentValue = 0, parentPriority = 0;
		
		while(newNode.getParent() != null && newNode.getParent().getPriority() > newNode.getPriority()) {
			
			parentValue = newNode.getParent().getValue();
			parentPriority = newNode.getParent().getPriority();
			
			swap(newIndex,parentValue);

			newNode.getParent().setValue(newNode.getValue());
			newNode.getParent().setPriority(newNode.getPriority());

			newNode.setValue(parentValue);
			newNode.setPriority(parentPriority);

			newNode = newNode.getParent();
			newIndex = newNode.getValue();
		}
	}

	
	/** Swaps positions of links in listArray. Called from decreaseKey */
	public void swap(int pos1, int pos2) {
		
		Link tmp = linkListArray[pos1];

		linkListArray[pos1] = linkListArray[pos2];
		linkListArray[pos2] = tmp;
		
	}

	
	/** called from Driver, Test, and in main() on this file. 
	 * Prints BQ as tree structure with highest degree as parent */
	public void printQueue() {
		printQueue(root,0);
	}
	
	
	/** See printQueue() above */
	public void printQueue(Link root, int offset) {

		if(root != null) {
			
			for (int i = 0; i < offset; i++) {
				System.out.print("  ");
			}
			System.out.println("Value: " + root.getValue() + ", Priority: " +root.getPriority()+ ", Degree "+root.getDegree());
			printQueue(root.getLeftChild(), offset+1);
			printQueue(root.getRightSib(), offset);
		}
	}
	
	
	/** returns true if BQ has no more nodes left */
	public boolean bqEmpty() {
		return bqSize == 0;
	}
	

	/** USED FOR TESTING BINOMIAL QUEUE FUNCTIONS!
	 * To run this program, run on Driver_Dijkstra.
	 * To test entire program, go to Test.java */
	public static void main(String[] args) {
		
		
		BinomialQueue bq = new BinomialQueue(16);
		System.out.println("empty?: "+bq.bqEmpty());

		for (int i = 0; i < 16; i++) {
			bq.insertElem(i, i);
		}
		
		bq.insertElem(0, 0);
		bq.insertElem(4, 4);
		bq.insertElem(3, 3);

		bq.insertElem(2, 2);
		bq.insertElem(1, 1);
		System.out.println("***Insert");
		bq.printQueue();
		System.out.println();

		bq.insertElem(6, 6);
		bq.insertElem(7, 7);

		bq.insertElem(8, 8); // 8
		System.out.println("***Insert More");
		bq.printQueue();
		System.out.println();

		bq.insertElem(5, 5);
		bq.insertElem(11, 11);
		bq.insertElem(15, 15);
		bq.insertElem(3, 3); // 12
		bq.insertElem(9, 9);
		bq.insertElem(12, 12);
		bq.insertElem(14, 14);
		bq.insertElem(10, 10); // 16
		System.out.println("***Insert 3 Times");
		bq.printQueue();
		System.out.println();
		

		bq.decreaseKey(4, 5);
		System.out.println("AFTER DECREASE DEGREES of 4 & 5");
		bq.printQueue();
		System.out.println();
		
		bq.removeSmallest();
		System.out.println("REMOVE MIN");
		bq.printQueue();
		System.out.println();
		
		bq.removeSmallest();
		System.out.println("REMOVE MIN");
		bq.printQueue();
		System.out.println();

	}

}

