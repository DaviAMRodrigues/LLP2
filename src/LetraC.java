/* Aluno: Davi Augusto Marçal Rodrigues
 * T: T2
 * Data: 03/04/2025
 */
public class LetraC {
    public static void main(String[] args) {
        //Imprime os valores em inteiros.
        char[] vetor = {'A', 'B', 'C', 'a', 'b', 'c', '0', '1', '2', '$', '*', '+', '/', ' '};
        for(int i = 0; i < 14; i++){
            System.out.printf("O caractere %c tem o valor %d\n", vetor[i], ((int)vetor[i]));
        }
    }
}
