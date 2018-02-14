public class Flower{
	//variáveis de instância
	private String nome;
	private int petalas;
	private float preco;

	//Construtor inicializando as variáveis
	public Flower(String nome, int petalas, float preco){
		this.nome = nome;
		this.petalas = petalas;
		this.preco = preco;
	}

	//Métodos de acesso
	public String getNome(){ return nome;}
	public int getPetalas(){ return petalas;}
	public float getPreco(){ return preco;}

	//Métodos de modificação
	public void setNome(String nome){ this.nome = nome;}
	public void setPetalas(int petalas){ this.petalas = petalas;}
	public void setPreco(float preco){this.preco = preco;}

	//teste
	public static void main(String[] args){
		
		System.out.println("Pragrama flores :)");

		//Criando as flores
		Flower flor1 = new Flower("Rosa", 5, 2.00F);
		Flower flor2 = new Flower("violeta", 8, 3.00F);
		Flower flor3 = new Flower("Margarida", 10, 8.00F);
	
		//Exibindo informção da flor 1
		System.out.println("Flor: " + flor1.getNome() + " petalas: " + flor1.getPetalas() +  " preço: " + flor1.getPreco());
		
		//Alterando valores da flor
		System.out.println("Alterando a flor");
		flor1.setPetalas(6);
		flor1.setPreco(3.50F);
	
		//Reexibindo informção da flor 1
		System.out.println("Flor: " + flor1.getNome() + " petalas: " + flor1.getPetalas() + " preço: " + flor1.getPreco());

	}
}
