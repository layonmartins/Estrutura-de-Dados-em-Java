public class R43{
	public static int Power(int x,int n){
		if(n == 0) return 1;
		if(n % 2 != 0){
			int y = Power(x,(n-1)/2);
			return x * y * y;
		} else {
			int y = Power(x,n/2);
			return y * y;
		}
	}

	public static void main(String[] args){
		System.out.println("Power(2,4) = " + Power(2,4));
		System.out.println("Power(2,5) = " + Power(2,5));
		System.out.println("Power(2,8) = " + Power(2,8));
		System.out.println("Power(2,9) = " + Power(2,9));

	}

}
