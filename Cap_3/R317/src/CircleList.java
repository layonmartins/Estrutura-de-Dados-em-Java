

/** Circulary linked list with nodes of type Node storing strings. */
public class CircleList {
	

		/** Node of a singly linked list of strings. */
		public static class Node {
			  private String element;	// we assume elements are character strings
			  private Node next;
			  /** Creates a node with the given element and next node. */
			  public Node(String s, Node n) {
			    element = s;
			    next = n;
			  }
			  /** Returns the element of this node. */
			  public String getElement() { return element; }
			  /** Returns the next node of this node. */
			  public Node getNext() { return next; }
			  // Modifier methods:
			  /** Sets the element of this node. */
			  public void setElement(String newElem) { element = newElem; }
			  /** Sets the next node of this node. */
			  public void setNext(Node newNext) { next = newNext; }
		}
	
  protected Node cursor;	// the current cursor 
  protected int size;	        // the number of nodes in the list
  /** Constructor that creates and empty list */
  public CircleList() { cursor = null; size = 0; }
  /** Returns the current size */
  public int size() { return size; }
  /** Returns the cursor */
  public Node getCursor() { return cursor; }
  /** Moves the cursor forward */
  public void advance() { cursor = cursor.getNext(); }
  /** Adds a node after the cursor  */
  public void add(Node newNode) {
    if (cursor == null) {    // list is empty
      newNode.setNext(newNode);
      cursor = newNode;
    }
    else {
      newNode.setNext(cursor.getNext());
      cursor.setNext(newNode);
    }
    size++;
  }
  /** Removes the node after the cursor */
  public Node remove() {
    Node oldNode = cursor.getNext();	// the node being removed
    if (oldNode == cursor) 
      cursor = null; // list is becoming empty
    else {
      cursor.setNext(oldNode.getNext());	// link out the old node 
      oldNode.setNext(null); 
    }
    size--;
    return oldNode;
  }
  /** Returns a string representation of the list, starting from the cursor */
  public String toString() {
    if (cursor == null) return "[]";
    String s = "[..." + cursor.getElement();
    Node oldCursor = cursor;
    for (advance(); oldCursor != cursor; advance()) 
      s += ", " + cursor.getElement();
    return s + "...]";
  }
  
  //contar nós
  public int quantosNos(){
	  if (cursor == null) return 0;
	  int cont = 0;
	  Node temp = cursor;
	  do{
		  cursor = cursor.getNext();
		  cont++;
	  }while( cursor != temp);
	  return cont;	  
  }
  
  public static void main(String[] args) {
	  CircleList lista = new CircleList();
	  System.out.println(lista.toString());
	  lista.add(new Node("Pato", null));
	  lista.add(new Node("Pato", null));
	  lista.add(new Node("Ganço", null));
	  
	  System.out.println(lista.toString());
	  System.out.println("Quantos nós? - " + lista.quantosNos());
}
}