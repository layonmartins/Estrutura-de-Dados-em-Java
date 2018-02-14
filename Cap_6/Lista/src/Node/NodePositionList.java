package Node;
import java.util.Random;
import Arranjo.IteratorException;
import java.util.Arrays;
import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E>, Iterable<E>{

	
	
	protected int numElts; //número de elementos na lista
	protected DNode<E> header, trailer; //sentinelas
	//construtor O(1)
	public NodePositionList(){
		numElts = 0;
		header = new DNode<E>(null, null, null);
		trailer = new DNode<E>(header, null, null);
		header.setNext(trailer); //faz a cabeça é a calda apontarem uma para a outra.
	}
	
	//verifica se a posição é válida para esta lista e a converta para DNode.
	protected DNode<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if(p == null)
			throw new InvalidPositionException("Referência null passada para NodeList");
		if(p == header)
			throw new InvalidPositionException("O nó header não é uma posição válida");
		if(p == trailer)
			throw new InvalidPositionException("O nó trailer não é uma posição válida");
		try{
			DNode<E> temp = (DNode<E>) p;
			if((temp.getPrev() == null) || (temp.getNext() == null))
				throw new InvalidPositionException("Position does not belong to a valid NodeList");
			return temp;
		} catch (ClassCastException e){
			throw new InvalidPositionException("Position is of wrong type for this list");
		}
	}
	
	//Exercicio C-6.7
	//verifica se a posição é válida para esta lista e a converta para DNode.
	protected DNode<E> checkPosition2(Position<E> p, DNode<E> cabeca) throws InvalidPositionException {
		if(p == null)
			throw new InvalidPositionException("Referência null passada para NodeList");
		if(p == header)
			throw new InvalidPositionException("O nó header não é uma posição válida");
		if(p == trailer)
			throw new InvalidPositionException("O nó trailer não é uma posição válida");
		if(cabeca != header)
			throw new InvalidPositionException("Está posição não corresponde a esta lista");
		try{
			DNode<E> temp = (DNode<E>) p;
			if((temp.getPrev() == null) || (temp.getNext() == null))
				throw new InvalidPositionException("Position does not belong to a valid NodeList");
			return temp;
		} catch (ClassCastException e){
			throw new InvalidPositionException("Position is of wrong type for this list");
		}
	}
	
	//metodo para testar a lista
	public void print(){
		if(isEmpty()) System.out.println("lista está vazia");
		else{
			System.out.print("[");
		DNode<E> temp =  header.getNext();
		while(temp != trailer){
			if(temp != header.getNext())
				System.out.print(", ");
			System.out.print(temp.element());
			temp = temp.getNext();
		}
		System.out.println("] size= " + size());
		}
	}
	
	
	@Override
	public int size() {
		return numElts;
	}

	@Override
	public boolean isEmpty() {
		return (numElts == 0);
	}
	
	//retorna a 1° posição da lista
	@Override
	public Position<E> first() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException("Lista está vazia");
		return header.getNext();
	}

	@Override
	public Position<E> last() {
		if(isEmpty())
			throw new EmptyListException("Lista está vazia");
		return trailer.getPrev();
	}

	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> v = checkPosition(p);
		DNode<E> next = v.getNext();
		if(next == trailer)
			throw new BoundaryViolationException("Cannot advance past the end of the list");
		return next;
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> v = checkPosition(p);
		DNode<E> prev = v.getPrev();
		if(prev == header)
			throw new BoundaryViolationException("Cannot advance past the beginning of the list");
		return prev;
	}

	@Override
	public void addFirst(E e) {
		numElts++;
		DNode<E> newNode = new DNode<E>(header, header.getNext(), e);
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		//addBefore((Position<E>)header.getNext(), e); //não funciona para lista vazia.
	}

	@Override
	public void addLast(E e) {
		//addAfter((Position<E>)trailer.getPrev(), e); //não funciona para lista vazia.
		numElts++;
		DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, e);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}

	@Override
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElts++;
		DNode<E> newNode = new DNode<E>(v.getPrev(), v, e);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
	}
	
	//Exercicio C-6.7
	public void addBefore(Position<E> p, E e, DNode<E> cabeca) throws InvalidPositionException {
		DNode<E> v = checkPosition2(p, cabeca);
		numElts++;
		DNode<E> newNode = new DNode<E>(v.getPrev(), v, e);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
	}

	@Override
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElts++;
		DNode<E> newNode = new DNode<E>(v, v.getNext(), e);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
	}

	//remove da lista a posição fornecida; tempo O(1).
	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElts--;
		DNode<E> vPrev = v.getPrev();
		DNode<E> vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		E vElem = v.element();
		//Desconecta a posição da lista e marca-a como inválida
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}

	//Substitui o elemento da posição fornecida por um novo e retorna o elemento velho, O(1).
	@Override
	public E set(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		E oldElt = v.element();
		v.setElement(e);
		return oldElt;
	}
	
	
	
	public static void main(String[] args) {
		NodePositionList<Integer> lista = new NodePositionList<Integer>();
//		lista.print();
//		
//		lista.addFirst(1); lista.print();
//		lista.addFirst(2); lista.print();
//		lista.addFirst(3); lista.print();
//		lista.addLast(4); lista.print();
//		lista.addLast(5); lista.print();
		
		
		//Arranjo para fazer os exercicios
		Integer[] A = {1,2,3,4,5};
		
		//exercicios R-6.2
		//lista.embaralha(A);
		//lista.print();
		
		//exercicio R-6.3
		//lista.rotacionar(A, 2);
		
		//exercicio R-6.12
//		lista.addLast(1);
//		lista.addLast(2);
//		lista.addLast(3);
//		lista.addLast(4);
//		lista.addLast(5);
//		lista.print();
//		lista.inverter();
//		lista.print();
		
		
		//Exercicio R-6.19
//		lista.addLast(1);
//		lista.addLast(2);
//		lista.addLast(3);
//		lista.print();
		//for(Integer i : lista)
		//	System.out.println(i);
			
//		for(Iterator<Integer> it = lista.iterator(); it.hasNext();){
//			System.out.println(it.next());
//		}
		
		//exercicio C-6.7
//		NodePositionList<Integer> S = new NodePositionList<Integer>();
//		NodePositionList<Integer> T = new NodePositionList<Integer>();
//		S.addLast(1);
//		S.addLast(2);
//		S.addLast(3);
//		
//		T.addLast(4);
//		T.addLast(5);
//		T.addLast(6);
//		
//		S.print();
//		T.print();
//		
//		Position<Integer> p = S.first();
//		T.addBefore(p, 0, S.header);
//		
//		S.print();
//		T.print();
		
		
		//Exercicio C-6.18
		//Bubble Sorte para odendar
		//só funciona com inteiro
		lista.addLast(1);
		lista.addLast(4);
		lista.addLast(2);
		lista.addLast(3);
		lista.print();
		lista.ordenar();
		lista.print();
		
	}
	
	//exercicio R-6.2
	public void embaralha(E[] A){
		Random rand = new Random();
		int r = rand.nextInt(A.length);
		while(size() < A.length){
			if(A[r] != null){
				addLast(A[r]);
				A[r] = null;
			}
			r = rand.nextInt(A.length);
		}
		//add de volta em A
		for (int i = 0; i < A.length; i++) {
			A[i] = remove(first());
			System.out.print(A[i] + " ");
		}
	}
	
	//exercicio R-6.3
	public void rotacionar(E[] A, int d){
		//um arranjo novo recebe uma copia do antigo
		E[] B = (E[]) new Object[A.length];
		for (int i = 0; i < A.length; i++)
			B[(i + d) % A.length] = A[i];
		A = B;
		//testar
		for(E e : A){
			System.out.print(e + " ");
		}
	}
	
	//exercicio R-6.12
	public void inverter(){
		Position<E> aux;
		addLast(remove(first()));
		aux = last();
		while(first() != aux){
			addBefore(aux, remove(first()));
			aux = prev(aux);
		}	
	}

	//Exercicio R-6.19
	public class iteradorElemento<E> implements Iterator<E>{
		
		E[] E = (E[]) new Object[size()];
		DNode<E> d = (DNode<E>) header.getNext();
		int i = 0;
		
		public iteradorElemento(){
			for(int i = 0; i < size(); i++){
				E[i] = d.element();
				d = d.getNext();
			}
		Arrays.sort(E);
		}
		
		public boolean hasNext() {
			
			return (i < size());
		}

		public E next() {
			if(i == size()) throw new IteratorException("Não tem next");
			E temp = (E) E[i];
			i++;
			return temp;
		}
		
	}
	
	
	//Exercicio C-6.18
	//Bubble Sorte para odendar
	public void ordenar(){
		for(int i = 0; i < size(); i++){
			Position<E> cur = first();
			while(cur != last()){
				if((int)cur.element() > (int)next(cur).element()){
					DNode<E> A = (DNode<E>) cur;
					DNode<E> B = (DNode<E>) next(cur);
					
					A.setNext(B.getNext());
					B.getNext().setPrev(A);
					B.setPrev(A.getPrev());
					A.getPrev().setNext(B);
					B.setNext(A);
					A.setPrev(B);
					cur = B; //vishe, essa aqui foi osso, 
					//depois de fazer as trocas, tem que inverter tbm o cursor. cur = B
					//pois no final B sera o last(), como troquei as posicoes, B vai para...
					//o lugar do A, e o A para o de B, ou seja cur aqui passar a ser last..
					//então o comando cur = next(cur); da erro.
				}
				cur = next(cur);
			}			
		}
				
	}
	
	@Override
	public Iterator<E> iterator() {
		return new iteradorElemento();
	}

	@Override
	public Iterator<E> iterador() {
		return new ElementIterator<E>(this);
	}
	
	//retorna a representação textual de uma lista de nodos
	public static <E> String toString(PositionList<E> I){
		Iterator<E> it = I.iterador();
		String s = "[";
		while(it.hasNext()){
			s += it.next();
			if(it.hasNext())
				s += ", ";
		}
		s += "]";
		return s;
	}

	@Override
	public Iterable<Position<E>> positions() { //cria uma lista de posições
		PositionList<Position<E>> P = new NodePositionList<Position<E>>();
		if(!isEmpty()){
			Position<E> p = first();
			while(true) {
				P.addLast(p); //acrescenta a posição p como último elemento da lista P
				if(p == last())
					break;
				p = next(p);
			}
		}
		return P; //retorna P como objeto iterável
	}

}










