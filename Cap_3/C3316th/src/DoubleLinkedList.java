import java.util.ArrayList;
import java.util.Iterator;

public class DoubleLinkedList<E> {
	
	private int size;
	//Este nó substitui os nós header e trailer. O sentinel.prev aponta para o 1° nó da lista e .next o ultimo.
	private DNode sentinel;
	
	//construtor vazio
	public DoubleLinkedList(){
		//size = 0; //acho que não precisa desse correto?
		sentinel = new DNode(null, null, null);
	}
	
	//Returns the number of elements in the list.
	public int getSize(){ return size; }
	
	//Returns true if the list is empty, and false otherwise.
	public boolean isEmpty(){
		if(size == 0) return true;
		else return false;
	}
	
	//Returns (but does not remove) the first element in the list
	public DNode first(){
		try{
			if(isEmpty()) throw new Exception("A lista está vazia!");
			else{
				return sentinel.getPrev();
			}
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	//Returns (but does not remove) the last element in the list.
	public DNode last(){
		try{
			if(isEmpty()) throw new Exception("A lista está vazia!");
			else
				return sentinel.getPrev();
		} catch (Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	//Adds a new element to the front of the list.
	public void addFirst(E e){
		DNode newNo = new DNode(e, null, null);
		if(isEmpty()){
			sentinel.setPrev(newNo);
			sentinel.setNext(newNo);
		} else{
			DNode temp = sentinel.getPrev();
			sentinel.setPrev(newNo);
			temp.setPrev(newNo);
			newNo.setNext(temp);
		}
		size++;
	}
	
	//Adds a new element to the end of the list.
	public void addLast(E e){
		DNode newNo = new DNode(e, null, null);
		if(isEmpty()){
			sentinel.setPrev(newNo);
			sentinel.setNext(newNo);
		} else{
			DNode temp = sentinel.getNext();
			sentinel.setNext(newNo);
			temp.setNext(newNo);
			newNo.setPrev(temp);
		}
		size++;
	}
	
	//add elementos no meio de uma lista
	public void addBetween(E e, DNode<E> p, DNode<E> n){
		DNode<E> newNo = new DNode<>(e, p, n);
		p.setNext(newNo);
		n.setPrev(newNo);
	}
	
	//Removes and returns the first element of the list
	public E removeFirst(){
		if(isEmpty()) return null;
		sentinel.setPrev(sentinel.getPrev().getNext());
		sentinel.getPrev().setPrev(sentinel);
		size--;
		return (E) sentinel.getPrev().getElement();
	}
	
	//Removes and returns the last element of the list.
	public E removeLast(){
		if(isEmpty()) return null;
		sentinel.setNext(sentinel.getNext().getPrev());
		sentinel.getNext().setNext(sentinel);
		size--;
		return (E) sentinel.getNext().getElement();
	}
	
	public E remove(DNode<E> no){
		DNode prev = no.getPrev();
		DNode next = no.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		return no.getElement();
	}
	
	//Imprime a lista
	public String toString(){
		String lista = "[";
		DNode pivo = sentinel.getPrev();
		while(pivo != null){
			lista += pivo.getElement();
			if(pivo.getNext() != null) lista += ",";
			pivo = pivo.getNext();
		}
		lista += "]";
		return lista;
	}
	
	public DoubleLinkedList<E> Clone(){
		DoubleLinkedList<E> clone = new DoubleLinkedList<>();
		DNode pivo = this.first();
		while(pivo != null){
			clone.addLast((E) pivo.getElement());
			pivo = pivo.getNext();
		}
		return clone;
	}
	
	public Iterator getIterator(){
		ArrayList<E> lis = new ArrayList<>();
		DNode pivo = this.first();
		while(pivo != null){
			lis.add((E) pivo.getElement());
			pivo = pivo.getNext();
		}
		Iterator<E> copia = lis.iterator();
		return copia;
	}
}














