
public class ModuleProgression extends Progression{
	//first
	protected long prev;
	//cur
	
	ModuleProgression(){
		this(2L, 200L);
	}
	
	ModuleProgression(long value1, long value2){
		first = value1;
		prev = value1 + value2;
	}
	
	protected long nextValue(){
		long temp = prev;
		prev = cur;
		cur = Math.abs(temp - cur);
		
		return cur;
	}
	
	public static void main(String[] args) {
		Progression mp = new ModuleProgression();
		mp.printProgression(10);

	}

}
