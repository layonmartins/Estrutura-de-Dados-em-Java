import java.io.*;
import java.util.Scanner;

public class InputAllBaseTypes {
	
	//Esse aqui ele pede para digitar varios tipos, um de cada vez e depois imprime tudo.
	public void separados(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Digite um boolean -> ");
		boolean boolea = s.nextBoolean();

		System.out.print("Digite um char -> ");
		char cha = s.next().charAt(0);
		
		System.out.print("Digite um byte -> ");
		byte byt = s.nextByte();
		
		System.out.print("Digite um short -> ");
		short shor = s.nextShort();
		
		System.out.print("Digite um int -> ");
		int in = s.nextInt();
		
		System.out.print("Digite um long -> ");
		long lon = s.nextLong();
		
		System.out.print("Digite um float -> ");
		float floa = s.nextFloat();
		
		System.out.print("Digite um double -> ");
		double doubl = s.nextDouble();
		
		
		System.out.println("Int => " + in);
		System.out.println("char => " + cha);
		System.out.println("Byte => " + byt);
		System.out.println("Short => " + shor);
		System.out.println("Int => " + in);
		System.out.println("Long => " + lon);
		System.out.println("Float => " + floa);
		System.out.println("Double => " + doubl);
		
	}
	
	//Não fuiciona direito,
	//queria perdir para ele digitar varios tokens (maximo 10) e depois ir salvando num array usando while.
	//tive que fazer uma gambiarra, falando para digitar 0(zero) para sair do while.
	// isso deve ser pq ele lê o enter como um token, e continua execudando o while.
	public void junto(){
		
		Scanner c = new Scanner(System.in);
		String[] tokens = new String[10];
		int i = 0;
		
		System.out.print("Digite até 10 tokens => ");
	
		while(c.hasNext()){
			tokens[i] = c.next();
			i++;
			if(c.hasNextInt()){
				if(c.nextInt() == 0)
					break;
			}
		}
		
		for(int x=0; x <= tokens.length-1; x++){
			System.out.println("token[" + x + "]: " + tokens[x]);
		}
		
	}
	
	public static void main(String[] args){
		
		InputAllBaseTypes inputAll = new InputAllBaseTypes();
		inputAll.junto();
	}
}
