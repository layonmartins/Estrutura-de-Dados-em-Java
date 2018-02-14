import java.util.*;

public class Main {

	public static boolean formArith(){
		Scanner t = new Scanner(System.in);
		System.out.print("Digite uma sequencia com 3 números -> ");
		int a = t.nextInt();
		int b = t.nextInt();
		int c = t.nextInt();
		
		if ((a + b == c) || (a == b - c))
			return true;
		if (a * b == c)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(formArith());
	}

}
