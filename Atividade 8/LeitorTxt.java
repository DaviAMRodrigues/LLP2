import java.io.*;
import java.util.*;

public class LeitorTxt {
    private List<String> linhas;

    public LeitorTxt() {
        linhas = new ArrayList<>();
    }

    // Leitura sequencial
    public void lerSequencial(String caminho) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

    // Leitura aleatória por linha
    public String lerLinha(String caminho, int numeroLinha) throws IOException {
        if (linhas.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    linhas.add(linha);
                }
            }
        }

        if (numeroLinha >= 0 && numeroLinha < linhas.size()) {
            return linhas.get(numeroLinha);
        } else {
            return null;
        }
    }
}
