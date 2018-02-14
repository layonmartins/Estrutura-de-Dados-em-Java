public class R28 {
	protected long first;
	protected long cur;

	R28(){
		cur = first = 0;
	}

	protected long firstValue(){
		cur = first;
		return cur;
	}

	protected long nextValue(){
		return ++cur;
	}

	public void printR28(int n) {
		System.out.print(firstValue());
		for(int i = 2; i <= n; i++)
			System.out.print(" " + nextValue());
		System.out.println();
	}

	//Classe aninhada:

	public class FibonacciR28 extends R28 {
		long prev;
		//herda first and cur
		FibonacciR28(){
			this(0,1);
		}

		FibonacciR28(long value1, long value2){
			first = value1;
			prev = value2 - value1;
		}

		protected long nextValue() { //Avança a progressão somando o valor anterior no valor atual.
			long temp = prev;
			prev = cur;
			cur += temp;
			return cur;
		}

		public static void main(String[] args){
			R28 fibonacci = new FibonacciR28();
			fibonacci.printR28(8);
		}

	}
}
