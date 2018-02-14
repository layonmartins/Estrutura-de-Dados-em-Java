
public class C318 {
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		
		System.out.println(verifica(0,1,2,A));
	}
	
	private static int verifica(int j, int k, int i, int[] A){
		if(i == A.length) 
			return -1;
		if(A[i] == A[j] + A[k])
			return A[i];
		else
			return verifica(j+1, k+1, i+1, A);
	}
}
