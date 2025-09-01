import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SubstituiPalavra {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java PesquisaArquivo <nome_do_arquivo>");
            return;
        }

        String nomeDoArquivo = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeDoArquivo + ".tmp"))) {
                Scanner scanner = new Scanner(System.in);

                String palavraProcurada;
                String palavraSubstituta;
                String linha;
    
                System.out.println("Digite a palavra a ser substituida:");
                palavraProcurada = scanner.nextLine();
                System.out.println("Digite a nova palavra escrita no lugar:");
                palavraSubstituta = scanner.nextLine();
                
    
                while ((linha = br.readLine()) != null) {
                    if (linha.contains(palavraProcurada)) {
                        linha = linha.replace(palavraProcurada, palavraSubstituta);
                    }
                    bw.write(linha);
                    bw.newLine();
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("Erro ao abrir ou escrever no arquivo temporário: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Erro ao abrir ou ler o arquivo: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo + ".tmp"))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeDoArquivo))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    bw.write(linha);
                    bw.newLine();
                }
                System.out.println("Arquivo \"" + nomeDoArquivo + "\" atualizado com sucesso.");
            } catch (IOException e) {
                System.out.println("Erro ao abrir ou escrever no arquivo temporário: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Erro ao abrir ou ler o arquivo: " + e.getMessage());
        }

        try {
            java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(nomeDoArquivo + ".tmp"));
        } catch (IOException e) {
            System.out.println("Erro ao excluir o arquivo temporário: " + e.getMessage());
        }
    }
}
