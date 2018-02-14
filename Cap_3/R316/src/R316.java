import java.util.Random;

public class R316 {
	
	public static void removeAleatorio(int[] A){
		Random rand = new Random();
		int size = A.length;
		int x;
		while(size != 0){
			x = rand.nextInt(A.length-1);
			if(A[x] != -1) {
				A[x] = -1;
				size--;
				imprime(A);
			}
		}
	}
	
	public static void imprime(int[] A){
		System.out.print("[");
		for(int i=0; i<A.length; i++)
			System.out.print(A[i]);
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		imprime(A);
		removeAleatorio(A);
		imprime(A);
	}
}
