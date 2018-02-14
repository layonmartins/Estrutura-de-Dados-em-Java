
/** Singly linked list .*/
public class SLinkedList {
	
	//add classe Node
		public static class Node{
			private String element;
			private Node next;

			public Node(String s, Node n){
				element = s;
				next = n;
			}

			public String getElement() {return element;}
			public Node getNext() {return next;}
			public void setElement(String newElem) {element = newElem;}
			public void setNext(Node newNext) {next = newNext;}
		}
	
	protected Node head;		// head node of the list
	protected Node tail;		// tail node of the list
	protected long size;		// number of nodes in the list
  /** Default constructor that creates an empty list */
	public SLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
  // ... update and search methods would go here ...
	
	public void addFist(Node v){
		v.setNext(head);
		head = v;
		size++;
	}
	
	public String toString(){
		Node no = head;
		String lista = "[";
		while(no != null){
			lista += no.getElement();
			if(no.getNext() != null) lista += ", ";
			no = no.getNext();
		}
		lista += "]";
		return lista;
	}
	
	//metodo recursivo para remoção no final
	public String removeLast(Node no, Node ante){
		try{
			if(no == null)
				throw new Exception("lista está vazia!");
			else if (size == 1){
					String temp = no.getElement();
					head = null;
					size--;
					return temp;
			} else { //aqui quer dizer que não esta vazia e que no mínimo 2 elementos. 
				if(no.getNext() == null){ //é o ultimo elemento
					String temp = no.getElement();
					ante.setNext(null);
					size--;
					return temp;
				} else return removeLast(no.getNext(), no);
			}	
		} catch (Exception e){
			return e.getMessage();
		}
	}
	
	public static void main (String[] args){
		SLinkedList lista = new SLinkedList();
		SLinkedList listaVazia = new SLinkedList();
		lista.addFist(new Node("Emprego", null));
		lista.addFist(new Node("Mestrado", null));
		lista.addFist(new Node("Graduacao", null));
		
		System.out.println(lista.toString());
		System.out.println("Revomendo -> " + lista.removeLast(lista.head, null));
		System.out.println(lista.toString());
		System.out.println("Revomendo -> " + lista.removeLast(lista.head, null));
		System.out.println(lista.toString());
		System.out.println("Revomendo -> " + lista.removeLast(lista.head, null));
		System.out.println(lista.toString());
		
		System.out.println("\nLista 2 vazia: ");
		System.out.println("Revomendo -> " + listaVazia.removeLast(listaVazia.head, null));
		System.out.println(listaVazia.toString());
		
	}
	
}