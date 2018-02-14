public class Maryland extends State{
	Maryland(){ }
	public void printMe(){ System.out.println("Read it."); }

	public static void main(String[] args){
		Region mid = new State();
		State md = new Maryland();
		Object obj = new Place();
		Place usa = new Region();
		md.printMe();
		mid.printMe();
		((Place) obj).printMe();
		obj = md;
		((Maryland) obj).printMe();
		obj = usa;
		((Place) obj).printMe();
		usa = md;
		((Place) usa).printMe();
	}

	class State extends Region{
		State() { }
		public void printMe() { System.out.println("Ship it."); }
	}

	class Region extends Place{
		Region() { }
		public void printMe(){ System.out.println("Box it."); }
	}

	class Place extends Object{
		Place() { }
		public void printMe(){ System.out.println("Buy it."); }
	}
}
