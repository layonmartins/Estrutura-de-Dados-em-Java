
public class C320 {
	public static void contrario(String s, int n){
		if(n >= 0){
			System.out.print(s.charAt(n));
			contrario(s, n-1);
		}
	}
	
	public static void main(String[] args) {
		contrario("layon", "layon".length()-1);
	}
}
