public class C12{

	public boolean temPar(int [] A){
		for(int i=0; i<A.length; i++)
			for(int j=0; j<A.length; j++)
				if(i != j && ((A[i] * A[j]) % 2) == 0)
					return true;
		return false; 
	}

	public static void main(String[] args){
		int[] A = {1,5,3,1};
		C12 c12 = new C12();
		System.out.println(c12.temPar(A));
	}
}
