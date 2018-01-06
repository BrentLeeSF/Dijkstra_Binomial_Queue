package project4;


public class LinkedList {


	private Link head, parent, leftChild, rightSib, current, next = null;
	private int length;
	

	public LinkedList() {
		
		head = parent = leftChild = rightSib = current = next = null;
		length = 0;
		// setHead(setParent(setLeftChild(setRightSib(null))));
		
	}

	public Link getHead() {
		return head;
	}

	public void setHead(Link head) {
		this.head = head;
	}

	public Link getParent() {
		return parent;
	}

	public Link setParent(Link parent) {
		
		this.parent = parent;
		return parent;
		
	}

	public Link getLeftChild() {
		return leftChild;
	}

	public Link setLeftChild(Link leftChild) {
		
		this.leftChild = leftChild;
		return leftChild;
		
	}

	public Link getRightSib() {
		return rightSib;
	}

	public void setRightSib(Link rightSib) {
		this.rightSib = rightSib;
		//return rightSib;
	}

	public void setNext(Link nextelem) {
		next = nextelem;
	}

	public Link getNext() {
		return next;
	}

	public int size() {
		return length;
	}

	/*
	public Link get(int index) {
		
		Link current = head;
		
		for (int i = 0; i < index && current != null; i++) {
			current = current.getNext();
		}
		
		if (current == null) {
			return null;
		}
		return current;
	}*/
	
	
	public Link getCurrent() {
		return current;
	}

	/*
	public void add(Link elem) {
		
		current = head;
		
		if(head == null) {
			head = elem;
			
		} else {
			
			elem.setNext(head);
			head.setRightSib(elem);
			head = elem;
			
		}
		
		length++;
		
	}*/
	
}

