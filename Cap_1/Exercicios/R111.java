public class R111{
	public boolean isEven(int i){
		String n = Integer.toString(i);
		System.out.println(n);
		//char u = n[n.length-1];
		//if(u == 0 || u == 2 || u == 4 || u == 6 || u == 8)
		//	return true;
		//else return false;
	}

	public static void main(String[] args){
		R111 teste = new R111();
		System.out.println(teste.isEven(320));
	}
}
