
public class Main {

	
	public static void teste(){
		int x = 0;
		int y = 0;
		
		try{
			x = x / 0;
			y = y + 1;
		} catch (Exception e) {
			
		}
		
		System.out.println(x + y);
		
	}
	
	public static void main(String[] args) {
		teste();
	}

}
