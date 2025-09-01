import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PesquisaArquivo {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java PesquisaArquivo <nome_do_arquivo>");
            return;
        }

        String nomeDoArquivo = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))) {
            Scanner scanner = new Scanner(System.in);

            int contador = 1;
            boolean bandeira = false;
            String palavra;
            String linha;

            System.out.println("Digite a palavra a ser pesquisada:");
            palavra = scanner.nextLine();
            System.out.print("A palavra " + palavra + "aparece nas linhas ");

            while ((linha = br.readLine()) != null) {
                if (linha.contains(palavra)) {
                    if (bandeira) {
                        System.out.print(", ");
                    } else {
                        bandeira = true;
                    }
                    System.out.print(contador);
                }
                contador++;
            }
            System.out.println(".");
            scanner.close();
        } catch (IOException e) {
            System.out.println("Erro ao abrir ou ler o arquivo: " + e.getMessage());
        }
        
    }

}