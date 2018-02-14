package Arranjo;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

public class AdaptStack<E> implements Stack<E>, IndexList<E> {
	private int size = 0;
	private int capacity; // por padrão tem tamanho 10
	private E[] A;
	int top;
	
	//construtor padrao
	public AdaptStack(){
		this(10);
	}
	//construtor parametrizado
	public AdaptStack(int c){
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
	
	
	//Pilhaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	
	@Override
	public E top() throws EmptyStackException {
		if(size()-1 == -1)
			throw new EmptyStackException("Pilha esta vazia");
		return get(size() - 1);
	}
	
	@Override
	public void push(E element) throws FullStackException {
		if(size() == capacity)
			throw new FullStackException("Pilha cheia");
		add(size(), element);
	}
	
	@Override
	public E pop() throws EmptyStackException {
		if(size()-1 == -1)
			throw new EmptyStackException("Pilha esta vazia");
		return remove(size() - 1);
	}
	
	
	//teeeeeesssssssttteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
	public static void main(String[] args) {
		AdaptStack<Integer> pilha = new AdaptStack<Integer>();
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		System.out.println("top = > " + pilha.top());
		pilha.push(4);
		System.out.println("pop = > " + pilha.pop());
		System.out.println("pop = > " + pilha.pop());
		System.out.println("pop = > " + pilha.pop());
		System.out.println("top = > " + pilha.top());
		System.out.println("pop = > " + pilha.pop());
	}
}
