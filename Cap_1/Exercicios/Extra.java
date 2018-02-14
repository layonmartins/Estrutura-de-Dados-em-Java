import java.util.*;;

public class Extra{
	public static int somaMenor(int n){
	
		int soma=0;
		boolean primo = true;

		for(int j=n; j>1; j--){
			for(int i = j-1; i > 1; i--)
				if(j % i == 0) primo = false;
			if(primo){
				soma += j;
				System.out.print(" + " + j);
			}
			primo = true;

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
