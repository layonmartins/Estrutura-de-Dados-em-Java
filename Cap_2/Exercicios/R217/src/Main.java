
public class Main {

	public static class Pair<K,V>{
		K key;
		V value;
		
		public Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
		
//		public void setPair(K key, V value){
//			this.key = key;
//			this.value = value;
//		}
		
		
		public String toString(){
			return "[" + key +"] = " + value;
		}
	}
	
	public static void main(String args[]) {
		
		Pair<Integer,String> pair1 = new Pair<>(00, "7");
		Pair<Float,Long> pair2 = new Pair<Float, Long>(35.8F, 12888890L);
		Pair<String, Integer> pair3 = new Pair<String, Integer>("Layon", 24);
		Pair<Integer, Double> pair4 = new Pair<>(3, 0.14);
		Pair<Character, Boolean> pair5 = new Pair<>('c', false);
			//pair5.setPair('c', false); // caso tiver este métdo assima, pode ser feito dessa forma.
		
		System.out.println(pair1.toString());
		System.out.println(pair2.toString());
		System.out.println(pair3.toString());
		System.out.println(pair4.toString());
		System.out.println(pair5.toString());

	}

}
