package JeitoSimples;

public class Alice implements Subject{
	
	Bob bob = new Bob();
	
	String msn = "";
	
	public void setMsn(String txt){
		this.msn = txt;
		notificar();
	}

	@Override
	public void notificar() {
		bob.update(msn);
	}

}
