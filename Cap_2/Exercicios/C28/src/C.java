
public class C extends B{
	public int x = 3;
	
	public int getX(){
		return x;
	}
	
	
	public int getXdeA(){
		return super.getXdeA();
	}
	
	public static void main(String[] args) {
		
		C ce = new C();
		
		System.out.println(ce.getXdeA());
		System.out.println(ce.getX());
	}
}
