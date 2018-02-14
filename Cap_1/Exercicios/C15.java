public class  C15{

	public static int soma=0;

	public static void main(String[] args){
		permuta();
		System.out.println("Soma total: " + soma);
	}

	public static void permuta(){
		char[] caracteres = {'c','a','r','b','o','n'};
		char p1, p2, p3, p4, p5, p6;

		for(int n1=0; n1 <= 5; n1++){
			p1 = caracteres[n1];
			for(int n2=0; n2 <= 5; n2++){
				p2 = caracteres[n2];
				for(int n3=0; n3 <= 5; n3++){
					p3 = caracteres[n3];
					for(int n4=0; n4 <= 5; n4++){
						p4 = caracteres[n4];
						for(int n5=0; n5 <= 5; n5++){
							p5 = caracteres[n5];
							for(int n6=0; n6 <= 5; n6++){
								p6 = caracteres[n6];
								imprime(p1, p2, p3, p4, p5, p6);
							}
						}
					}
				}
			}
		} 
	}

	public static void imprime(char p1, char p2, char p3, char p4, char p5, char p6){
		char[] caracteres = {p1, p2, p3, p4, p5, p6};
		if(!temIgual(caracteres)){
			for(int i=0; i<caracteres.length; i++)
				System.out.print("[" + caracteres[i] + "]");
		soma++;
		System.out.println("");
		}
		
	}	

	public static boolean temIgual(char[] caracteres){
		for(int i=0; i<caracteres.length-1; i++)
			for(int j=i+1; j<caracteres.length; j++)
				if(caracteres[i] == caracteres[j])
					return true;
		return false;
	}
}
