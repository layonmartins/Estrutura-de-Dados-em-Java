
public class Main {

	public String rmPont(String s){
		String nova = "";
		for(int i=0; i<s.length(); i++)
			if(s.charAt(i) != '.' && s.charAt(i) != ',' && s.charAt(i) != ';' &&
			   s.charAt(i) != '´' && s.charAt(i) != '\'' && s.charAt(i) != '!' && s.charAt(i) != '?')
				nova += s.charAt(i);
		return nova;
	}
	
	public String RecRmPont(String s){
		if(s.isEmpty()) return "";
		
		if(s.charAt(0) != '.' && s.charAt(0) != ',' && s.charAt(0) != ';' &&
		   s.charAt(0) != '´' && s.charAt(0) != '\'' && s.charAt(0) != '!' && s.charAt(0) != '?')
			return s.charAt(0) + RecRmPont(s.substring(1));
		else
			return RecRmPont(s.substring(1));
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.RecRmPont("Let's GOU!!!"));

	}

}
