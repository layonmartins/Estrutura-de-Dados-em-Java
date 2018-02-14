package Node;

public class BubbleSorte {

	public static void main(String[] args) {
		int[] A = {4,1,3,2};
		
		for(int i = A.length - 1; i >= 0; i--)
			for(int j = 0; j < i; j++)
				if(A[j] > A[j+1]){
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
		
		for(int i : A)
			System.out.print(i + " ");
	}
}
