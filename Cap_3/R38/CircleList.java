

/** Circulary linked list with nodes of type Node storing strings. */
public class CircleList {

	//add classe Node
	public static class Node{
		private String element;
		private Node next;

		public Node(String s, Node n){
			element = s;
			next = n;
		}

		public String getElement() {return element;}
		public Node getNext() {return next;}
		public void setElement(String newElem) {element = newElem;}
		public void setNext(Node newNext) {next = newNext;}
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
  public void advance() { 
	  try{
		  cursor = cursor.getNext();
	  } catch (Exception e) {
		  System.out.println("Não é possivel avançar uma lista vazia.");
	  }
  }
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
  public Node remove(){
	try {
			if(cursor == null)
				throw new Exception("Não é possivel remover elemente de uma lista vazia");
    		Node oldNode = cursor.getNext();	// the node being removed
		    if (oldNode == cursor) 
		      cursor = null; // list is becoming empty
		    else {
		      cursor.setNext(oldNode.getNext());	// link out the old node 
		      oldNode.setNext(null); 
		    }
		    size--;
		    return oldNode;
	} catch(Exception e) {
		System.out.println("erro: " + e);
		return null;
	}
		
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

	//teste classe
	public static void main(String[] args){
		CircleList lista = new CircleList();
		System.out.println(lista.toString());
		lista.advance();
		lista.remove();
		//lista.add(new Node("layon",null));
		System.out.println(lista.toString());
	}

}
