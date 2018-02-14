package testeInterface;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		Documento c = new Documento();
		foto f = new foto();
		
				
		ArrayList<Imprimivel> imprimes = new ArrayList();
		
		imprimes.add(c);
		imprimes.add(f);
		
		for(Imprimivel i: imprimes)
			i.imprime();
		

	}

}
