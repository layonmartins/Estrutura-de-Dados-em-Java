public class C17{
	public int[] produtoEscalar(int[] a, int[] b){
	
		int[] c = new int[a.length];
		if(a.length != b.length){	
			System.out.println("Os arranjos NÃO são do mesmo tamanho!");
		} else {
		for(int i = 0; i < a.length; i++)
			c[i] = a[i] * b[i];
		}
		return c;
	}

	public void imprime(int[] array){
		for(int i = 0; i < array.length; i++)
			System.out.print("[" + array[i] + "]");
	}

	public static void main(String[] args){	
		int [] a = {1,2,3,4,5};
		int [] b = {1,2,3,4,5};
		int [] c = {1,2,3,4};
	
		C17 c17 = new C17();
	
		System.out.println("Imprimindo os arranjos: \n");
		c17.imprime(a);
		System.out.println("");
		c17.imprime(b);
		System.out.println("");
		c17.imprime(c);

		int [] produto = c17.produtoEscalar(a, b);
		int [] produto2 = c17.produtoEscalar(a, c);
			
		System.out.print("\nProduto 1: ");
		c17.imprime(produto);
	
		System.out.print("\nProduto 2: ");
		c17.imprime(produto2);

	}
}
