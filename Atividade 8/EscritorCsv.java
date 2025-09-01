import java.io.*;
import java.util.*;

public class EscritorCsv {
    
    // Escrita sequencial
    public void escreverSequencial(String caminho, String[] campos) throws IOException {
        String separador = ","; // <-- DEFINIR O SEPARADOR AQUI
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            bw.write(String.join(separador, campos));
            bw.newLine();
        }
    }

    // Escrita aleatória por linha
    public void escreverLinha(String caminho, int numeroLinha, String[] campos) throws IOException {
        String separador = ","; // <-- DEFINIR O SEPARADOR AQUI
        List<String[]> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.split(separador));
            }
        }

        if (numeroLinha >= 0 && numeroLinha < linhas.size()) {
            linhas.set(numeroLinha, campos);
        } else if (numeroLinha == linhas.size()) {
            linhas.add(campos);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String[] linha : linhas) {
                bw.write(String.join(separador, linha));
                bw.newLine();
            }
        }
    }
    
    public void substituirTexto(String caminho, String antigo, String novoTexto) throws IOException {
        String separador = ","; // <-- DEFINIR O SEPARADOR AQUI
        List<String> linhasAtualizadas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhasAtualizadas.add(linha.replace(antigo, novoTexto));
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String linha : linhasAtualizadas) {
                bw.write(linha);
                bw.newLine();
            }
        }
    }
}
