
public class Teste {

	public static void main(String[] args) {
		//int[] A = {1,2,3};
		//int[] B = {1,2,3};
		
		int[][] A = {{1,2}, {2,3} ,{3,4}};
		int[][] B = {{1,2}, {2,3} ,{3,4}};

		if(java.util.Arrays.deepEquals(A,B))
			System.out.println("sim");
		else 
			System.out.println("não");
	}

}
