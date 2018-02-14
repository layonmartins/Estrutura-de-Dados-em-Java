package Node;

import java.util.Iterator;

//esta é a interface da Lista com posição baseada em lista encadeada (dupla e simples)
public interface PositionList<E> extends Iterable<E>{
	
	public int size();
	public boolean isEmpty();
	public Position<E> first(); //retorna o 1° elemento
	public Position<E> last(); //retorna o ultimo elemento
	//retorna o nodo que segue um dado nodo da lista.
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	//retorna o nodo que antecede um dado nodo da lista
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;;
	public void addFirst(E e);
	public void addLast(E e);
	//insere um elemento após um dado elemento da lista.
	public void addAfter(Position<E> p, E e) throws InvalidPositionException;
	//insere um elemento antes de um dado elemento da lista.
	public void addBefore(Position<E> p, E e) throws InvalidPositionException;
	//remove um nodo da lista, retornando o elemento lá armazenado.
	public E remove(Position<E> p) throws InvalidPositionException;
	//substitui o elemento armazenado em um determinado nodo, retornando o elemento que estava lá armazenado.
	public E set(Position<E> p, E e) throws InvalidPositionException;
	//retorna um iterador sobre todos os elementos da lista
	public Iterator<E> iterador();
	//retorna uma coleção iterável de todos os nodos da lista
	public Iterable<Position<E>> positions();
}