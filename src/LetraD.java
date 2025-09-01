/* Aluno: Davi Augusto Marçal Rodrigues
 * T: T2
 * Data: 03/04/2025
 */

import java.util.Scanner;
public class LetraD {
    public static void main(String[] args) {
        double altura, peso;
        //Abre a entrada.
        Scanner entrada1 = new Scanner(System.in);

        //Coleta a altura e massa do usuario.
        System.out.println("Digite seu peso em quilogramas(kg):");
        peso = entrada1.nextDouble();
        entrada1.nextLine();
        System.out.println("Digite sua altura em metros(m):");
        altura = entrada1.nextDouble();

        //Calcula o IMC.
        double imc;
        imc = peso/(altura*altura);

        //Imprime a tabela IMC.
        System.out.println("Valores IMC:\nMAGREZA:\tMENOR QUE 18,5\nNORMAL:\t\tENTRE 18,5 E 24,9\nSOBREPESO:\tENTRE 25,0 E 29,9\nOBESIDADE:\t30,0 OU MAIOR.");
        
        //Verifica e imprime o indice corporal.
        System.out.println("\nSEU ÍNDICE DE MASSA CORPORAL (IMC) É:");
        if(imc <18.5){
            System.out.println("MAGREZA");
        }
        else if(imc <25 && imc >= 18.5){
            System.out.println("NORMAL");
        }
        else if(imc <30 && imc >= 25){
            System.out.println("SOBREPESO");
        }
        else{
            System.out.println("OBESIDADE");
        }

        //Fechada a entrada.
        entrada1.close();
    }
}
