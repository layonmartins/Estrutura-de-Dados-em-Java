
public class C317 {

	private static String MaiorMenor(int[] A, int maior, int menor, int n){
		
		if(n >= A.length) //caso base
			return "Maior= " + A[maior] + " Menor= " + A[menor]; 
		
		if(A[n] > A[maior]) maior = n;
		if(A[n] < A[menor]) menor = n;
		
		return MaiorMenor(A, maior, menor, n+1);
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		
		System.out.println(MaiorMenor(A, A[0], A[0], 0));
	}

}
