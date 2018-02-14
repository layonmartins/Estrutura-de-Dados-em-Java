
public class C314 {
	private static int convert(String numero, int n){
		//para entender imagine numero = "1234" e n = "1234".length() = 4
		
		if(n == 0) return 0; //caso base
		
		//String digito recebe um char de "numero" racter.toString() convert um char em String.
		String digito = Character.toString(numero.charAt(numero.length() - n));
		
		for(int i = 1; i < n; i++)
			digito += "0"; //acrescente 0 no final n-2 vezes.
		//Explicação do for:
				//Se numero for "1234" então é digito for "1" neste caso n = 4. onde (4-4 = 0) = charAt(0) = "1".
				//Ou seja 1 vai ser concatenado com "0" de 1 até 3,ou seja 3 vezes
				// digito valerá "1000"
		int valor = Integer.parseInt(digito);
		return valor + convert(numero, n-1);
		// ai vai retornar 1000 + chamada recursiva com n-1 que ira retornar 200 + proxima...
		// ou seja, 1000 + 200 + 30 + 4 = 1234;
	}
	
	public static void main(String[] args) {
		System.out.println(convert("1234", "1234".length()) + 1);
	}
}
