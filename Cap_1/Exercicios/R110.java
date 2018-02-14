public class R110{

	public static boolean isMultiple(long n, long m){
		if(n % m == 0) return true;
		else return false;
	}

	//teste
	public static void main(String[] args){
		System.out.println(isMultiple(7, 2));
	}
}
