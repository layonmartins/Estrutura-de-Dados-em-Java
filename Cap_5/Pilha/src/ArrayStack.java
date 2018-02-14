
public class ArrayStack<E> implements Stack<E> {

	protected int capacity; //capacidade real do arranjo
	public static final int CAPACITY = 1000; //capacidade default
	protected E S[]; //arranjo genérico usado para implementar a pilha
	protected int top = -1; //indice para o topo
	
	//construtor default
	public ArrayStack(){
		this(CAPACITY);
	}
	
	public ArrayStack(int cap){
		capacity = cap;
		S = (E[]) new Object[capacity]; //deve gerar um aviso, mas ta ok.
	}
	
	@Override
	public int size() {
		return (top + 1);
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public E top() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException("A pilha está vazia!");
		return S[top];
	}

	@Override
	public void push(E element) throws FullStackException {
		if(size() == capacity) throw new FullStackException("A pilha está cheia!");
		S[++top] = element;
	}

	@Override
	public E pop() throws EmptyStackException {
		E element;
		if(isEmpty()) throw new EmptyStackException("A pilha está vazia Pó!");
		element = S[top];
		S[top--] = null;
		return element;
	}
	
	public String toString(){
		String s;
		s = " [";
		if(size() > 0) s+= S[0];
		if(size() > 1)
			for(int i=1; i <= size() -1; i++){
				s += ", " + S[i];
			}
		return s + "]";
	}
	
	//imprime informação de estado sobre uma operação recente da pilha
	public void status(String op, Object element) {
		System.out.println("---> " + op);
		System.out.println(", returns " + element);
		System.out.println("result: size = " + size() + ", isEmpty = " + isEmpty());
		System.out.println(", stack: " + this);
	}
	
	//Exercicio R5.6
	public String removeAll(){
		if(isEmpty())
			return "A pilha esta vazia!";
		else{
			this.pop();
			return removeAll();
		}
	}

	//testa o programa
	public static void main(String[] args) {
		/*Object o;
		ArrayStack<Integer> A = new ArrayStack<Integer>();
		A.status("new ArrayStack<Integer> A", null);
		A.push(7);
		A.status("A.push(7)", null);
		o = A.pop();
		A.status("A.pop() ", o);
		A.push(9);
		A.status("A.push(9)", null);
		o = A.pop();
		A.status("A.pop() ", o);*/
		
		/*ArrayStack<String> B = new ArrayStack<String>();
		B.status("new ArrayStack<String> B",  null);
		B.push("Bob");
		B.status("B.push(\"Bob\")", null);
		B.push("Alice");
		B.status("B.push(\"Alice\")", null);
		o = B.pop();
		B.status("B.pop()",  o);
		B.push("Eve");
		B.status("B.push(\"Eve\")",  null);*/
		
		ArrayStack<String> C = new ArrayStack<String>();
		C.push("Batata");
		C.push("quente");
		C.push("quente");
		C.push("quente");
		C.push("quente");
		C.push("queimouu..");
		System.out.println(C.toString());
		C.removeAll();
		System.out.println(C.toString());
	}
	
}







