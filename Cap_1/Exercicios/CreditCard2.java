public class CreditCard2{
	//Variáveis de instância:
	private String number;
	private String name;
	private String bank;
	private double balance;
	private int limit;

	//Construtor:
	CreditCard2(String no, String nm, String bk, double bal, int lim){
		number = no;
		name = nm;
		bank = bk;
		balance = bal;
		limit = lim;
	}

	//Métodos de acesso:
	public String getNumber() {return number;}
	public String getName() {return name;}
	public String getBank() {return bank;}
	public double getBalance() {return balance;}
	public int getLimit() {return limit;}

	//Métodos de ação
	public boolean chargeIt(double price) { //Debita
		if(price + balance > (double) limit)
			return false; //Não há dinheiro suficiente para debitar
		balance +=price;
		return true; //Neste caso, o débito foi efetivado
	}
	
	public void makePayment(double payment) { //Faz um pagamento
		double juros = payment * 0.1;
		payment += juros;
		balance -= payment;
		System.out.println("\nPagamento efetuado :) ");

	}

	public static void printCard(CreditCard2 c) { //Imprime informações sobre o cartão
		System.out.println("Number = " + c.getNumber());
		System.out.println("Name = " + c.getName());
		System.out.println("Bank = " + c.getBank());
		System.out.println("Balance = " + c.getBalance()); //Conversão implícita
		System.out.println("Limit = " + c.getLimit()); //Conversão implícita
	}

	public static void main(String[] args){
		CreditCard2 bancoke = new CreditCard2("BK01", "Layon Martins",  "Bancoke", 1000.0, 4000);
		System.out.println("\nCartão criado com sucesso: ");
		printCard(bancoke);
		bancoke.chargeIt(1000.0);
		bancoke.makePayment(500.0);
		bancoke.makePayment(500.0);
		printCard(bancoke);
	}
}
