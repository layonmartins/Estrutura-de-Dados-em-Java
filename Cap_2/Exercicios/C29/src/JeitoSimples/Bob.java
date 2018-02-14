package JeitoSimples;

public class Bob implements Observer{

	@Override
	public void update(String msn) {
		System.out.println(msn);
	}

}
