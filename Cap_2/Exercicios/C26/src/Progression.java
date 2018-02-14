
public class Progression {
	protected double first;
	protected double cur;
	
	Progression(){
		cur = first = 0;
	}
	
	protected double firstValue(){
		cur = first;
		return cur;
	}
	
	protected double nextValue(){
		return ++cur;
	}
	
	public void printProgression(int n){
		System.out.print(firstValue());
		for(int i = 2; i <= n; i++)
			System.out.print(" " + nextValue());
		System.out.println();
	}
}
