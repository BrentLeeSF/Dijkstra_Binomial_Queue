package project4;

public class Link {

	private int value;
	private Link parent;
	private int priority;
	private int degree;
	private Link rightSib;
	private Link leftChild;
	private int element;
	private Link next;

	public Link(int value, int priority, int degree, Link parent, Link leftChild, Link rightSib) {
		
		this.value = value;
		this.priority = priority;
		this.degree = degree;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightSib = rightSib;
		
	}

	public Link(int value, int priority, int degree) {
		
		this.value = value;
		this.priority = priority;
		this.degree = degree;
		
	}
	
	public Link() {
		
	}
	
	public Link(int degree) {
		this.degree = degree;
	}

	public int element() {
		return element;
	}

	public void setElement(int newelement) {
		element = newelement;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Link getParent() {
		return parent;
	}

	public void setParent(Link parent) {
		this.parent = parent;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public Link getRightSib() {
		return rightSib;
	}

	public void setRightSib(Link rightSib) {
		this.rightSib = rightSib;
	}

	public Link getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Link leftChild) {
		this.leftChild = leftChild;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}
	
	
}
