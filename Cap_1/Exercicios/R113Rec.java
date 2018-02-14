import java.util.*;

public class R113Rec{
	public int somaMenorParRec(int n){
		if(n == 2) return 0;
		if((n-1) % 2 == 0)
			return (n-1 + somaMenorParRec(n-1));
		else
			return somaMenorParRec(n-1); 
	}

	public static void main(String[] args){
		R113Rec teste = new R113Rec(); //criei um obj para usar o método
						//caso quiser usar direto basta
						//definir somaMenor... 'static'
		System.out.println("digite um numero -> ");
		Scanner c = new Scanner(System.in);
		int soma = teste.somaMenorParRec(c.nextInt());
		System.out.println("soma = " + soma);
	}
}
