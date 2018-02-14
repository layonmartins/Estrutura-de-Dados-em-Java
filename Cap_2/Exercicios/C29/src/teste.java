
public class teste {

	public static void main(String[] args) {
		
		Dieta dieta = new Dieta(50);
		
		BalancaDieta balancaDieta1 = new BalancaDieta();
		BalancaDieta balancaDieta2 = new BalancaDieta();
		
		dieta.registerObserver(balancaDieta1);
		dieta.registerObserver(balancaDieta2);
		
		dieta.setPeso(80);

	}

}
