import java.util.Random;

public class C32 {
	public static void main(String[] args){
		Random r = new Random();
		int[] A = new int[100];
		int x = 0; //produto
		for(int i = 0; i < A.length; i++){
			A[i] = r.nextInt(10);
			x *= A[i];
			System.out.print(" " + A[i]);
		}
		System.out.println("\nproduto = " + x);
	}
}
