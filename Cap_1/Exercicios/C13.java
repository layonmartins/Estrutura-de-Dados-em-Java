public class C13{
	public static boolean allDistinct(int[] A){
		for(int n=0; n<A.length-1; n++) //não precisa ir até o ultimo elemento do array(penúltimo)
			for(int i=n+1; i<A.length; i++)
				if(A[n] == A[i]) return false;
		return true;
	}

	public static void main(String[] args){
		int[] A = {2,0,3,4,7};
		System.out.println(allDistinct(A));
	}
}
