public class Progression {
	
	protected long first;
	protected long cur;

	Progression(){
		cur = first = 0;
	}

	protected long firstValue(){
		cur = first;
		return cur;
	}

	protected long nextValue(){
		return ++cur;
	}

	public void printProgression(int n) {
		System.out.print(firstValue());
		for(int i = 2; i <= n; i++)
			System.out.print(" " + nextValue());
		System.out.println();
	}
	
	public long getValue(int n) {
		firstValue();
		long prov = 0;
		for(int i = 1; i < n; i++)
			prov = nextValue();
		return prov;
	}
	
}