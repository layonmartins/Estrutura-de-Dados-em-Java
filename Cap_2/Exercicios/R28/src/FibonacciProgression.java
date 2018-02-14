
public class FibonacciProgression extends Progression {
		long prev;
		//herda first and cur
		FibonacciProgression(){
			this(0,1);
		}

		FibonacciProgression(long value1, long value2){
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
			Progression fibonacci = new FibonacciProgression(2,2);
			//fibonacci.printProgression(8);
			System.out.println("Elemento da oitava posição: " + fibonacci.getValue(8));
		}
	}