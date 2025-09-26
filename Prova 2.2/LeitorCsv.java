import java.io.*;
import java.util.*;

public class LeitorCsv {
    private List<String[]> linhas;

    public LeitorCsv() {
        linhas = new ArrayList<>();
    }

    // Leitura sequencial
    public void lerSequencial(String caminho) throws IOException {
        String separador = ","; // <-- DEFINIR O SEPARADOR AQUI
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(separador);
                System.out.println(Arrays.toString(campos));
            }
        }
    }

    // Leitura aleatória por linha
    public String[] lerLinha(String caminho, int numeroLinha) throws IOException {
        String separador = ","; // <-- DEFINIR O SEPARADOR AQUI
        if (linhas.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    linhas.add(linha.split(separador));
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
