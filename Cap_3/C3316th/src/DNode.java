
public class DNode<E> {
	
	private E element;
	private DNode prev;
	private DNode next;
	
	public DNode(E e, DNode<E> p, DNode<E> n){
		element = e;
		prev = p;
		next = n;
	}
	
	public E getElement(){
		return element;
	}
	public DNode<E> getPrev(){
		return prev;
	}
	public DNode<E> getNext(){
		return next;
	}
	public void setElement(E e){
		element = e;
	}
	public void setPrev(DNode<E> p){
		prev = p;
	}
	public void setNext(DNode<E> n){
		next = n;
	}
	
}
