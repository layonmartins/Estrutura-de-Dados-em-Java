
public class GeometricProgression extends Progression {
	protected long base;
	
	GeometricProgression(){
		this(2);
	}
	
	GeometricProgression(long b){
		base = b;
		first = 1;
		cur = first;
	}
	
	protected long nextValue(){
		cur *= base;
		return cur;
	}
	
	public static void main(String[] args){
		GeometricProgression g = new GeometricProgression();
		Progression p = g;
		p.printProgression(10);
		System.out.println(p.firstValue());
	}
}
