import java.util.Random;

public class C14{
	
	public static void embaralha(int[] A){
		int r = 0;
		Random ran = new Random(); //para gerar o n° aleatório de igual probabilidade.
		int[] B = new int[A.length];

		for(int j=0; j<A.length; j++){
			do
			  r = ran.nextInt(A.length);
			while(B[r] != 0);
			B[r] = A[j];	
		}
		
		imprimeArray(A);
		System.out.println("\nArray modificado:");
		imprimeArray(B);
	}	

	public static void imprimeArray(int [] A){
		for(int x=0; x<A.length; x++)
			System.out.print("[" + A[x] + "]");
	}
	
	public static void main(String[] args){
		int[] A = new int[52];
		for(int x=0; x<52; x++)
			A[x] = x+1;
		embaralha(A);	
		System.out.println("\n");

	}
}
