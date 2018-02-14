package MoverParaFrente;

import Node.NodePositionList;
import Node.Position;
import Node.PositionList;

public class FavoriteList<E> {
	
	protected PositionList<Entry<E>> fList; //Lista de entradas
	
	//construtor
	public FavoriteList() { fList = new NodePositionList<Entry<E>>(); }
	
	//retorna a quantidade de elementos na lista
	public int size() {return fList.size();}
	
	//indica quando a lista está vazia
	public boolean isEmpty() {return fList.isEmpty(); }
	
	//remove o elemento indicado desde que ele esteja na lista
	public void remove(E obj){
		Position<Entry<E>> p = find(obj); //procura por obj
		if(p != null)
			fList.remove(p);
	}
	
	//incrementa o contador
	public void access(E obj){
		Position<Entry<E>> p = find(obj); //encontra a posição de obj
		if(p != null)
			p.element().incrementCount();
		else{
			fList.addLast(new Entry<E>(obj));
			p = fList.last();
		}
		moveUp(p); //move a entrada para sua posição final
	}
	
	//Encontra a posição de um dado elemento
	protected Position<Entry<E>> find(E obj) {
		for(Position<Entry<E>> p: fList.positions())
			if(value(p).equals(obj))
				return p; //encontrado na posição p
		return null; //não encontrado
	}
	
	//Move a entrada para cima para sua posição correta na lista
	protected void moveUp(Position<Entry<E>> cur) {
		Entry<E> e = cur.element();
		int c = count(cur);
		while(cur != fList.first()) {
			Position<Entry<E>> prev = fList.prev(cur); //positção anterior
			if(c <= count(prev)) break;
			fList.set(cur,  prev.element());
			cur = prev;
		}
		fList.set(cur,  e);
	}
	
	//retorna os k elementos mais acessados.
	public Iterable<E> top(int k){
		if(k < 0 || k > size())
			throw new IllegalArgumentException("Invalid argument");
		PositionList<E> T = new NodePositionList<E>(); //lista dos top-k
		int i = 0; //contador de entradas inseridas na lista
		for(Entry<E> e:fList){
			if(i++ >= k)
				break; //todas as K entradas foram inseridas
			T.addLast(e.value()); //acrescenta uma entrada na lista 
		}
		return T;
	}
	
	//representação string da lista de favoridos
	public String toString() { return fList.toString(); }
	
	//método auxiliar que obtém o valor de uma entrada em uma dada posição
	protected E value(Position<Entry<E>> p) {return (p.element()).value(); }
	
	//método auxiliar que obtém o contador de uma entrada em uma dada posição
	protected int count(Position<Entry<E>> p) { return (p.element().count());}
	
	//class aninhada que armazena os elementos e seus contadores de acesso
	protected static class Entry<E> {
		private E value; //elemento
		private int count; //contador de acessos
		//construtor
		Entry(E v){count = 1; value = v;}
		//retorna o elemento
		public E value(){return value;}
		//retorna o contador de acessos
		public int count() { return count; }
		//incrementa o ocntador de acessos
		public int incrementCount() { return ++count;}
		//representação da String em [contador, valor]
		public String toString() { return "[" + count + ", " + value + "]"; }
	}
}
