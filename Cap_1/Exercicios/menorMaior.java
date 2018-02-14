public class menorMaior{
	
	public static void menorMaior(int[] arranjo){

		int maior = arranjo[0];
		int menor = maior;

		for(int i=0; i<arranjo.length; i++){
			if(maior < arranjo[i])
				maior = arranjo[i];
			if(menor > arranjo[i])
				menor = arranjo[i];		
		}
		System.out.println("Maior -> " + maior);
		System.out.println("Menor -> " + menor);
	}

	public static void main(String[] args){
	
		int[] num = {2,3,7,5,8,7,18,1};
		menorMaior(num);
	}
}
