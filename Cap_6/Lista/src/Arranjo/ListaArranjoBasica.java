package Arranjo;

import java.util.Iterator;

public class ListaArranjoBasica<E> implements IndexList<E>, Iterable<E>{

	private int size = 0;
	private int capacity; // por padrão tem tamanho 10
	private E[] A;
	
	
	//construtor padrao
	public ListaArranjoBasica(){
		this(10);
	}
	//construtor parametrizado
	public ListaArranjoBasica(int c){
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
	
	//metodos da Interface
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		ItsOut(i);
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
		return temp;
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		E temp = A[i];
		A[i] = e;
		return temp;
	}
	
	public static void main(String[] args) {
		//teste da lista
		ListaArranjoBasica<Integer> lista = new ListaArranjoBasica<Integer>();
		
	/*	lista.add(0, 7);
		lista.add(0, 4);
		System.out.print(lista.get(1)+"\n");
		lista.add(2, 2);
		System.out.print(lista.get(3)+"\n");
		System.out.print(lista.remove(1) + " "); lista.print();
		lista.add(1, 5);
		lista.add(1, 3);
		lista.add(4, 9);
		System.out.print(lista.get(2)+"\n");
		lista.set(3, 8); lista.print();
		System.out.println(lista.size());*/
		
		
//		//Exercicio R-6.1
//		int[] A = {1,2,3,4,5};
//		int i, j = 0;
//		ListaArranjoBasica<Integer> lista = new ListaArranjoBasica<Integer>();
//		for(i = 0; i < A.length; i++)
//			lista.add(i, A[i]);
//		for(i = A.length -1 ; i >=0; i--){
//			A[j] = lista.get(i);
//			System.out.print(A[j++] + " ");
//		}
		
		
//		//exercicio R-6.18
//		lista.add(0, 3);
//		lista.add(0, 2);
//		lista.add(0, 1);
//		for(Iterator<Integer> it = lista.iterator(); it.hasNext();){
//			System.out.println(it.next());
//		}
		
		
		//exercicio C-6.4
		int N = 5; //tamanho do array inicial
		Integer[] A = {1,2,3,4,5};
		//cria duas listas com os tamanhos exatos
		ListaArranjoBasica<Integer> L1 = new ListaArranjoBasica<Integer>(N/2);
		ListaArranjoBasica<Integer> L2; //se N for par, N / 2 é o tamanho de L2, caso não
		L2 = new ListaArranjoBasica<Integer>((N%2 == 0)? N / 2 : (N / 2) +1 ); // é (N/2)+1
		//salva 1° metade de A em L1 é 2° metade em L2
		for (int i = 0; i < N/2; i++) {
			L1.add(i, A[i]);
		}
		int j = 0;
		for (int i = N/2; i < N; i++) {
			L2.add(j++, A[i]);
		}
		
		//Embaralhar de volta em A pegando de L1
		int x = 0; int y = 0;
		for(int i = 0; i < N-1; i=i+2){
			A[i] = L1.get(x++);
			A[i+1] = L2.get(y++);
		}
				
		for(Integer i : A)
			System.out.print(i + " ");
		
	}
	
	//exercicio R-6.18
	public class iterador<E> implements Iterator<E>{
		int i = 0;
		
		@Override
		public boolean hasNext() {
			return (i < size());
		}

		@Override
		public E next() {
			if(i == size()) throw new IteratorException("Não tem next");
			E temp = (E) A[i];
			i++;
			return temp;
		}
		
	}
	
	@Override
	public Iterator<E> iterator() {
		return new iterador<E>();
	}
}




