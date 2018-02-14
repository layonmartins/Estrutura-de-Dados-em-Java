
public class C321 {
	public static void main(String[] args) {
		System.out.println(palindromo("a", 0));
	}
	
	private static boolean palindromo(String s, int i){
		if(i == (s.length()/2)-1){
			if(s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
			else return true;
		}
		return palindromo(s, i+1);
	}
}
