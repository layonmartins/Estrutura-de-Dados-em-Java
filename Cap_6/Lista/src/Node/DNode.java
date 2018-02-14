package Node;

public class DNode<E> implements Position<E> {

	private DNode<E> prev, next;
	private E element; //elemento armazenado nesta posição
	//construtor
	public DNode(DNode<E> newPrev, DNode<E> newNext, E elem){
		prev = newPrev;
		next = newNext;
		element = elem;
	}
	
	@Override
	public E element() throws InvalidPositionException {
		if((prev == null) && (next == null))
			throw new InvalidPositionException("Position is not in a list!");
		return element;
	}
	//métodos de acesso
	public DNode<E> getNext(){return next;}
	public DNode<E> getPrev(){return prev;}
	//métodos de atualização
	public void setNext(DNode<E> newNext) {next = newNext;}
	public void setPrev(DNode<E> newPrev) {prev = newPrev;}
	public void setElement(E newElement) {element = newElement;}
}
