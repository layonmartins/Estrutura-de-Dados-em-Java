
public class ArithProgression extends Progression{
	protected long inc;
	
	ArithProgression(){
		this(1);
	}
	
	ArithProgression(long increment){
		inc = increment;
	}
	
	protected long nextValue(){
		cur += inc;
		return cur;
	}
	
	public static void main(String[] args) {
		Progression arith = new ArithProgression(128);
		arith.printProgression(10);

	}

}
