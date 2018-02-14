
public class Main {
	
	public static int contVogais(String s){
		int cont = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || 
			   s.charAt(i) == 'i' || s.charAt(i) == 'o' || 
			   s.charAt(i) == 'u')
				cont++;
		}
		return cont;
	}
	
	public static int RecContVogais(String s){
		if(s.isEmpty()) 
			return 0;
		
		if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || 
		   s.charAt(0) == 'i' || s.charAt(0) == 'o' || 
		   s.charAt(0) == 'u')
				return 1 + RecContVogais(s.substring(1));
		return 0 + RecContVogais(s.substring(1));
	}

	public static void main(String[] args) {
		System.out.println(RecContVogais("abcdefghijklmnopqrstuvwxyz"));
		
		//String s = "Layon";
		//System.out.println(s.substring(0, s.length()-1));
	}

}
