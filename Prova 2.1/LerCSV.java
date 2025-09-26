package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class LerCSV {

    public void escreverCSV(ArrayList<Pessoal> pessoas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter( "pessoal.csv"))) {
            for (Pessoal pessoa : pessoas) {
                bw.write(pessoa.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
