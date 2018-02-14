
public class ArrayQueue<E> implements Queue<E> {
	
	//Variavel de instancia
	protected int capacity; //capacidade real do arranjo
	public static final int CAPACITY = 1000; //capacidade default
	private E Q[]; //arranjo genérico usado para implementar a fila
	private int f; //guarda a um indice de Q o primeiro elemento da lista.
	private int r; //Um indice para proxima posição livre de Q
	
	public ArrayQueue(){
		this(CAPACITY);
	}
	
	public ArrayQueue(int cap){
		capacity = cap;
		Q = (E[]) new Object[capacity]; //deve gerar um aviso, mas ta ok.
		f = r = 0;
	}
	
	@Override
	public int size() {
		return (capacity -f + r) % capacity;
	}

	@Override
	public boolean isEmpty() {
		return (f == r);
	}

	@Override
	public E front() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException("Fila esta vazia Marleandro!");
		return Q[f];
	}

	@Override
	public void enqueue(E element) {
		if(size() == capacity - 1) //acho que aqui não deveria ter esse -1, só se deixar um em branco entre f e r
			throw new FullQueueException("A fila está cheia Maaaleandro!");
		Q[r] = element;
		r = (r+1) % capacity;
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException("Fila vazia Maaarr!");
		E temp = Q[f];
		Q[f] = null;
		f = (f+1) % capacity;
		return temp;
	}
	
	public String toString(){
		String s;
		s = " [";
		if(size() > 0) s+= Q[0];
		if(size() > 1)
			for(int i=1; i <= size() -1; i++){
				s += ", " + Q[i];
			}
		return s + "]";
	}

	public static void main(String[] args) {
		ArrayQueue<String> fila = new ArrayQueue<String>(6);
		System.out.println(fila.toString());
		fila.enqueue("Marleandro");
		System.out.println(fila.toString());
		fila.enqueue("Joselino");
		System.out.println(fila.toString());
		fila.enqueue("Joleia");
		System.out.println(fila.toString());
		fila.dequeue();
		System.out.println(fila.toString());
		fila.dequeue();
		System.out.println(fila.toString());
		fila.dequeue();
		System.out.println(fila.toString());
		fila.dequeue();
		
	}
}







