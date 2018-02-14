import java.util.Arrays;

public class NodeStack<E> implements Stack<E> {
	
	protected Node<E> top;
	protected int size;
	
	public NodeStack(){
		top = null;
		size = 0;
	}
	
	public int size() {return size;}
	
	public boolean isEmpty(){
		if(top == null) return true;
		return false;
	}
	
	public void push(E elem){
		Node<E> v = new Node<E>(elem, top);
		top = v;
		size++;
	}
	
	public E top() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException("A pilha está vazia!");
		return top.getElement();
	}
	
	public E pop() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException("A pilha está vazia!");
		E temp = top.getElement();
		top = top.getNext();
		top = top.getNext();
		size--;
		return temp;
	}
	
	public static <E> void reverse(E[] a){
		Stack<E> S = new ArrayStack<E>(a.length);
		for(int i=0; i < a.length; i++)
			S.push(a[i]);
		for(int i=0; i<a.length; i++)
			a[i] = S.pop();
	}
	
	public static void main(String[] args) {
		Integer[] a = {4,8,15,16,23,42};
		{}String[] s = {"Jack", "Kate", "Hurley", "Jin", "Boone"};
		System.out.println(" a = " + Arrays.toString(a));
		System.out.println(" s = " + Arrays.toString(s));
		System.out.println("Reversing...");
		reverse(a);
		reverse(s);
		System.out.println(" a = " + Arrays.toString(a));
		System.out.println(" s = " + Arrays.toString(s));
	}
	
}




