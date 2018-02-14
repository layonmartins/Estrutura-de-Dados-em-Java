
import java.util.*;

public class C16_2Versao{
        public static void main(String[] args){
                Scanner teclado = new Scanner(System.in);
                System.out.print("######## Programa inverte linhas 2° versão #########\n quantas linhas vai digitar -> ");
                int numLinhas = teclado.nextInt();
                C16_2Versao c16 = new C16_2Versao();
                c16.inverte(numLinhas);
        }

        public void inverte(int numLinhas){
                String[] linhas = new String[numLinhas];
                Scanner c = new Scanner(System.in);
                String linha, linhaInvertida = "";

                for(int i = 0; i < numLinhas; i++){
                        System.out.print("\nDigite uma linha-> ");
                        linha = c.nextLine();
                        for(int j=linha.length()-1; j>=0; j--)
                                linhaInvertida += linha.charAt(j);
                        linhas[i] = linhaInvertida;
                }

                System.out.println("\nLinhas invertidas:");
                for(int j=0; j < numLinhas; j++)
                        System.out.println("Linha["+ j + "] = " + linhas[j]);


        }
}

