import java.util.*;

public class C16{
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.print("######## Programa inverte linhas #########\n quantas linhas vai digitar -> ");
		int numLinhas = teclado.nextInt();
		C16 c16 = new C16();
		c16.inverte(numLinhas);
	}

	public void inverte(int numLinhas){
		String[] linha = new String[numLinhas];
		Scanner c = new Scanner(System.in);
		
		for(int i = 0; i < numLinhas; i++){
			System.out.print("\nDigite uma linha-> ");
			linha[i] = c.nextLine();
		}

		System.out.println("\nLinhas invertidas:");
		for(int j=numLinhas-1; j >= 0; j--)
			System.out.println("Linha["+ j + "] = " + linha[j]);


	}
}
