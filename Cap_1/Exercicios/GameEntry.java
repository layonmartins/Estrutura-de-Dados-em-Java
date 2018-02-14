public class GameEntry{
	public int score;

	public static void main(String[] args){
		GameEntry[] A = new GameEntry[10];
		A[4] = new GameEntry();
		GameEntry[] B = A.clone();
		A[4].score = 550;
		System.out.println("A[4]: " + A[4].score);
		System.out.println("B[4]: " + B[4].score);
	}
}
