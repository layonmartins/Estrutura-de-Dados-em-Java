import java.util.*;;

public class R113{
	public static int somaMenor(int n){
		int soma=0;
		for(int j=n; j>0; j--)
			if(j % 2 == 0){
				soma += j;
				System.out.print(" + " + j);

			}
		return soma;
	}

	public static void main(String [] args){
		Scanner c = new Scanner(System.in);
		System.out.print("Digite um número -> ");
		int num = c.nextInt();
		System.out.println(" = " + somaMenor(num));
	}
}
