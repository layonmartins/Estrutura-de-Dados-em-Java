import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreditCard{
	//Variáveis de instância:
	private String number;
	private String name;
	private String bank;
	private double balance;
	private int limit;

	//Construtor:
	CreditCard(String no, String nm, String bk, double bal, int lim){
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
	
	//Métodos modificadores
	public void setNumber(String number){this.number = number;}
	public void setName(String name){this.name = name;}
	public void setBank(String bank){this.bank = bank;}
	public void setBalance(double balance){this.balance = balance;}
	public void setLimit(int limit){this.limit = limit;}
	

	//Métodos de ação
	public boolean chargeIt(double price) { //Debita
		if(price + balance > (double) limit)
			return false; //Não há dinheiro suficiente para debitar
		balance +=price;
		return true; //Neste caso, o débito foi efetivado
	}
	
	public void makePayment(double payment, Date vencimento) { //Faz um pagamento
		
		Date atual = new Date();
		if(atual.after(vencimento)){		
		double juros = payment * 0.1;
		payment += juros;
		balance -= payment;
		System.out.println("\nPagamento efetuado :) ");
		} else {
			System.out.println("Pagamento com atrazo, foi cobrado uma taxa de 20%!");
			double taxa = payment * 0.2;
			payment += taxa;
			balance -= payment;
			System.out.println("\nPagamento efetuado :) ");
		}

	}

	public static void printCard(CreditCard c) { //Imprime informações sobre o cartão
		System.out.println("Number = " + c.getNumber());
		System.out.println("Name = " + c.getName());
		System.out.println("Bank = " + c.getBank());
		System.out.println("Balance = " + c.getBalance()); //Conversão implícita
		System.out.println("Limit = " + c.getLimit()); //Conversão implícita
	}

	public static void main(String[] args) throws ParseException{
		CreditCard bancoke = new CreditCard("BK01", "Layon Martins",  "Bancoke", 1000.0, 4000);
		System.out.println("\nCartão criado com sucesso: ");
		printCard(bancoke);
		bancoke.chargeIt(1000.0);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = formato.parse("23/11/2015");
		Date data2 = formato.parse("23/11/2017");
		
		bancoke.makePayment(500.0, data1);
		bancoke.makePayment(500.0, data2);
		printCard(bancoke);
	}
}