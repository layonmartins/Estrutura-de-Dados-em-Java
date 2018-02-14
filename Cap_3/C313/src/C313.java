
public class C313 {

	public static void main(String[] args) {
		int discos = 3;
		hanoi(discos, 'A', 'B', 'C');
	}
	
	private static void hanoi(int discos, char origem, char auxiliar, char destino){
		if(discos > 0){
			hanoi(discos-1, origem, destino, auxiliar);//Mover disco-1 da origem para auxiliar
			System.out.printf("Mover de %s para %s\n", origem, destino);//Escrever -> Origem para destino
			hanoi(discos-1, auxiliar, origem, destino);//Mover disco-1 do auxiliar para destino
		}
	}

}
