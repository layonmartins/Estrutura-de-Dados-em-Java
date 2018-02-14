
public class NodeDeque<E> implements Deque<E> {
	
	/** Node of a doubly linked list of strings */
	public class DLNode<E> {
	  protected E element;	// String element stored by a node
	  protected DLNode next, prev;	// Pointers to next and previous nodes
	  /** Constructor that creates a node with given fields */
	  public DLNode(){ this(null, null, null); }
	  public DLNode(E e, DLNode p, DLNode n) {
	    element = e;
	    prev = p;
	    next = n;
	  }
	  /** Returns the element of this node */
	  public E getElement() { return element; }
	  /** Returns the previous node of this node */
	  public DLNode getPrev() { return prev; }
	  /** Returns the next node of this node */
	  public DLNode getNext() { return next; }
	  /** Sets the element of this node */
	  public void setElement(E e) { element = e; }
	  /** Sets the previous node of this node */
	  public void setPrev(DLNode newPrev) { prev = newPrev; }
	  /** Sets the next node of this node */
	  public void setNext(DLNode newNext) { next = newNext; }
	}
	
	protected DLNode<E> header, trailer; //sentinelas
	protected int size; //número de elementos
	public NodeDeque(){ //
		header = new DLNode<E>();
		trailer = new DLNode<E>();
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		if(size == 0) return true;
		return false;
	}
	@Override
	public E getFirst() throws EmptyDequeException {
		if(isEmpty()) throw new EmptyDequeException("O deque está vazio!");
		return (E) header.getNext().getElement();
	}
	
	@Override
	public E getLast() throws EmptyDequeException {
		if(isEmpty()) throw new EmptyDequeException("O deque está vazio!");
		return (E) trailer.getPrev().getElement();
	}
	
	@Override
	public void addFirst(E element) {
		DLNode<E> second = header.getNext();
		DLNode<E> first = new DLNode<E>(element, header, second);
		second.setPrev(first);
		header.setNext(first);
		size++;		
	}
	@Override
	public void addLast(E element) {
		DLNode<E> penultimo = trailer.getPrev();
		DLNode<E> last = new DLNode<E>(element, penultimo, trailer);
		penultimo.setNext(last);
		trailer.setPrev(last);
		size++;		
	}
	@Override
	public E removeFirst() throws EmptyDequeException {
		if(isEmpty()) throw new EmptyDequeException("O deque está vazio!");
		DLNode<E> first = header.getNext();
		E element = first.getElement();
		DLNode<E> secondtofirst = first.getNext();
		header.setNext(secondtofirst);
		secondtofirst.setPrev(header);
		size--;
		return element;
	}
	@Override
	public E removeLast() throws EmptyDequeException {
		if(isEmpty()) throw new EmptyDequeException("O deque está vazio!");
		DLNode<E> last = trailer.getPrev();
		E element = last.getElement();
		DLNode<E> secondtolast = last.getPrev();
		trailer.setPrev(secondtolast);
		secondtolast.setNext(trailer);
		size--;
		return element;
	}
	
	public String toString(){
		String s = "[";
		if(size > 0) s += header.getNext().getElement();
		if(size > 1){
			DLNode<E> temp = header.getNext().getNext();
			while(temp != trailer){
				s += ", " + temp.getElement();
				temp = temp.getNext();
			}	
		}
		return s +  "]";
	}
	
	public void print(){
		System.out.println(toString());
	}
	
	public static void main(String[] args){
	/*	NodeDeque<String> deque = new NodeDeque<String>();
		deque.print();
		deque.addFirst("Leandro");
		deque.print();
		deque.addFirst("Mar");
		deque.print();
		deque.addLast("Amigo");
		deque.print();
		deque.addLast("Da Maia");
		deque.print();
		deque.removeFirst();
		deque.print();
		deque.removeLast();
		deque.print();
		deque.removeFirst();
		deque.print();
		deque.removeLast();
		deque.print();*/
		
		NodeDeque<String> deque = new NodeDeque<String>();
		deque.print();
		deque.addFirst("Leandro");
		deque.print();
		deque.addFirst("Mar");
		deque.print();
		deque.addLast("Amigo");
		deque.print();
		deque.addLast("Da Maia");
		deque.print();
		deque.addLast(deque.removeFirst());
		deque.print();
	}
	
}










