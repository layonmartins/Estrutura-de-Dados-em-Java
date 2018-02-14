
public class NodeQueue<E> implements Queue<E> {
	//variaveis de instancia
	private int size;
	Node<E> head;
	Node<E> tail;
	
	//classe do nó
	public class Node<E> {
		//Variáveis de instância
		private E element;
		private Node<E> next;
		public Node(){
			this(null,null);
		}
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		public E getElement(){
			return element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setElement(E newElem){
			element = newElem;
		}
		public void setNext(Node<E> newNext){
			next = newNext;
		}

	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size < 1);
	}

	@Override
	public E front() throws EmptyQueueException {
		if(size == 0)
			throw new EmptyQueueException("A fila está vazia!");
		return head.getElement();
	}

	@Override
	public void enqueue(E element) {
		Node<E> node = new Node<E>();
		node.setElement(element);
		node.setNext(null);
		if(size == 0) head = node;
		else
			tail.setNext(node);
		tail = node;
		size++;
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(size == 0)
			throw new EmptyQueueException("A fila está vazia!");
		E temp = head.getElement();
		head = head.getNext();
		size--;
		if(size == 0)
			tail = null;
		return temp;
	}

	public String toString(){
		Node<E> temp = head;
		String s = "[";
		if(size > 0)
			s += temp.getElement();
		if(size > 1){
			temp = temp.getNext();
			while(temp != null){
				s += ", " + temp.getElement();
				temp = temp.getNext();
			}
		}
		return s += "]";
	}
	
	public static void main(String[] args) {
		
		NodeQueue<String> fila = new NodeQueue<String>();
		
		System.out.println(fila.toString());
		fila.enqueue("layon");
		System.out.println(fila.toString());
		fila.enqueue("giselle");
		System.out.println(fila.toString());
		fila.enqueue("maria");
		System.out.println(fila.toString());
		fila.enqueue("joão");
		System.out.println(fila.toString());
		
		fila.dequeue();
		System.out.println(fila.toString());
		fila.dequeue();
		System.out.println(fila.toString());
		fila.dequeue();
		System.out.println(fila.toString());
		fila.dequeue();
		System.out.println(fila.toString());
		
	}
	
}

















