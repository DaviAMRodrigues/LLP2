import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class LerCSV {
    public ArrayList<Aluno> LerCSV() {
        String csvFile = "dados.csv";
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Aluno> alunos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Skip header line if present
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] alunoData = line.split(cvsSplitBy);
                Aluno aluno = new Aluno( Integer.parseInt(alunoData[0]), alunoData[1], alunoData[2]);
                alunos.add(aluno);
            }
            return alunos;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void escreverCSV(ArrayList<Aluno> alunos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter( "dados.csv"))) {
            bw.write("Numero,Matrícula,Nome\n"); 
            for (Aluno aluno : alunos) {
                bw.write(aluno.getNumero() + "," + aluno.getMatricula() + "," + aluno.getNome() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
