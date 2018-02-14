
public interface Stack<E> {
	public int size(); //retorna o tamanho da pilha
	public boolean isEmpty(); //retorna true se estiver vazia ou false se não
	public E top() throws EmptyStackException; //retorna o elemento do topo
	public void push(E element) throws FullStackException; //add elemento no topo
	public E pop() throws EmptyStackException; //retira e retorna o elemento do topo
	
}
