import java.math.BigInteger;

public class Progression {
	protected BigInteger first;
	protected BigInteger cur;
	
	Progression(){
		cur = first = new BigInteger("0");
	}
	
	protected BigInteger firstValue(){
		cur = first;
		return cur;
	}
	
	protected BigInteger nextValue(){
		return cur.add(BigInteger.ONE);
	}
	
	public void printProgression(int n){
		System.out.print(firstValue());
		for(int i = 2; i <= n; i++)
			System.out.print(" " + nextValue());
		System.out.println();
	}
}
