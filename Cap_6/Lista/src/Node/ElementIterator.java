package Node;

import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> list; //lista subjacente
	protected Position<E> cursor; //a próxima posição
	//cria o elmento iterador sobre a lista fornecida.
	public ElementIterator(PositionList<E> L){
		list = L;
		cursor = (list.isEmpty())? null : list.first();
	}
	
	@Override
	public boolean hasNext() {
		return (cursor != null);
	}
	
	@Override
	public E next() throws NoSuchElementException{
		if(cursor == null)
			throw new NoSuchElementException("No next element");
		E toReturn = cursor.element();
		cursor = (cursor == list.last())? null : list.next(cursor);
		return toReturn;
	}
	
}
