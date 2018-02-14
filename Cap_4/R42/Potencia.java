public class Potencia{

	public static int potencia(int x, int n){
		if(n == 1) return x;
		return x * potencia(x, n-1);
	}

	public static void main(String[] args){
		System.out.println(potencia(2,5));
	}
}
