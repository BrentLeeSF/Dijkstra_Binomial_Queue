package project4;


public interface ListIterator {  
	
    public Vertex next();
    public Vertex previous();
    public boolean hasNext();
    public boolean hasPrevious();
    public void add(Vertex elem);
    public void remove();
    public void set(Vertex value);
    
}
