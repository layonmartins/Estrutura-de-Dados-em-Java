public class C11{
	public static int[] inverte(int [] a){
		int[] a2 = a.clone();
		int i = 0;
		for(int j = a.length - 1; j >= 0; j--){
			a[i] = a2[j];
			System.out.print("["+a[i]+"] ");
			i++;
		}
		System.out.println(":)");
		return a;
	}

	public static void main(String[] args){
		System.out.println("Array original -> 1,2,3,4,5\n");
		int[] array = {1, 2, 3, 4, 5};
		int[] array2 = inverte(array);
		System.out.println("array2[0]-> " + array2[0] + " array2[2]-> " + array[2] + "\n");
	}
}
