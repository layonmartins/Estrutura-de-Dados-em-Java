
public class RaizProgression extends Progression{

	RaizProgression(){
		this(65.536);
	}
	
	RaizProgression(double d){
		cur = first = d;
	}
	
	
	public double nextValue(){
		cur = Math.sqrt(cur);
		return cur;
	}
	public static void main(String[] args) {
		Progression p = new RaizProgression();
		p.printProgression(10);
	}

}
