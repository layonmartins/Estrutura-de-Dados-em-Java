package Arranjo;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

public class ListaArranjoNodes<E> implements Stack {
	private int size = 0;
	private int capacity; // por padrão tem tamanho 10
	private E[] A;
	
	//construtor padrao
	public ListaArranjoNodes(){
		this(10);
	}
	//construtor parametrizado
	public ListaArranjoNodes(int c){
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
		//ListaArranjoBasica<Integer> lista = new ListaArranjoBasica<Integer>();
		
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
		
		
		//Exercicio R-6.1
		int[] A = {1,2,3,4,5};
		int i, j = 0;
		ListaArranjoBasica<Integer> lista = new ListaArranjoBasica<Integer>();
		for(i = 0; i < A.length; i++)
			lista.add(i, A[i]);
		for(i = A.length -1 ; i >=0; i--){
			A[j] = lista.get(i);
			System.out.print(A[j++] + " ");
		}
	}
	@Override
	public Object top() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void push(Object element) throws FullStackException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}
}
