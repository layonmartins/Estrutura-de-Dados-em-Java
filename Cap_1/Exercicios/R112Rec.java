import java.util.*;;

public class R112Rec{
	public static Integer sumToN(Integer n){
		if(n == 1) return 1;
		else return (n -1 + sumToN(n-1));
	}	

	public static void main(String [] args){
		Scanner c = new Scanner(System.in);
		System.out.print("Digite um número -> ");
		int num = c.nextInt();
		System.out.println(" = " + sumToN(num));
	}
}
