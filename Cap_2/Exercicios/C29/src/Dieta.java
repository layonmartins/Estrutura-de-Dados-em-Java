import java.util.ArrayList;
import java.util.List;

public class Dieta implements Observable{ //classe que é observada
	
	private List<Observer> observers = new ArrayList<Observer>(); //contem uma lista dos objetos que a observa.
	private double peso; //suas proprias variaveis
	
	//construtor
	public Dieta(double peso){
		this.peso = peso;
	}
	
	//metodo sets
	public void setPeso(double peso){
		this.peso = peso;
		//quando a alteração do peso ocorrer, esse é o momento certo hahaha!
		this.notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		// Esse é o cara
		// chama o método de atualização de todos os observers disponíveis.
		for (Observer ob: observers) {
			System.out.println("Norificando observers!");
			ob.update(this.peso);
		}
	}

}
