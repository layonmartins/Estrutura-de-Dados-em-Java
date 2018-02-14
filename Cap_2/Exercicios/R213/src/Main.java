
public class Main {

	public static void main(String[] args) {
		int[] a = new int[10];
		try{
			System.out.println(a[-1]);
		}catch(Exception e){
			System.out.println("Don't try buffer overflow attacks in Java!");
			System.out.println(e);
		} 
	}
}
