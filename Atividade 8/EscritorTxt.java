import java.io.*;
import java.util.*;

public class EscritorTxt {

    // Escrita sequencial (adiciona ao final)
    public void escreverSequencial(String caminho, String texto) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            bw.write(texto);
            bw.newLine();
        }
    }

    // Escrita aleatória por linha (sobrescreve linha específica)
    public void escreverLinha(String caminho, int numeroLinha, String novoConteudo) throws IOException {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        }

        if (numeroLinha >= 0 && numeroLinha < linhas.size()) {
            linhas.set(numeroLinha, novoConteudo);
        } else if (numeroLinha == linhas.size()) {
            linhas.add(novoConteudo); // adiciona nova linha se for na próxima
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String l : linhas) {
                bw.write(l);
                bw.newLine();
            }
        }
    }
    
    public void substituirTexto(String caminho, String antigo, String novoTexto) throws IOException {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.replace(antigo, novoTexto));
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        }
    }
}
