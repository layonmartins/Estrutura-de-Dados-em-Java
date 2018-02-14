package Arranjo;

public interface IndexList<E> {
	public int size();
	public boolean isEmpty();
	//insere 'e' de maneira q ele ocupe o índice i, deslocando todos os elementos depois dele.
	public void add(int i, E e) throws IndexOutOfBoundsException;
	//retorna o elemento no índici i, sem removelo
	public E get(int i) throws IndexOutOfBoundsException;
	//remove e retorna o elemento no índice i, deslocando os elementos após este.
	public E remove(int i) throws IndexOutOfBoundsException;
	//substitui o elemento no índice i por e.
	public E set(int i, E e) throws IndexOutOfBoundsException;
	
}
