/** Doubly linked list with nodes of type DNode storing strings. */
public class DList {
  protected int size;			// number of elements
  protected DNode header, trailer, head;	// sentinels
  /** Constructor that creates an empty list */
  
  /** Node of a doubly linked list of strings */
  public static class DNode {
    protected String element;	// String element stored by a node
    protected DNode next, prev;	// Pointers to next and previous nodes
    /** Constructor that creates a node with given fields */
    public DNode(String e, DNode p, DNode n) {
      element = e;
      prev = p;
      next = n;
    }
    /** Returns the element of this node */
    public String getElement() { return element; }
    /** Returns the previous node of this node */
    public DNode getPrev() { return prev; }
    /** Returns the next node of this node */
    public DNode getNext() { return next; }
    /** Sets the element of this node */
    public void setElement(String newElem) { element = newElem; }
    /** Sets the previous node of this node */
    public void setPrev(DNode newPrev) { prev = newPrev; }
    /** Sets the next node of this node */
    public void setNext(DNode newNext) { next = newNext; }
  }
  
  public DList() { 
    size = 0;
    header = new DNode(null, null, null);	// create header
    trailer = new DNode(null, header, null);	// create trailer
    header.setNext(trailer);	// make header and trailer point to each other
  }
  /** Returns the number of elements in the list */
  public int size() { return size; }
  /** Returns whether the list is empty */
  public boolean isEmpty() { return (size == 0); }
  /** Returns the first node of the list */
  public DNode getFirst() throws IllegalStateException {
    if (isEmpty()) throw new IllegalStateException("List is empty");
    return header.getNext();
  }
  /** Returns the last node of the list */
  public DNode getLast() throws IllegalStateException {
    if (isEmpty()) throw new IllegalStateException("List is empty");
    return trailer.getPrev();
  }
  /** Returns the node before the given node v. An error occurs if v
    * is the header */
  public DNode getPrev(DNode v) throws IllegalArgumentException {
    if (v == header) throw new IllegalArgumentException
      ("Cannot move back past the header of the list");
    return v.getPrev();
  }
  /** Returns the node after the given node v. An error occurs if v
    * is the trailer */
  public DNode getNext(DNode v) throws IllegalArgumentException {
    if (v == trailer) throw new IllegalArgumentException
      ("Cannot move forward past the trailer of the list");
   return v.getNext();
  }
  


  /** Inserts the given node z before the given node v. An error
    * occurs if v is the header */
  public void addBefore(DNode v, DNode z) throws IllegalArgumentException {
    DNode u = getPrev(v);	// may throw an IllegalArgumentException
    z.setPrev(u);
    z.setNext(v);
    v.setPrev(z);
    u.setNext(z);
    size++;
  }
  /** Inserts the given node z after the given node v. An error occurs
    * if v is the trailer */
  public void addAfter(DNode v, DNode z) {
    DNode w = getNext(v);	// may throw an IllegalArgumentException
    z.setPrev(v);
    z.setNext(w);
    w.setPrev(z);
    v.setNext(z);
    head = z;
    size++;
  }
  /** Inserts the given node at the head of the list */
  public void addFirst(DNode v) {
    addAfter(header, v);
  }
  /** Inserts the given node at the tail of the list */
  public void addLast(DNode v) {
    addBefore(trailer, v);
  }
  /** Removes the given node v from the list. An error occurs if v is
    * the header or trailer */
  public void remove(DNode v) {
    DNode u = getPrev(v);	// may throw an IllegalArgumentException
    DNode w = getNext(v);	// may throw an IllegalArgumentException
    // unlink the node from the list 
    w.setPrev(u);
    u.setNext(w);
    v.setPrev(null);
    v.setNext(null);
    size--;
  }
  
  //metodo para inserir no inicio, usando head
  public void insereInicio(DNode v){
	  v.setNext(head);
	  head = v;
	  
	  //imprime a lista provisoriamente
	  System.out.print("[");
	  while(head.getNext() != null){
		  System.out.print(head.getElement()+ ", ");
		  head = head.getNext();
	  }
	  System.out.print("]");
	  head = v;
  }
  
  
  /** Returns whether a given node has a previous node */
  public boolean hasPrev(DNode v) { return v != header; }
  /** Returns whether a given node has a next node */
  public boolean hasNext(DNode v) { return v != trailer; }
  /** Returns a string representation of the list */
  public String toString() {
    String s = "[";
    DNode v = header.getNext();
    while (v != trailer) {
      s += v.getElement();
      v = v.getNext();
      if (v != trailer)
	s += ",";
    }
    s += "]";
    return s;
  }
  
  public static void main(String[] args) {
	  DList lista = new DList();
	  lista.addFirst(new DNode("Ganço", null, null));
	  lista.addFirst(new DNode("Pato", null, null));
	  lista.addFirst(new DNode("Pato", null, null));
	  lista.insereInicio(new DNode("Cavalo", null, null));
	  System.out.println(lista.toString());
	  System.out.println(lista.head.getElement());
}
  
}



  
  
  