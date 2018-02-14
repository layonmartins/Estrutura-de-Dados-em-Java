package Arranjo;


public class ListaArranjoExtensivel<E> implements IndexList<E> {

	private int size = 0;
	private int capacity; // por padrão tem tamanho 10
	private E[] A;
	private E[] B; //este é usado para extender A
	
	//construtor padrao
	public ListaArranjoExtensivel(){
		this(4);
	}
	//construtor parametrizado
	public ListaArranjoExtensivel(int c){
		capacity = c;
		A = (E[]) new Object[capacity];
	}
	
	//verifica se um índice está fora do array
	private void ItsOut(int i){
		if(i < 0 || i >= capacity)
			throw new IndexOutOfBoundsException("O índice está fora");
	}
	
	//imprime o array para teste
	public void print(){
		if(isEmpty()) System.out.println("[vazio]");
		else{
			System.out.print("A = [" + A[0]);
			for(int i=1; i<size; i++)
				System.out.print(", "+ A[i]);
			System.out.println("]");
		}
	}
	
	public void extender(){
		//cria um novo array com drobro de tamanho
		capacity *= 2;
		B = (E[]) new Object[capacity];
		for(int i=0; i<size; i++)
			B[i] = A[i];
		A = B;
		System.out.println("Capacidade alterada para = " + capacity);
	}
	
	public void deextender(){
		capacity /= 2;
		B = (E[]) new Object[capacity];
		for(int i=0; i<size; i++)
			B[i] = A[i];
		A = B;
		System.out.println("Capacidade alterada para = " + capacity);
	}
	
	//metodos da Interface
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		ItsOut(i);
		if(size+1 == capacity) //se o array chegar no limite dobrar
			extender();
		//supondo que o A não esta cheio, j começa em size, ou seja, depois do ultimo elemento.
		for(int j=size; j > i; j--)
			A[j] = A[j-1];
		A[i] = e;
		size++;
		this.print();
	}

	public E get(int i) throws IndexOutOfBoundsException {
		
		return A[i];
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		E temp = A[i];
		for(int j = i; j < size; j++)
			A[j] = A[j+1];
		A[size] = null;
		size--;
		this.print();
		if(size < capacity/2) //ou size+1?
		deextender();
		return temp;
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		E temp = A[i];
		A[i] = e;
		return temp;
	}
	
	public static void main(String[] args) {
		//teste da lista
		ListaArranjoExtensivel<Integer> lista = new ListaArranjoExtensivel<Integer>();
		
		lista.add(0, 5);
		lista.add(0, 4);
		lista.add(0, 3);
		lista.add(0, 2);
		lista.add(0, 1);
		lista.remove(0);
		lista.remove(0);
		lista.add(0, 2);
	
		System.out.println(lista.size());
		
		
	}

}