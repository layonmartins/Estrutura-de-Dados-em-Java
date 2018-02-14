
public class Main {

	public static int[] copia1(int[] A){
		int[] B = new int[A.length];
		for(int i=0; i<A.length; i++)
			B[i] = A[i];
		return B;		
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		//int[] B = copia1(A);
		//int[] B = java.util.Arrays.copyOf(A, A.length);
		//int[] B = A.clone();
		int[] B = new int[A.length];
		System.arraycopy( A, 0, B, 0, A.length );
		
		for(int i=0; i<5; i++)
			System.out.println("B[" + i + "]= " + B[i]);
	}

}
