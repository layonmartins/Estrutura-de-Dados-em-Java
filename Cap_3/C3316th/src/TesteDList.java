import java.util.ArrayList;
import java.util.Iterator;

public class TesteDList {
	
	public static void main(String[] args) {
		
		DoubleLinkedList lista = new DoubleLinkedList();
		
		//System.out.println(lista.first());
		//System.out.println(lista.last());
		lista.addFirst("A");
		lista.addLast("B");
		lista.addLast("C");
		//lista.removeFirst();
		//System.out.println(lista.first().getElement());
		
		System.out.println(lista.toString());
		
		//Nova lista
		DoubleLinkedList novaLista = lista.Clone();
		System.out.println(novaLista.toString());
		
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("asf");
		nomes.add("asdfasdf");
		
		Iterator<String> lis = nomes.iterator();
	}
}
