
public class R111 {


        public boolean isEven(int i){ //recebe um inteiro
                String n = Integer.toString(i); //converto esse inteiro para String
                char ultimo = n.charAt(n.length()-1); //paga o ultimo caracter como um tipo char
                int u = Character.getNumericValue(ultimo); //converte esse char para int
                
                if(u == 0 || u == 2 || u == 4 || u == 6 || u == 8) //se for alguns destes é par
                      return true;
                else return false;
        }
        
        public boolean isEven2(int i){ //recebe um inteiro
            String n = Integer.toString(i); //converto esse inteiro para String
            char u = n.charAt(n.length()-1); //paga o ultimo caracter como um tipo char
            
            if(u == '0' || u == '2' || u == '4' || u == '6' || u == '8') //se for alguns destes é par
                  return true;
            else return false;
    }
        
	public static void main(String[] args) {
		R111 teste = new R111();
        System.out.println(teste.isEven2(2));

	}

}
