/** Singly linked list .*/
public class SLinkedList {
	
	
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
	
	//método para encontrar o penultimo elemento.
	public String econtraPenultimo(){
		try{
			if(head == null)
				throw new Exception("Lista vazia!");
			if(size == 1)
				throw new Exception("Lista com apenas um lemento, não tem penultimo!");
			//esta linha vai continuar executando se lançar a excessão acima? Não execulta!
			System.out.println("executou aqui");
			Node cur = head;
			Node temp = null;
			while(cur.getNext() != null){
				temp = cur;
				cur = cur.getNext();
			}
			return temp.getElement();
		} catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public static void main (String[] args){
		SLinkedList lista = new SLinkedList();
		SLinkedList listaVazia = new SLinkedList();
		//lista.addFist(new Node("A", null));
		//lista.addFist(new Node("B", null));
		//lista.addFist(new Node("C", null));
		
		System.out.println(lista.toString());
		System.out.println(lista.econtraPenultimo());
		
	}
	
}