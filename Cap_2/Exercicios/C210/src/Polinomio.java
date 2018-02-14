import java.util.Scanner;

//OBS: ex. de polinômio: "2x^2 + 4x - 8"
public class Polinomio {
	
	//Esta função recebe um polinomio e imprime a sua derivada em forma de String.
	public static void DerivaPolinomio(String polinomio){
		String[] monomios = new String[polinomio.length()]; // cria um arrai com tamanho provisorio.
		char[] operadores = new char[polinomio.length()];
		String monomio = ""; //monomio individual
		int j = 0; //variavel auxilar, para salvar o indice do array dos monomios e operadores.
		//monomio[] monomios;
		for(int i=0; i<polinomio.length(); i++){
			if(polinomio.charAt(i) != ' '){ //o que separa os monomios são espaços.
				monomio += polinomio.charAt(i);
				
			}
			else{
				operadores[j] = polinomio.charAt(++i);
				i++;
				monomios[j] = monomio;
				monomio = "";
				j++;
			}
		}
		//qnd sair do for vai sobrar o ultimo monomio.
		monomios[j] = monomio;
		
		//imprimir os array para teste
		for(int i=0; i<=j; i++){
			System.out.print(derivaMonomio(monomios[i]) + " " + operadores[i] + " ");
		}
		
		
	}
	
	//Esta função recebe um monômio dos tipos "2x^2" ou "4x" ou "8"
	//e retorna a sua derivada também em String.
	public static String derivaMonomio(String monomio){
		
		//Variaveis provisorias
		String coeficiente = "";
		String literal = "";
		String expoente = "1";
		String derivado = "";
		
		for(int i=0; i<monomio.length(); i++){ //percorrer os caracteres da String "monomio".
			char c = monomio.charAt(i);
			if(Character.isDigit(c)) //Se é número
				coeficiente += monomio.charAt(i); //salva no coeficiente
			else{ //se é letra
				literal += monomio.charAt(i); //para as letras, 'literais' inclusivo o '^'
				if(monomio.charAt(i) == '^') {//se for o '^' isso quer dizer que dai pra frente é o expoente.
					expoente = monomio.substring(i+1); //pega do '^' para frente da String.
					//tenho que para o for, se não ele vai continuar a pegar os expoente como coeficiente.
					i = monomio.length(); //acho que da certo.
				}
			}
		}
		
		//imprimir monomio para testar - FUNCIONOU, ALELUIA
//		System.out.println("coeficiente: " + coeficiente);
//		System.out.println("literal: " + literal);
//		System.out.println("expoente: " + expoente);
		
		//DERIVANDOOOOOO
		
		//1° converter os tipos
		Double coef = Double.parseDouble(coeficiente);
		Double exp = Double.parseDouble(expoente);
		
		//2° deriva de verdade.
		coef *= exp; //desse o expoente
		exp--; //subtrai um no expoente.
		expoente = exp.toString();
		
		//Retorna uma String derivada.
		if(literal == "") //quer dizer que é uma constante,
			return "0"; // retorna zero
		else if(exp == 0) //se o exp for zero, qualquer número elevado a zero é 1
			expoente = ""; 
		return coef + literal + expoente;
	}
	
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		System.out.print("Digite um polinômio em notação algébrica padrão\n-> ");
		String polinomio = c.nextLine();
		
		//DerivaPolinomio("2x^2 + 4x - 8"); // teste padrão
		
		DerivaPolinomio(polinomio);
		
		//testa a derivação separada do monomio.
		//System.out.println(derivaMonomio("4x"));
	}
}
