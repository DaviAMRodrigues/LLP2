/* Aluno: Davi Augusto Marçal Rodrigues
 * T: T2
 * Data: 03/04/2025
 */
import java.util.Scanner;
public class LetraA {
    public static void main(String[] args) {

        int numero;
        //Abre a entrada
        Scanner entrada1 = new Scanner(System.in);

        //Imprime um texto e coleta a entrada.
        System.out.println("Digite um numero:");
        numero = entrada1.nextInt();

        //Transforma o inteiro em uma String
        String textoNumero = Integer.toString(numero);

        /*Transforma a String contendo o numero em um array de caracteres.
         * Depois o tamanho do array, joga em um for e imprime cada numero separados por " ".
         */
        char[] numerosSeparados = textoNumero.toCharArray();
        int tamanho = textoNumero.length();
        for (int i = 0; i<tamanho; i++){
    
            System.out.print(numerosSeparados[i] + " ");

        }
        //Fecha a entrada.
        entrada1.close();
    }
}
