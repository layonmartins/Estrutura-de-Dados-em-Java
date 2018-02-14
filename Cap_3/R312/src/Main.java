
public class Main {
	static int x = 1 / 2;
	
	public static void main(String[] args) {
		DList lista = new DList();
				
		//add elementos
		lista.addLast(new DNode("Dipsin", null, null));
		lista.addLast(new DNode("Tinquewind", null, null));
		lista.addLast(new DNode("Lala", null, null));
		//lista.addLast(new DNode("Po", null, null));
		System.out.println(lista.toString());
		System.out.println("Nó do meio -> " + lista.nodoMeio());
	}
}
