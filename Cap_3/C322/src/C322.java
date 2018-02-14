
public class C322 {
	private static String temMais(String s, int i, int vogal, int cons){
		
		if(i==s.length())//caso base
			if(vogal > cons)
				return "vogal";
			else if(cons > vogal)
				return "consoante";
			else return "impate";
		
		char x = s.charAt(i);
		if(x=='a'||x=='e'||x=='i'||x=='o'||x=='u')
			return temMais(s, i+1, vogal+1, cons);
		else return temMais(s, i+1, vogal, cons+1);
	}
	
	public static void main(String[] args) {
		System.out.println(temMais("layon", 0,0,0));
	}
}
