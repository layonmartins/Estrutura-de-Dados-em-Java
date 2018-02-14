import java.util.Random;

public class Main {

	public static void main(String args[]){
		Random rand = new Random();
		rand.setSeed(92);
		int a = 12; int b = 5; int n = 100; int cur;
		int[] V = new int[5];
		
		for(int i = 0; i < 5; i++){
			cur = rand.nextInt(n);
			V[i] = (a * cur + b) % n;
		}		
		for(int i = 0; i < 5; i++)
			System.out.print(V[i] + ", ");
	}
}
